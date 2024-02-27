package com.exploring.sqlite.service;

import com.exploring.sqlite.models.Doctor;
import jakarta.persistence.criteria.Path;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class DoctorSpecification {

    private DoctorSpecification() {
    }

    /*
        Get doctors that belong to hospitals in specific cities
        This will require us to first join the doctor and hospital tables (ManyToOne), and then applying the filter.
        To do this Many To One join (each doctor has one hospital, but one hospital has many doctors), we need to use the Path criteria to accomplish it
        This would be the same in a OneToOne relationship
     */
    public static Specification<Doctor> fromHospitalInCity(List<String> cities) {
        return (root, query, builder) -> {
            Path<Doctor> hospital = root.get("hospital");
            return hospital.get("city").in(cities);
        };
    }
}