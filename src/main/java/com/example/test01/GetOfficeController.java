package com.example.test01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test01.ExceptionResponse;
import com.example.test01.GetOfficeFacade;

@RestController
@RequestMapping("/v1")
public class GetOfficeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GetOfficeController.class);

	@Autowired
	private GetOfficeFacade getOfficeFacade;

	@PostMapping("/get/officeId/{producerId}")
	public ResponseEntity<Object> getOfficeId(@PathVariable String producerId) {

		try {

			String response = getOfficeFacade.getOffice(producerId);

			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (ExceptionResponse e) {

			LOGGER.error("Error retrieving office id for producerId {}. Cause: {}", producerId, e.getMessage());

			return new ResponseEntity<>(e.getBody(), e.getStatus());

		}

	}

}
