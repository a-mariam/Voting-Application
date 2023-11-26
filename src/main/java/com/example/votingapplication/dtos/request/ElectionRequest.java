package com.example.votingapplication.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectionRequest {

    private String name;
    private String startDate;

    private String endDate;

    private boolean isActive;
}
