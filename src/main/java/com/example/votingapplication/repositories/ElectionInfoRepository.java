package com.example.votingapplication.repositories;

import com.example.votingapplication.models.Election;
import com.example.votingapplication.models.ElectionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionInfoRepository extends JpaRepository<ElectionInfo, Long> {


}
