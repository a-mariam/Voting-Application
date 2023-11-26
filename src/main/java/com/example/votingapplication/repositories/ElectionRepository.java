package com.example.votingapplication.repositories;

import com.example.votingapplication.models.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election, Long> {
    Election findByName(String electionName);

    Election findByType(String electionType);
}
