package com.example.votingapplication.controller;

import com.example.votingapplication.dtos.request.RegisterCandidateRequest;
import com.example.votingapplication.dtos.request.RegisterForElectionRequest;
import com.example.votingapplication.dtos.response.RegisterCandidateResponse;
import com.example.votingapplication.exceptions.CandidateAlreadyExist;
import com.example.votingapplication.exceptions.EVoteException;
import com.example.votingapplication.exceptions.IllegalInput;
import com.example.votingapplication.models.Candidate;
import com.example.votingapplication.models.ElectionInfo;
import com.example.votingapplication.services.EVoteCandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class CandidateController {
    private final EVoteCandidateService candidateService;

    public CandidateController(EVoteCandidateService candidateService) {
        this.candidateService = candidateService;
    }
    @PostMapping("/registerCandidate")
    public ResponseEntity<?> registerCandidate(@RequestBody RegisterCandidateRequest request) {
        RegisterCandidateResponse response = null;
        try {
            response =   candidateService.register(request);
        } catch (EVoteException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
         return ResponseEntity.status(CREATED).body(response);
    }
    @PostMapping("/registerForElection")
    public ResponseEntity<?> registerForElection(@RequestBody RegisterForElectionRequest request)  {
        ElectionInfo response = null;
        try {
            response = candidateService.registerForElection(request);
        } catch (EVoteException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return ResponseEntity.status(CREATED).body(response);
    }
}
