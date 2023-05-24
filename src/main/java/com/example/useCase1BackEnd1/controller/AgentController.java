package com.example.useCase1BackEnd1.controller;

import com.example.useCase1BackEnd1.model.Agent;
import com.example.useCase1BackEnd1.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class AgentController {

    @Autowired
    AgentService agentService;

    //get all agents
    @GetMapping("/getAllAgents")
    public ResponseEntity<List<Agent>> getAllAgents() {
        try {
            List<Agent> allAgents = agentService.getAllAgents();
            return  ResponseEntity.ok(allAgents);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //get agent by id
    @GetMapping("/getAgent/{id}")
    public ResponseEntity<Agent> getAgentById(@PathVariable("id") String agentId) {
        try {
            return ResponseEntity.ok(agentService.getAgentById(agentId));
        }catch (HttpClientErrorException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //add an agent
    @PostMapping("/addAgent")
    public ResponseEntity<Agent> addAgent(@RequestBody Agent agent) {
        try{
            return ResponseEntity.ok(agentService.saveAgent(agent));
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //delete agent by id
    @DeleteMapping("/deleteAgent/{id}")
    public void deleteAgentById(@PathVariable("id") String agentId) {
        agentService.deleteAgentById(agentId);
    }

    //update agent by id
    @PutMapping("/updateAgent/{id}")
    public ResponseEntity<Agent> updateAgentById(@PathVariable("id") String agentId, @RequestBody Agent agent) {
        try {
            return ResponseEntity.ok(agentService.updateAgentById(agentId, agent));
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
