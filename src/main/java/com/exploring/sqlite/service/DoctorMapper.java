package com.exploring.sqlite.service;

import com.exploring.sqlite.dto.DoctorDto;
import com.exploring.sqlite.models.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DoctorMapper {
    DoctorDto toDto(Doctor doctor);
}