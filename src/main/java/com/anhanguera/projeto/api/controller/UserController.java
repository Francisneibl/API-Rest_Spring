package com.anhanguera.projeto.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anhanguera.projeto.api.dto.input.UserInputDTO;
import com.anhanguera.projeto.api.dto.output.UserOutputDTO;
import com.anhanguera.projeto.domain.model.User;
import com.anhanguera.projeto.domain.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserOutputDTO>> list (){
		
		List<User> userList = userService.findAll();
		if(userList != null && userList.size() > 0) {
			List<UserOutputDTO> listDto = new UserOutputDTO().convertUserListForDTO(userList);
			return ResponseEntity.ok(listDto);
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserOutputDTO> findById(@PathVariable Long id){
		return userService.findById(id)
				.map(user -> ResponseEntity.ok(new UserOutputDTO().convetUserForDTO(user)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/adminPass/{id}")
	public ResponseEntity<Void> grandetAdmin(@PathVariable Long id){
		userService.grandAdminRole(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserOutputDTO add(@Valid @RequestBody UserInputDTO userInput) {
		User user = userService.save(new UserInputDTO().convertDtoForUser(userInput));
		return new UserOutputDTO().convetUserForDTO(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserOutputDTO> update (@PathVariable Long id,@Valid @RequestBody UserInputDTO userInput){

		User user = userService.update(id, new UserInputDTO().convertDtoForUser(userInput));
		return ResponseEntity.ok(new UserOutputDTO().convetUserForDTO(user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		userService.deleteLogicalById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
