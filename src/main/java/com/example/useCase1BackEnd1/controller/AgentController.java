package com.example.useCase1BackEnd1.controller;

import com.example.useCase1BackEnd1.model.Agent;
import com.example.useCase1BackEnd1.model.LoginDTO;
import com.example.useCase1BackEnd1.model.LoginResponse;
import com.example.useCase1BackEnd1.service.AgentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin
@Configuration
@ComponentScan("com.example.useCase1BackEnd1")
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

    //login post request
    @PostMapping("/login")
    public LoginResponse loginRequest(@Valid @RequestBody LoginDTO loginDTO) {
        List<Agent> allAgents = agentService.getAllAgents();
        for(Agent other: allAgents) {
            if(other.getPassword().equals(loginDTO.getPassword()) && other.getUsername().equals(loginDTO.getUsername())){
                return new LoginResponse(loginDTO.getUsername(), "Login Successful", other.getKeyword(), true);
            }
        }
        return new LoginResponse("404", "Login Unsuccessful", "Unauthorized", false);
    }
}
