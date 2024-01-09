package com.example.test01;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GetOfficeFacade {

	public String getOffice(String producerId) {
		try{
			return producerId;

		} catch (Exception e) {

			throw new ExceptionResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
