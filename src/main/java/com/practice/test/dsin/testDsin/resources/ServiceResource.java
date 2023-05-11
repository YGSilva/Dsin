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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practice.test.dsin.testDsin.dto.ServiceDTO;
import com.practice.test.dsin.testDsin.services.ServiceService;

@RestController
@RequestMapping(value = "/service")
public class ServiceResource {

	@Autowired
	private ServiceService service;

	@GetMapping(value = "/historyServices")
	private ResponseEntity<List<ServiceDTO>> HistoryServices() {
		List<ServiceDTO> list = service.historyServices();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping(value = "/createService/{idService}")
	private ResponseEntity<ServiceDTO> createService(@PathVariable Long idService, @RequestBody ServiceDTO dto) {
		dto = service.createService(idService, dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idService}")
				.buildAndExpand(dto.getIdService()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}
	
	@PostMapping(value = "/createService")
	private ResponseEntity<ServiceDTO> createService(@RequestBody ServiceDTO dto) {
		dto = service.createService(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idService}")
				.buildAndExpand(dto.getIdService()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/changeStatusService/{idService}")
	public ServiceDTO changeStatusService(@PathVariable Long idService, @RequestBody ServiceDTO dto) {
		return service.changeService(idService, dto);
	}

	//METEDO COM ERRO
//	@GetMapping(value = "/historyServicesBetween")
//	private ResponseEntity<List<ServiceDTO>> HistoryServicesBetween(
//			@RequestParam("startDate") String start,
//			@RequestParam("finishDate") String finish) {
//		List<ServiceDTO> list = service.historyServicesBetween(start, finish);
//		return ResponseEntity.ok().body(list);
//	}

	@DeleteMapping(value = "/deleteServiceByIdClient/{idClient}")
	private ResponseEntity<Void> deleteServiceByClient(@PathVariable Long idClient) {
		service.deleteByClient(idClient);
		return ResponseEntity.noContent().build();
	}
}
