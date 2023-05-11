package com.practice.test.dsin.testDsin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.test.dsin.testDsin.entities.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
