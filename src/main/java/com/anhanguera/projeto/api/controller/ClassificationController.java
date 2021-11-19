package com.anhanguera.projeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anhanguera.projeto.domain.model.Classification;
import com.anhanguera.projeto.domain.service.ClassificationService;

@RestController
@RequestMapping("/classification")
public class ClassificationController {
	
	@Autowired
	private ClassificationService classificationService;

	@GetMapping
	public Object list() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(principal.toString());
		return classificationService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Classification toRank(@RequestBody Classification vote) {
	
		return classificationService.save(vote);
	}
}
