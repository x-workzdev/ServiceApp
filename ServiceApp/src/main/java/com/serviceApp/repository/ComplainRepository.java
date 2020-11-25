package com.serviceApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.serviceApp.entity.ClientComplainEntity;

public interface ComplainRepository extends JpaRepository<ClientComplainEntity, String> {
	// change this to sql query

	@Query(value = "select company from CLIENT_COMPLAIN  as company inner join REGISTRATION as reg where reg.companyName= :companyName", nativeQuery = true)
	List<ClientComplainEntity> findAllByCompanyName(String companyName);

}
