package com.practice.test.dsin.testDsin.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.test.dsin.testDsin.dto.ClientDTO;
import com.practice.test.dsin.testDsin.entities.Client;
import com.practice.test.dsin.testDsin.exception.DatabaseException;
import com.practice.test.dsin.testDsin.exception.ResourceNotFoundException;
import com.practice.test.dsin.testDsin.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private ServiceService service;
	
	@Transactional(readOnly=true)
	public List<ClientDTO> listClients() {
		List<Client> list = repository.findAll();
		
		return list.stream()
				.map(x -> new ClientDTO(x))
				.collect(Collectors.toList());
	}
	
	@Transactional 
	public ClientDTO insertClient(ClientDTO dto) {
		Client entity = new Client();
		entity.setCellNumber(dto.getCellNumber());
		entity.setNameClient(dto.getNameClient());
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
	
	@Transactional 
	public void delete(Long idClient) {
		try {
			service.deleteByClient(idClient);
			repository.deleteById(idClient);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("ID (" + idClient + " NOT FOUND!");
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation, please ensure to delete a valid item!");
		}
	}

	@SuppressWarnings("deprecation")
	@Transactional 
	public ClientDTO alterClient(Long idClient, ClientDTO dto) {
		try {
			Client entity = repository.getOne(idClient);
			entity.setCellNumber(dto.getCellNumber());
			entity.setNameClient(dto.getNameClient());
			entity = repository.save(entity);
			return new ClientDTO(entity);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("ID : " + idClient + "NOT FOUND!");
		}
	}

}
