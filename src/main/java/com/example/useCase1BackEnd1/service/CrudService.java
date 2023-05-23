package com.example.useCase1BackEnd1.service;


//service class for crud operations
//https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBMapper.Methods.html#DynamoDBMapper.Methods.save

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.example.useCase1BackEnd1.model.Agent;
import com.example.useCase1BackEnd1.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CrudService {

    @Autowired
    DynamoDBMapper dynamoDBMapper;

    @Autowired
    AgentRepository agentRepository;


    //add new agent
    public Agent addAgent(Agent agent) {
        dynamoDBMapper.save(agent);
        return agent;
    }

    //get agent by id
    public Agent getAgentsById(String agentId) {
        return dynamoDBMapper.load(Agent.class, agentId);
    }

    //get all agents
    public List<Agent> getAllAgents() {
        List<Agent> retrieveAgents = dynamoDBMapper.scan(Agent.class, new DynamoDBScanExpression());
        return retrieveAgents;
    }

    //Delete agent by id
    public void deleteAgentById(String agentId) {
        dynamoDBMapper.delete(dynamoDBMapper.load(Agent.class, agentId));
    }

    //update agent
    public Agent updateAgent(Agent agent, String agentId) {
        Optional<Agent> agentRepo = agentRepository.findById(agentId);

        agentRepo.get().setKeyword(agent.getKeyword());
        agentRepo.get().setPassword(agent.getPassword());
        agentRepo.get().setUsername(agent.getUsername());

        return agentRepository.save(agentRepo.get());
    }
}
