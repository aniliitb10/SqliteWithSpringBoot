package com.exploring.sqlite.service;

import com.exploring.sqlite.dto.DoctorDto;
import com.exploring.sqlite.models.Doctor;
import com.exploring.sqlite.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.exploring.sqlite.service.DoctorSpecification.fromHospitalInCity;

@Service
public class DoctorServiceImpl {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public List<DoctorDto> findAll(List<String> hospitalsCities) {
        // Create a specification with a where condition, if the request specified cities
        Specification<Doctor> filters = Specification.where(CollectionUtils.isEmpty(hospitalsCities) ? null : fromHospitalInCity(hospitalsCities));
        return doctorRepository.findAll(filters).stream().map(doctorMapper::toDto).toList();
    }
}