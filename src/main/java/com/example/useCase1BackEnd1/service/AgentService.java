package com.example.useCase1BackEnd1.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.example.useCase1BackEnd1.model.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    @Autowired
    DynamoDBMapper dbMapper;


    //add a new agent
    public Agent saveAgent(Agent agent){
        dbMapper.save(agent);
        return agent;
    }

    //get a specific agent
    public Agent getAgentById(String id){
        return dbMapper.load(Agent.class, id);
    }

    //delete an agent
    public String deleteAgentById(String id){
        dbMapper.delete(dbMapper.load(Agent.class, id));
        return "Agent " + id + " deleted";
    }

    //update a value of an agent
    public Agent updateAgentById(String id, Agent agent){
        Agent newAgent = new Agent();
        newAgent.setId(id);
        newAgent.setUsername(agent.getUsername());
        newAgent.setKeyword(agent.getKeyword());
        newAgent.setPassword(agent.getPassword());
        dbMapper.save(newAgent);
        return newAgent;
    }

    //get a list of all the agents
    public List<Agent> getAllAgents(){
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<Agent> loadAllAgents = dbMapper.scan(Agent.class, scanExpression);
        return loadAllAgents;
    }
}
