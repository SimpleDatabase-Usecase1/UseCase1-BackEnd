package com.example.useCase1BackEnd1.repository;

import com.example.useCase1BackEnd1.model.Agent;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableScan
@Repository
public interface AgentRepository extends CrudRepository<Agent, String> {
    Optional<Agent> findById (String id);
}
