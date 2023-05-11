package com.practice.test.dsin.testDsin.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.practice.test.dsin.testDsin.entities.Client;
import com.practice.test.dsin.testDsin.entities.Service;
import com.practice.test.dsin.testDsin.enums.ServiceStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class ServiceDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idService;

	private Client idClient;

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-br", timezone = "UTC")
	private LocalDateTime dateOfService;
	@Enumerated(EnumType.STRING)
	private ServiceStatus serviceStatus;
	private String message;

	public ServiceDTO() {
		super();
	}

	public ServiceDTO(Long idService, Client idClient, LocalDateTime dateOfService, ServiceStatus serviceStatus,
			String message) {
		super();
		this.idService = idService;
		this.idClient = idClient;
		this.dateOfService = dateOfService;
		this.serviceStatus = serviceStatus;
		this.message = message;
	}
	
	public ServiceDTO(Service entity) {
		super();
		this.idService = entity.getIdService();
		this.idClient = entity.getIdClient();
		this.dateOfService = entity.getDateOfService();
		this.serviceStatus = entity.getServiceStatus();
		this.message = entity.getMessage();
	}

	public Long getIdService() {
		return idService;
	}

	public void setIdService(Long idService) {
		this.idService = idService;
	}

	public Client getIdClient() {
		return idClient;
	}

	public void setIdClient(Client idClient) {
		this.idClient = idClient;
	}

	public LocalDateTime getDateOfService() {
		return dateOfService;
	}

	public void setDateOfService(LocalDateTime dateOfService) {
		this.dateOfService = dateOfService;
	}

	public ServiceStatus getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(ServiceStatus serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
