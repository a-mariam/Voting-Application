package com.example.votingapplication.services;

import com.example.votingapplication.dtos.request.*;
import com.example.votingapplication.exceptions.CandidateAlreadyExist;
import com.example.votingapplication.exceptions.IllegalInput;
import com.example.votingapplication.exceptions.UserAlreadyExist;
import com.example.votingapplication.exceptions.VoterAlreadyVote;
import com.example.votingapplication.mapper.Mapper;
import com.example.votingapplication.models.*;
import com.example.votingapplication.repositories.CandidateRepository;
import com.example.votingapplication.repositories.ElectionRepository;
import com.example.votingapplication.repositories.VoterRepository;
import com.example.votingapplication.repositories.VotesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class EvoteAdminService implements AdminService{

    private  final VoterRepository voterRepository;
    private final Mapper mapper;
    private final CandidateRepository candidateRepository;
    private final ElectionRepository electionsRepository;
    private final VotesRepository votesRepository;
    private final ElectionRepository electionInfoRepository;

    @Override
    public Voter registerVoter(RegisterVoterRequest request) throws IllegalAccessException, UserAlreadyExist {
        Voter registeredVoter = mapper.mapper(request);
        voterRepository.save(registeredVoter);
        return registeredVoter;
    }

    @Override
    public Election registerElection(ElectionRequest request) {
        Election election = mapper.mapper(request);
        Election savedElection = electionsRepository.save(election);

        System.out.println("After election => " + savedElection);
        return savedElection;
    }



    @Override
    public List<Candidate> getListOfCandidates() {
        return candidateRepository.findAll();
    }
    public Long getCandidateCount(){
        return candidateRepository.count();
    }
    public Long getElectionCount(){
        return electionsRepository.count();
    }
    @Override
    public Admin validateLoginAsAdminRequest(LoginAsAdminRequest request) throws IllegalAccessException {
        Admin admin = new Admin();
        if (request.getName().equals(admin.getName()) || request.getPassword().equals(admin.getPassword()))return admin;
        throw new IllegalAccessException("Incorrect information") ;
    }

    @Override
    public Candidate registerCandidate(RegisterCandidateRequest register) throws CandidateAlreadyExist, IllegalInput {
        Candidate registeredCandidate = mapper.mapper(register);
        return candidateRepository.save(registeredCandidate);

    }

    @Override
    public long getNumberOfAllCandidate() {
        return candidateRepository.count();
    }

    @Override
    public ElectionInfo registerCandidateForElection(RegisterForElectionRequest registerForElection) throws  IllegalInput {
        ElectionInfo response = mapper.mapper(registerForElection);
        return response;
    }
    public Candidate getCandidateByName(String name){
        return candidateRepository.findCandidateByName(name);

    }

    @Override
    public Vote vote(VoteRequest request) throws VoterAlreadyVote, IllegalAccessException {
        Vote vote = mapper.mapper(request);
        Vote savedVote = votesRepository.save(vote);

        return savedVote;
    }

    @Override
    public Voter getVoterByVotingNumber(String votingNumber) {

        return voterRepository.findByVotingNumber(votingNumber);
    }

    @Override
    public ElectionInfo getElectionInfo(String electionName) {
        Election foundElection = electionsRepository.findByName(electionName);
        return foundElection.getElectionInfo();
    }

    public List<Election> getAllElection(){
        return electionsRepository.findAll();
    }


    public Long getUserCount() {
        return voterRepository.count();
    }
}
