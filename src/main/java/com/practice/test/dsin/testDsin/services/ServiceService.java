package com.practice.test.dsin.testDsin.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.test.dsin.testDsin.dto.ServiceDTO;
import com.practice.test.dsin.testDsin.exception.ResourceNotFoundException;
import com.practice.test.dsin.testDsin.repositories.ServiceRepository;

@Service
public class ServiceService {

	@Autowired
	private ServiceRepository repository;

	@Transactional
	public List<ServiceDTO> historyServices() {
		List<com.practice.test.dsin.testDsin.entities.Service> list = repository.findAll();

		return list.stream().map(x -> new ServiceDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public int deleteByClient(Long idClient) {
		return repository.deleteServiceByClient(idClient);
	}

	@Transactional
	public ServiceDTO createService(ServiceDTO dto) {
		com.practice.test.dsin.testDsin.entities.Service entity = new com.practice.test.dsin.testDsin.entities.Service();
		entity.setIdClient(dto.getIdClient());
		entity.setDateOfService(dto.getDateOfService());
		entity.setServiceStatus(dto.getServiceStatus());
		entity = repository.save(entity);
		return new ServiceDTO(entity);
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public ServiceDTO createService(Long idService, ServiceDTO dto) {

		com.practice.test.dsin.testDsin.entities.Service createSameDate = repository.getById(idService);
		com.practice.test.dsin.testDsin.entities.Service entity = new com.practice.test.dsin.testDsin.entities.Service();

		LocalDateTime todayPlusSeven = LocalDateTime.now().plusDays(7);

		if (todayPlusSeven.isAfter(createSameDate.getDateOfService()) && createSameDate.getDateOfService().isBefore(todayPlusSeven)) {
			entity.setDateOfService(createSameDate.getDateOfService());
		} else {
			entity.setDateOfService(dto.getDateOfService());
		}
		entity.setIdClient(dto.getIdClient());
		entity.setServiceStatus(dto.getServiceStatus());
		entity = repository.save(entity);
		return new ServiceDTO(entity);

	}

	@Transactional
	@SuppressWarnings("deprecation")
	public ServiceDTO changeService(Long idService, ServiceDTO dto) {
		try {
			com.practice.test.dsin.testDsin.entities.Service entity = repository.getOne(idService);

			LocalDateTime todayPlusTwo = LocalDateTime.now().plusDays(2);

			if (todayPlusTwo.isAfter(entity.getDateOfService())) {
				entity.setMessage("POR FAVOR LIGAR NO TELEFONE (61) 99212-4263");
				return new ServiceDTO(entity);
			}

			entity.setDateOfService(dto.getDateOfService());
			entity.setServiceStatus(dto.getServiceStatus());
			entity = repository.save(entity);
			return new ServiceDTO(entity);

		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("ID`s " + dto.getIdService() + " NOT FOUND!");
		}
	}

	@Transactional
	@SuppressWarnings("deprecation")
	public ServiceDTO changeServiceByLeila(Long idService, ServiceDTO dto) {
		try {
			com.practice.test.dsin.testDsin.entities.Service entity = repository.getOne(idService);

			entity.setDateOfService(dto.getDateOfService());
			entity.setServiceStatus(dto.getServiceStatus());
			entity = repository.save(entity);
			return new ServiceDTO(entity);

		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("ID`s " + dto.getIdService() + " NOT FOUND!");
		}
	}

	@Transactional
	public List<ServiceDTO> historyServicesBetween(String start, String finish) {

		LocalDateTime startDate = LocalDateTime.parse(start, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		LocalDateTime finishDate = LocalDateTime.parse(finish, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

		List<com.practice.test.dsin.testDsin.entities.Service> list = repository.findAllBetween(startDate, finishDate);

		return list.stream().map(x -> new ServiceDTO(x)).collect(Collectors.toList());
	}

}
