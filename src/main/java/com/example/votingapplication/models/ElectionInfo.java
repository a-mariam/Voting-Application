package com.example.votingapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;



@Entity
@Table(name = "electionInfo")
@Getter
@Setter
public class ElectionInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String type;
    @Column
    private String startingTime;
    @Column
    private String endingTime;
    @Column
    private String isElectionActive;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Candidate> candidates;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vote> votes;
    @OneToOne
    private Candidate winner;
}
