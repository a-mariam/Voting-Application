package com.example.votingapplication.services;

import com.example.votingapplication.models.Candidate;
import com.example.votingapplication.models.Election;
import com.example.votingapplication.models.ElectionInfo;
import org.springframework.stereotype.Service;

@Service
public interface ElectionInfoService {
    Candidate getWinner(Election elections);
    ElectionInfo getElectionInfo();
}
