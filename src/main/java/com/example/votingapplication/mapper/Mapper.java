package com.example.votingapplication.mapper;

import com.example.votingapplication.dtos.request.*;
import com.example.votingapplication.exceptions.CandidateAlreadyExist;
import com.example.votingapplication.exceptions.IllegalInput;
import com.example.votingapplication.exceptions.UserAlreadyExist;
import com.example.votingapplication.models.*;
import com.example.votingapplication.repositories.*;
import com.example.votingapplication.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;


@Component
public class Mapper {


    Validate validate = new Validate();
    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private ElectionRepository electionsRepository;
    @Autowired
    private VotesRepository votesRepository;
    @Autowired
    private ElectionInfoRepository electionInfoRepository;

    public Voter mapper(RegisterVoterRequest request) throws UserAlreadyExist, IllegalAccessException {
        Voter voter = new Voter();
        if (voterRepository.findByPhoneNumber(request.getPhoneNumber()) == null) {
            if (validate.canUserVote(request.getAge())) {
                voter.setFirstName(request.getFirstName());
                voter.setLastName(request.getLastName());
                voter.setPhoneNumber(request.getPhoneNumber());
                voter.setEmail(request.getEmail());
                voter.setAge(request.getAge());
                voter.setPassword(request.getPassword());
                voter.setVotingNumber(generateVotingNumber(request.getPhoneNumber()));
                return voter;
            }else throw new IllegalAccessException("User has to be 18 or above");
        }else throw new UserAlreadyExist("User already exist");

    }
    public  Candidate mapper(RegisterCandidateRequest request) throws CandidateAlreadyExist, IllegalInput {
        Candidate candidate = new Candidate();
        if (candidateRepository.findCandidateByPhoneNumber(request.getPhoneNumber()) == null) {
            if (request.getAge() >= 35) {
                candidate.setAge(request.getAge());
                candidate.setPartyName(request.getPartyName());
                candidate.setFirstName(request.getFirstName());
                candidate.setLastName(request.getLastName());
                candidate.setEmail(request.getEmail());
                candidate.setRegistrationNumber(generateRegistrationNumber(request.getPhoneNumber()));
                return candidate;
            }throw new IllegalInput("Candidate is not of age");
        }throw new CandidateAlreadyExist("Candidate already exist");
    }
    public  String generateRegistrationNumber(String phoneNumber){
        StringBuilder votingNumber = new StringBuilder();
        Random random = new Random();
        for (int count = 0; count < phoneNumber.length(); count++){
            votingNumber.append(phoneNumber.charAt(random.nextInt(phoneNumber.length())));
        }
        return votingNumber.toString();
    }
    public  String generateVotingNumber(String phoneNumber){
        StringBuilder votingNumber = new StringBuilder();
        Random random = new Random();
        for (int count = 0; count < phoneNumber.length(); count++){
            votingNumber.append(phoneNumber.charAt(random.nextInt(phoneNumber.length())));
        }
        return votingNumber.toString();
    }
    public  Election mapper(ElectionRequest request){
        Election elections = new Election();
        ElectionInfo electionInfo = new ElectionInfo();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd") ;
        LocalDate start = LocalDate.parse(request.getStartDate(), formatter);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd") ;
        LocalDate endDate = LocalDate.parse(request.getEndDate() , formatter2);

        elections.setActive(true);
        elections.setName(elections.getName());
        elections.setStartDate(start);
        elections.setEndDate(endDate) ;
        elections.setName(request.getName());
        elections.setType(request.getName());


        electionInfo.setType(elections.getType());
        electionInfo.setEndingTime(elections.getEndDate().toString());
        electionInfo.setStartingTime(elections.getStartDate().toString());
        electionInfo.setIsElectionActive(String.valueOf(elections.isActive()));
        electionInfo.setCandidates(elections.getCandidates());
        electionInfo.setVotes(elections.getVotes());
        ElectionInfo savedElectionInfo = electionInfoRepository.save(electionInfo);

        elections.setElectionInfo(savedElectionInfo);
        return elections;
    }

    public ElectionInfo mapper(RegisterForElectionRequest registerForElection) throws IllegalInput {
        Candidate foundCandidate = candidateRepository.findByRegistrationNumber(registerForElection.getCandidateRegistrationNumber()) ;
        Election foundElection = electionsRepository.findByName(registerForElection.getElectionType()) ;
        System.out.println(foundElection);
        List<Candidate> electionCandidates = foundElection.getCandidates();
        if (!electionCandidates.contains(foundCandidate)){
            List<Candidate> candidateList =  foundElection.getCandidates();
            foundCandidate .setPosition(registerForElection.getPosition());
            foundCandidate.setElectionName(registerForElection.getElectionType() ) ;
            System.out.println("Got it HERE==> "+ foundElection.getElectionInfo());
            electionCandidates.add(foundCandidate);
            return foundElection.getElectionInfo();
        }throw new IllegalInput("Invalid request");

    }

    public  Vote mapper(VoteRequest request) throws IllegalAccessException {
        Candidate candidate = candidateRepository.findCandidateByName(request.getCandidateName());
        Election elections = electionsRepository.findByName(request.getElectionName());
        Voter foundVoter = voterRepository.findByVotingNumber(request.getVotingNumber());
        Vote vote = new Vote();
        Vote savedVote = null;
        if (candidate != null && elections != null && foundVoter != null) {
            if (elections.isActive()) {
                vote.setVoter(foundVoter);
                vote.setCandidateId(candidate.getId());
                vote.setVoterVotingNumber(foundVoter.getVotingNumber());
                vote.setElectionId(elections.getId());
                foundVoter.setHasVote(true);
                vote.setType(elections.getType());
                savedVote = votesRepository.save(vote);
                voterRepository.save(foundVoter);
                candidate.setVotes(savedVote);
                Candidate savedCandidate = candidateRepository.save(candidate);
                return savedVote;
            }throw new IllegalAccessException("Election ended");
        }else {throw new IllegalAccessException("Invalid information");}
    }

}
