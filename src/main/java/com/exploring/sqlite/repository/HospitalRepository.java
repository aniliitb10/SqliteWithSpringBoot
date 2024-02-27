package com.exploring.sqlite.repository;

import com.exploring.sqlite.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long>, JpaSpecificationExecutor<Hospital> {
}