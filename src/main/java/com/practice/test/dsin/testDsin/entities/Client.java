package com.practice.test.dsin.testDsin.entities;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Transactional
@Entity
@Table(name="TB_CLIENT")
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long idClient;
	private String nameClient;
	private String cellNumber;
	
	public Client() {
		super();
	}

	public Client(String nameClient, String cellNumber) {
		super();
		this.nameClient = nameClient;
		this.cellNumber = cellNumber;
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

	@Override
	public int hashCode() {
		return Objects.hash(idClient);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(idClient, other.idClient);
	}

}
