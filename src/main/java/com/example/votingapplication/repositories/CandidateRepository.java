package com.example.votingapplication.repositories;

import com.example.votingapplication.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate findCandidateByName(String name);

    Candidate findCandidateByPhoneNumber(String phoneNumber);

    Candidate findByRegistrationNumber(String candidateRegistrationNumber);
}
