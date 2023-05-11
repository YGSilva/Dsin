package com.practice.test.dsin.testDsin.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practice.test.dsin.testDsin.dto.ClientDTO;
import com.practice.test.dsin.testDsin.services.ClientService;

@RestController
@RequestMapping(value="/client")
public class ClientResource {

	@Autowired
	private ClientService service;
	
	@GetMapping(value="/listClients")
	private ResponseEntity<List<ClientDTO>> ListClients() {
		List<ClientDTO> list = service.listClients();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value="insertClient")
	private ResponseEntity<ClientDTO> insertClient(@RequestBody ClientDTO dto) {
		dto = service.insertClient(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idClient}")
				.buildAndExpand(dto.getIdClient()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value="/alterClient/{idClient}")
	private ResponseEntity<ClientDTO> alterClient(@PathVariable Long idClient, @RequestBody ClientDTO dto) {
		dto = service.alterClient(idClient, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value="/deleteClient/{idClient}")
	private ResponseEntity<Void> deleteClient(@PathVariable Long idClient){
		service.delete(idClient);
		return ResponseEntity.noContent().build();
	}
}