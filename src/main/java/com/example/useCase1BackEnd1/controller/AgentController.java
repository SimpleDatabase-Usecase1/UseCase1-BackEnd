package com.example.useCase1BackEnd1.controller;


import com.example.useCase1BackEnd1.model.Agent;
import com.example.useCase1BackEnd1.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentController {

    @Autowired
    CrudService crudService;

    //get all agents
    @GetMapping("/getAllAgents")
    public List<Agent> getAllAgents() {
        List<Agent> allAgents = crudService.getAllAgents();
        return  allAgents;
    }

    //get agent by id
    @GetMapping("/getAgent/{id}")
    public Agent getAgentById(@PathVariable("id") String agentId) {
        return crudService.getAgentsById(agentId);
    }

    //add an agent
    @PostMapping("/addAgent")
    public Agent addAgent(@RequestBody Agent agent) {
        return crudService.addAgent(agent);
    }

    //delete agent by id
    @DeleteMapping("/deleteAgent/{id}")
    public void deleteAgentById(@PathVariable("id") String agentId) {
        crudService.deleteAgentById(agentId);
    }

    //update agent by id
    @PutMapping("/updateAgent/{id}")
    public Agent updateAgentById(@PathVariable("id") String agentId, @RequestBody Agent agent) {
        return crudService.updateAgent(agentId, agent);
    }
}
