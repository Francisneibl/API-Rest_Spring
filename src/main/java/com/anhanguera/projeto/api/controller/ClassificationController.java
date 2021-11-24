package com.anhanguera.projeto.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anhanguera.projeto.api.dto.input.ClassificationInputDTO;
import com.anhanguera.projeto.api.dto.output.ClassificationOutputDTO;
import com.anhanguera.projeto.domain.model.Classification;
import com.anhanguera.projeto.domain.service.ClassificationService;

@RestController
@RequestMapping("/classification")
public class ClassificationController {
	
	@Autowired
	private ClassificationService classificationService;

	@GetMapping
	public List<ClassificationOutputDTO> list() {
		List<Classification> classResult = classificationService.findAll();
		return new ClassificationOutputDTO().convertClassificationListToDTO(classResult);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClassificationOutputDTO toRank(@Valid @RequestBody ClassificationInputDTO vote) {
		
		Classification saved =  classificationService.save(new ClassificationInputDTO().convertDTOForClassification(vote));
		return new ClassificationOutputDTO().convertClassificationForDTO(saved);
	}
}
