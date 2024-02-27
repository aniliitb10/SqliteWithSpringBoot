package com.exploring.sqlite.service;

import java.util.List;

import com.exploring.sqlite.models.Doctor;
import com.exploring.sqlite.models.Hospital;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class HospitalSpecification {

    private HospitalSpecification() {}

    // First request parameter filter: Get hospitals with name like a specific string
    public static Specification<Hospital> nameLike(String nameLike) {
        return (root, query, builder) -> builder.like(root.get("name"), "%" + nameLike + "%");
    }

    /*
        Second request parameter filter: Get hospitals that have doctors with a specific speciality.
        This will require us to first join the hospital and doctor tables (OneToMany), and then applying the filter.
        To do this One to Many join (one hospital has many doctors), we need to use the Join criteria to accomplish it
     */
    public static Specification<Hospital> hasDoctorInSpeciality(String speciality) {
        return (root, query, builder) -> {
            Join<Doctor,Hospital> hospitalDoctors = root.join("doctors");
            return builder.equal(hospitalDoctors.get("speciality"), speciality);
        };
    }

    // Third request parameter filter: Get hospitals in one of the specified cities
    public static Specification<Hospital> inCity(List<String> cities) {
        return (root, query, builder) -> root.get("city")
                .in(cities);
    }
}