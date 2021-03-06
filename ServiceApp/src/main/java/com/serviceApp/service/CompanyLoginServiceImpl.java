package com.serviceApp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.serviceApp.dto.LoginDTO;
import com.serviceApp.entity.ClientComplainEntity;
import com.serviceApp.entity.CompanyLoginEntity;
import com.serviceApp.repository.ComplainRepository;
import com.serviceApp.repository.LoginRepository;
import com.serviceApp.utility.response.Response;

@Service
@PropertySource(value = { "messages.properties" })
public class CompanyLoginServiceImpl implements CompanyLoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private ComplainRepository complainRepository;

	@Autowired
	private Environment environment;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public CompanyLoginServiceImpl() {
		logger.info("invoking " + this.getClass().getSimpleName());
	}

	@Override
	public Response login(LoginDTO loginDTO) {
		CompanyLoginEntity companyLoginEntity = loginRepository.findByEmailId(loginDTO.getEmailId());
		if (companyLoginEntity != null) {
			if (loginDTO.getPassword().equals(companyLoginEntity.getPassword())) {
				return new Response(environment.getProperty("LOGIN_SUCCESS"),
						environment.getProperty("SERVER_CODE_SUCCESS"), companyLoginEntity);
			}
			return new Response(environment.getProperty("INVALID_PASSWORD"),
					environment.getProperty("SERVER_CODE_ERROR"));
		} else {
			return new Response(environment.getProperty("INVALID_CREDENTIALS"),
					environment.getProperty("SERVER_CODE_ERROR"));
		}
	}

	@Override
	public List<ClientComplainEntity> veiwAllTicketas() {
		List<ClientComplainEntity> clientComplainEntity = complainRepository.findAll();
		return clientComplainEntity;
	}

	@Override
	public List<ClientComplainEntity> veiwTicketasByCompanyName() {
		List<ClientComplainEntity> clientComplainEntity = complainRepository.findAllByCompanyName();
		return clientComplainEntity;
	}
}
