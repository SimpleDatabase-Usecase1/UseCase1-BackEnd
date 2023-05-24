package com.example.useCase1BackEnd1.service;

import com.example.useCase1BackEnd1.model.Agent;

import java.util.List;

public interface AgentService {
    List<Agent> getAgentList();
    Agent addAgent(Agent agent);
    Agent getAgentById(String agentId);
    String updateAgentById(String agentId, Agent agent);
    void deleteAgentById(String agentId);
}
