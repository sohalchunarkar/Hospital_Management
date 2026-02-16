package com.hostpitalmanagement.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hostpitalmanagement.project.model.patient;

@Repository
public interface PatientRepository extends JpaRepository<patient, Integer> {

}
