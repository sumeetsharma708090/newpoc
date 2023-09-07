package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.DesigDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Designation;
import com.example.demo.repo.DesigRepository;

@Service
public class DesigService {

	@Autowired
	private DesigRepository desigRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	public Designation name1(Designation designation) {
		return desigRepository.save(designation);
	}

	public ResponseDto name(int id) {
		ResponseDto dto = new ResponseDto();
		Designation designation = desigRepository.findById(id).get();
		DesigDto desigDto = mapToUser(designation);

		ResponseEntity<UserDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/fetch/"+desigDto.getId(),
				UserDto.class);

		UserDto userDto = responseEntity.getBody();

		dto.setDesigDto(desigDto);
		dto.setUserDto(userDto);

		return dto;

	}

	private DesigDto mapToUser(Designation desig) {
		DesigDto dto = new DesigDto();
		dto.setId(desig.getId());
		dto.setDesig(desig.getDesig());
		return dto;
	}
}
