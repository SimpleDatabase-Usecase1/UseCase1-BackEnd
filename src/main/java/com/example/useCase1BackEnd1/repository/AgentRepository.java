package com.example.useCase1BackEnd1.repository;

import com.example.useCase1BackEnd1.model.Agent;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface AgentRepository extends CrudRepository<Agent, String> {
//    List<Agent> findByUser (String username);
    Optional<Agent> findById (String id);
}
