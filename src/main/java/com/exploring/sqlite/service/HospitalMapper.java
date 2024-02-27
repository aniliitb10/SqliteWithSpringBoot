package com.exploring.sqlite.service;

import com.exploring.sqlite.dto.HospitalDto;
import com.exploring.sqlite.models.Hospital;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface HospitalMapper {
    HospitalDto toDto(Hospital hospital);
}