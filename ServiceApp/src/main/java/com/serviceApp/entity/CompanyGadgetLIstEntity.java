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
@Getter
@Setter
@ToString
@Table(name = "CompanyGadgetList")
public class CompanyGadgetListEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String emailId;
	private String model;
	private String serialNo;
	private String mcType;
	private String dateOfAssigne;
	private String status;

	public CompanyGadgetListEntity() {
		System.out.println();
	}
}
