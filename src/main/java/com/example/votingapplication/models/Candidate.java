package com.example.votingapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;



@Entity
@Table(name = "candidate")
@Component
@Getter
@Setter
@ToString
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vote> votes;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column

    private String partyName;
    @Column

    private Long electionId;
    @Column
    private String position;
    @Column
    private String email;
    @Column
    private String electionName;
    @Column
    private int age;
    @Column
    private String phoneNumber;
    @Column
    private String registrationNumber;

    public List<Vote> getVotes() {
        return votes;
    }
    public void setVotes(Vote votes){
        System.out.println("E enter herrr ----> " + votes);
        this.votes.add(votes);
        System.out.println("E don set oo " + votes);
    }
}
