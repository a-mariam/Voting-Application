package com.example.votingapplication.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "elections")
@ToString
@Getter
@Setter
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate startDate;
    @Column
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate endDate;
    @Column
    @Enumerated(value = EnumType.STRING)
    private ElectionType type;
    @Column
    private boolean isActive;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private ElectionInfo electionInfo;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vote> votes;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Candidate> candidates;
}
