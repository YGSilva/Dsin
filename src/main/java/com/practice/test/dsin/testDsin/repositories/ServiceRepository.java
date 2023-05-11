package com.practice.test.dsin.testDsin.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practice.test.dsin.testDsin.entities.Service;


@Repository
@Qualifier("jpaServiceRepository")
public interface ServiceRepository extends JpaRepository<Service, Long> {

	
	@Transactional 
	@Modifying
	@Query(value = "DELETE FROM TB_SERVICE WHERE ID_CLIENT = ?1", nativeQuery = true)
	int deleteServiceByClient(Long idClient);


	@Transactional 
	@Query(value = "SELECT * FROM TB_SERVICE  WHERE DATE_OF_SERVICE BETWEEN :start AND :finish", nativeQuery = true)
	List<Service> findAllBetween(LocalDateTime start, LocalDateTime finish);

	
	
	
}