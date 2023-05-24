package com.example.useCase1BackEnd1.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.useCase1BackEnd1.model.Agent;
import com.example.useCase1BackEnd1.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    DynamoDBMapper dbMapper;

    @Autowired
    AgentRepository agentRepository;

//    @Override
//    public List<Agent> getAgentList() {
//        return (List<Agent>) dbMapper.load(Agent);
//    }

    @Override
    public List<Agent> getAgentList() {
        return null;
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
    public String updateAgentById(String agentId, Agent agent) {
        dbMapper.save(agent,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("customerId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(agentId)
                                )));
        return agentId;
    }

    @Override
    public void deleteAgentById(String agentId) {
        dbMapper.delete(agentId);
    }
}
