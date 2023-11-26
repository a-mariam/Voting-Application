package com.example.votingapplication.repositories;

import com.example.votingapplication.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotesRepository extends JpaRepository<Vote, Long> {

}
