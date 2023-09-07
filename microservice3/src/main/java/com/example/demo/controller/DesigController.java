package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Designation;
import com.example.demo.service.DesigService;

@RestController
public class DesigController {

	@Autowired
	private DesigService desigService;
	
	@PostMapping("/create")
	public ResponseEntity<?> poub(@RequestBody Designation designation) {
		desigService.name1(designation);
		return new ResponseEntity<>("inserted successfully!!!", HttpStatus.OK);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<ResponseDto> getDesig(@PathVariable("id") int id) {
		ResponseDto dto = desigService.name(id);
		return ResponseEntity.ok(dto);
	}
}
