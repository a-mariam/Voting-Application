package com.example.votingapplication.validator;

import com.example.votingapplication.dtos.request.RegisterForElectionRequest;
import com.example.votingapplication.models.Candidate;
import com.example.votingapplication.models.Election;
import com.example.votingapplication.repositories.CandidateRepository;
import com.example.votingapplication.repositories.ElectionRepository;
import com.example.votingapplication.repositories.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Validate {

    public Validate() {
    }

    private VoterRepository voterRepository ;
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ElectionRepository electionsRepository;

    public boolean canUserVote(int age) {
        if (age >= 18){
            return true;
        }else{return false;}
    }

    public boolean isRequestValid(RegisterForElectionRequest registerForElection) {
        Candidate foundCandidate = candidateRepository.findByRegistrationNumber(registerForElection.getCandidateRegistrationNumber()) ;
        Election foundElection = electionsRepository.findByType(registerForElection.getElectionType()) ;
        List<Candidate> electionCandidates = foundElection.getCandidates();
        if (!electionCandidates.contains(foundCandidate)){
            return true;
        }return false;
    }
}
