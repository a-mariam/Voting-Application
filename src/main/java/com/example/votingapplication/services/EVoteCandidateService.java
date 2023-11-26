package com.example.votingapplication.services;

import com.example.votingapplication.dtos.request.RegisterCandidateRequest;
import com.example.votingapplication.dtos.request.RegisterForElectionRequest;
import com.example.votingapplication.dtos.response.RegisterCandidateResponse;
import com.example.votingapplication.exceptions.CandidateAlreadyExist;
import com.example.votingapplication.exceptions.IllegalInput;
import com.example.votingapplication.mapper.ResponseMapper;
import com.example.votingapplication.models.Candidate;
import com.example.votingapplication.models.ElectionInfo;
import org.springframework.stereotype.Service;

@Service
public class EVoteCandidateService implements CandidateService {


    private final EvoteAdminService adminService;

    public EVoteCandidateService(EvoteAdminService appAdminService) {
        this.adminService = appAdminService;
    }

    @Override
    public RegisterCandidateResponse register(RegisterCandidateRequest register) throws CandidateAlreadyExist, IllegalInput {
        Candidate candidate =  adminService.registerCandidate(register);
        return ResponseMapper.mapp(candidate);
    }

    @Override
    public ElectionInfo registerForElection(RegisterForElectionRequest registerForElection) throws  IllegalInput {
        ElectionInfo response = adminService.registerCandidateForElection(registerForElection);
        return response;
    }
    public Candidate getCandidate(String name) {
        return adminService.getCandidateByName(name);
    }
}
