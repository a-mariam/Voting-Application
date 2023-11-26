package com.example.votingapplication.services;


import com.example.votingapplication.dtos.request.RegisterVoterRequest;
import com.example.votingapplication.dtos.request.VoteRequest;
import com.example.votingapplication.exceptions.UserAlreadyExist;
import com.example.votingapplication.exceptions.VoterAlreadyVote;
import com.example.votingapplication.models.Candidate;
import com.example.votingapplication.models.ElectionInfo;
import com.example.votingapplication.models.Vote;
import com.example.votingapplication.models.Voter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoteService {

    Voter register(RegisterVoterRequest request) throws UserAlreadyExist, IllegalAccessException;

    List<Candidate> getListOfRegisteredCandidate();

    Vote vote(VoteRequest request) throws VoterAlreadyVote, IllegalAccessException;
    ElectionInfo getElectionInfo(String electionName);
}
