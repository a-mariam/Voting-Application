package com.example.votingapplication.repositories;

import com.example.votingapplication.models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter, Long> {

    Voter findByPhoneNumber(String phoneNumber);
    Voter findByVotingNumber(String votingNumber);
}
