package com.serviceApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceApp.dto.LoginDTO;
import com.serviceApp.entity.ClientComplainEntity;
import com.serviceApp.entity.CompanyGadgetListEntity;
import com.serviceApp.entity.CompanyLoginEntity;
import com.serviceApp.service.CompanyLoginService;
import com.serviceApp.utility.response.Response;

@RestController
//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080" })
@RequestMapping("/api")
public class CompanyLoginController {

	@Autowired
	private CompanyLoginService companyLoginService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public CompanyLoginController() {
		logger.info("invoking ---------" + this.getClass().getSimpleName());
	}

	@GetMapping("/viewAllEngineer")
	public List<CompanyLoginEntity> viewAllEngineer(){
		logger.info("invoking viewAllEngineer()");
		List<CompanyLoginEntity> response = companyLoginService.viewAllEngineer();
		logger.info("returning response "+ response);
		return response;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Response> companyLogin(@Valid /* @RequestBody */ LoginDTO logindto) {
		logger.info("invoking companyLogin()");
		Response response = null;
		if (logindto != null) {
			logger.info("");
			response = companyLoginService.login(logindto);
			logger.info("");
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/viewAllGadgets")
	public List<CompanyGadgetListEntity> viewAllGadgets() {
		logger.info("invoking viewAllGadgets()");
		List<CompanyGadgetListEntity> response = companyLoginService.veiwAllGadgets();
		logger.info("Returning response");
		return response;
	}
	
	@GetMapping("/viewAllTickets")
	public List<ClientComplainEntity> viewAllTickets() {
		logger.info("invoking viewAllTickets()");
		List<ClientComplainEntity> response = companyLoginService.veiwAllTicketas();
		logger.info("Returning response");
		return response;
	}
	
}