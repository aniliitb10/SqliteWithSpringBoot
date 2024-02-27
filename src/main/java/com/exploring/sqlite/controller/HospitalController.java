package com.exploring.sqlite.controller;

import com.exploring.sqlite.dto.HospitalDto;
import com.exploring.sqlite.service.HospitalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalServiceImpl hospitalService;

    @Autowired
    public HospitalController(HospitalServiceImpl hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping
    public List<HospitalDto> findAll(@RequestParam(required = false) String nameLike,
                                     @RequestParam(required = false) String doctorSpeciality,
                                     @RequestParam(required = false) List<String> cities) {
        return hospitalService.findAll(nameLike, doctorSpeciality, cities);
    }
}