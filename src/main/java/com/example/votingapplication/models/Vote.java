package com.example.votingapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@Table(name = "vote")
@ToString
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
    private Voter voter;
    @Column
    private Long electionId;
    @Column
    private Long candidateId;
    @Column
    private String voterVotingNumber;
    @Column
    private String type;
}
