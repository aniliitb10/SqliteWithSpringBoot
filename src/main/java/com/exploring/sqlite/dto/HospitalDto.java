package com.exploring.sqlite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class HospitalDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private String city;
    private List<DoctorDto> doctors;
}