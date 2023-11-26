package com.example.votingapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "voter")
@Setter
@Getter
@ToString
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private int age;
    @Column
    private boolean hasVote;
    @Column
    private String Password;
    @Column
    private String phoneNumber;
    @Column
    private String votingNumber;
}
