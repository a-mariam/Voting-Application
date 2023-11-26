package com.example.votingapplication.services;

import com.example.votingapplication.dtos.request.RegisterVoterRequest;
import com.example.votingapplication.dtos.request.VoteRequest;
import com.example.votingapplication.exceptions.UserAlreadyExist;
import com.example.votingapplication.exceptions.VoterAlreadyVote;
import com.example.votingapplication.models.Candidate;
import com.example.votingapplication.models.ElectionInfo;
import com.example.votingapplication.models.Vote;
import com.example.votingapplication.models.Voter;
import com.example.votingapplication.repositories.VoterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EVoteVoterService implements VoteService{


    private final EvoteAdminService adminService;
    private final VoterRepository voterRepository;

    public EVoteVoterService(EvoteAdminService adminService, VoterRepository voterRepository) {
        this.adminService = adminService;
        this.voterRepository = voterRepository;

    }

    @Override
    public Voter register(RegisterVoterRequest request) throws UserAlreadyExist, IllegalAccessException {
        return adminService.registerVoter(request);
    }

    @Override
    public List<Candidate> getListOfRegisteredCandidate() {
        List<Candidate> allCurrentCandidate = adminService.getListOfCandidates();
        return allCurrentCandidate;
    }

    @Override
    public Vote vote(VoteRequest request) throws VoterAlreadyVote, IllegalAccessException {
        return adminService.vote(request);
    }

    @Override
    public ElectionInfo getElectionInfo(String electionName) {
        return adminService.getElectionInfo(electionName);
    }


    public Voter findByPhoneNumber(String votingNumber) {
        return voterRepository.findByPhoneNumber(votingNumber);
    }
}


