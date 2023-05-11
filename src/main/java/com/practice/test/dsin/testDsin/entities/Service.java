package com.practice.test.dsin.testDsin.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.transaction.annotation.Transactional;

import com.practice.test.dsin.testDsin.enums.ServiceStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Transactional
@Entity
@Table(name = "TB_SERVICE")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idService;

	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client idClient;

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-br", timezone = "UTC")
	private LocalDateTime dateOfService;
	@Enumerated(EnumType.STRING)
	private ServiceStatus serviceStatus;

	public Service() {
		super();
	}

	public Service(Long idService, Client idClient, LocalDateTime dateOfService, ServiceStatus serviceStatus) {
		super();
		this.idService = idService;
		this.idClient = idClient;
		this.dateOfService = dateOfService;
		this.serviceStatus = serviceStatus;
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
}
