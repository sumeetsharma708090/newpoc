package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repository;

	@PostMapping("/create")
	public ResponseEntity<?> name(@RequestBody User user) {
		repository.save(user);
		return new ResponseEntity<>("Inserted successfully!!!", HttpStatus.OK);
	}
	
	@GetMapping("/fetch")
	public Optional<User> name(@PathVariable("id") int id) {
		return repository.findById(id);
	}
}
