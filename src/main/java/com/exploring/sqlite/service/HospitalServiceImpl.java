package com.exploring.sqlite.service;


import com.exploring.sqlite.dto.HospitalDto;
import com.exploring.sqlite.models.Hospital;
import com.exploring.sqlite.repository.HospitalRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.exploring.sqlite.service.HospitalSpecification.*;

@Service
public class HospitalServiceImpl {

    private final HospitalRepository hospitalRepository;
    private final HospitalMapper hospitalMapper;

    @Autowired
    public HospitalServiceImpl(HospitalRepository hospitalRepository, HospitalMapper hospitalMapper) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalMapper = hospitalMapper;
    }

    public List<HospitalDto> findAll(String nameLikeFilter, String doctorSpeciality, List<String> cities) {
        // Only create specifications for fields with values:
        Specification<Hospital> filters = Specification.where(StringUtils.isBlank(nameLikeFilter) ? null : nameLike(nameLikeFilter))
                .and(StringUtils.isBlank(doctorSpeciality) ? null : hasDoctorInSpeciality(doctorSpeciality))
                .and(CollectionUtils.isEmpty(cities) ? null : inCity(cities));

        // User our created Specification to query our repository
        return hospitalRepository.findAll(filters)
                .stream()
                .map(hospitalMapper::toDto)
                .toList();
    }
}