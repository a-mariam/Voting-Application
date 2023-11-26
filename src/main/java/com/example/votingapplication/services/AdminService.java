package com.example.votingapplication.services;

import com.example.votingapplication.dtos.request.*;
import com.example.votingapplication.exceptions.CandidateAlreadyExist;
import com.example.votingapplication.exceptions.IllegalInput;
import com.example.votingapplication.exceptions.UserAlreadyExist;
import com.example.votingapplication.exceptions.VoterAlreadyVote;
import com.example.votingapplication.models.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    Voter registerVoter(RegisterVoterRequest request) throws IllegalAccessException, UserAlreadyExist;

    Election registerElection(ElectionRequest request);

    List<Candidate> getListOfCandidates();

    Admin validateLoginAsAdminRequest(LoginAsAdminRequest request) throws IllegalAccessException;

    Candidate registerCandidate(RegisterCandidateRequest register) throws CandidateAlreadyExist, IllegalAccessException, CandidateAlreadyExistsException, IllegalInput;

    long getNumberOfAllCandidate();

    ElectionInfo registerCandidateForElection(RegisterForElectionRequest registerForElection) throws IllegalAccessException, IllegalInput;

    Vote vote(VoteRequest request) throws VoterAlreadyVote, IllegalAccessException;

    Voter getVoterByVotingNumber(String votingNumber);
    ElectionInfo getElectionInfo(String electionName);


}
