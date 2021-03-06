package com.serviceApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "companylogin")
@Getter
@Setter
@ToString
public class CompanyLoginEntity {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	private String emailId;
	private String password;
	private String FullName;
	private String role;	
	
	public CompanyLoginEntity() {
		System.out.println("invoking "+this.getClass().getSimpleName());
	}
}
