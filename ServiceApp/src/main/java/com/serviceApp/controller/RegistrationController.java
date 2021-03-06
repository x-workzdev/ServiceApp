package com.serviceApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceApp.dto.RegistrationDTO;
import com.serviceApp.entity.RegistrationEntity;
import com.serviceApp.service.RegistrationService;
import com.serviceApp.utility.response.Response;

@RestController
//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080" })
@RequestMapping("/api")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public RegistrationController() {
		logger.info("invoking ---------" + this.getClass().getSimpleName());
	}

	@PostMapping("/registration")
	public ResponseEntity<Response> clientRegistration(@Valid RegistrationDTO registrationDTO) {
		return new ResponseEntity<Response>(registrationService.clientRegistration(registrationDTO), HttpStatus.OK);
	}

	@GetMapping("/registeredClient")
	public List<RegistrationEntity> getAllRegisteredClient() {
		return registrationService.getAllClients();
	}
}
