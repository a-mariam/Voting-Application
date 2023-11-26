package com.example.votingapplication.services;

import com.example.votingapplication.models.Candidate;
import com.example.votingapplication.models.Election;
import com.example.votingapplication.models.ElectionInfo;
import org.springframework.stereotype.Service;

@Service
public class EVoteElectionInfoService implements ElectionInfoService{


    @Override
    public Candidate getWinner(Election elections) {
        return null;
    }

    @Override
    public ElectionInfo getElectionInfo() {
        return null;
    }
}
