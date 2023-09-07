package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.repo.AddressRepository;

@RestController
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	
	@PostMapping("create")
	public ResponseEntity<?> name(@RequestBody Address address) {
		addressRepository.save(address);
		return new ResponseEntity<>("Inserted Successfully!!!", HttpStatus.OK);
	}
	
	@GetMapping("/fetch")
	public List<Address> name() {
		return addressRepository.findAll();
	}
}
