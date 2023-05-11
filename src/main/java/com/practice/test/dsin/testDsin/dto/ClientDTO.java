package com.practice.test.dsin.testDsin.dto;

import java.io.Serializable;

import com.practice.test.dsin.testDsin.entities.Client;

public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long idClient;
	private String nameClient;
	private String cellNumber;
	
	public ClientDTO() {
		super();
	}

	public ClientDTO(String nameClient, String cellNumber) {
		super();
		this.nameClient = nameClient;
		this.cellNumber = cellNumber;
	}
	
	public ClientDTO(Client entity) {
		this.idClient = entity.getIdClient();
		this.nameClient = entity.getNameClient();
		this.cellNumber = entity.getCellNumber();
	}

	public Long getIdClient() {
		return idClient;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}
}