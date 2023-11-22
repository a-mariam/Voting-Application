package com.example.votingapplication.repositories;

import com.example.votingapplication.models.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionInfo extends JpaRepository<Election, Long> {
}
