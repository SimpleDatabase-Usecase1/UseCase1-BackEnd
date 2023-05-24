package com.example.useCase1BackEnd1.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.useCase1BackEnd1.model.Agent;
import com.example.useCase1BackEnd1.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

//    @Autowired
    DynamoDBMapper dbMapper;

    @Autowired
    AgentRepository agentRepository;

    @Override
    public List<Agent> getAgentList() {
        return (List<Agent>) agentRepository.findAll();
    }

    @Override
    public Agent addAgent(Agent agent) {
        dbMapper.save(agent);
        return agent;
    }

    @Override
    public Agent getAgentById(String agentId) {
        return dbMapper.load(Agent.class, agentId);
    }

    @Override
    public Agent updateAgentById(String agentId, Agent agent) {
        agentRepository.findById(agentId);
        agent.setPassword(agent.getPassword());
        agent.setKeyword(agent.getKeyword());
        agent.setUsername(agent.getUsername());
        return agent;
    }

    @Override
    public void deleteAgentById(String agentId) {
        dbMapper.delete(agentId);
    }
}
