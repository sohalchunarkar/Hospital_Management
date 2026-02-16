package com.hostpitalmanagement.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostpitalmanagement.project.model.patient;
import com.hostpitalmanagement.project.repository.PatientRepository;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    //save patient info
    public String SavePatient(List<patient> li)
    {
        patientRepository.saveAll(li);
        return "The Patient Saved Successfully";
    }

    //find all patient

    public List<patient>  findAllPatient()
    {
        List<patient> li = patientRepository.findAll();
        return li;
    }

    //find patient by Id
    public patient findPatientById(int id)
    {
        Optional<patient> op = patientRepository.findById(id);
        if(op.isPresent())
        {
            return op.get();
        }
        else{
            return null;
        }
    }

    //delete patient By id
    public String DeletePatientById(int id)
    {   patientRepository.deleteById(id);
        return "The Patiente Data Deleted Successfully";
    }

    //count total patient

    public String CountTotalPatient()
    {
        return "The total Patient is "+patientRepository.count();
    }


    //put and patch operation

    public String UpdateUpt(int id , patient newPatient)
    {
        patient existing = findPatientById(id);
        if(existing != null)
        {
            existing.setAssigendDoctor(newPatient.getAssigendDoctor());
            existing.setDisease(newPatient.getDisease());
            existing.setId(newPatient.getId());
            existing.setMobileNo(newPatient.getMobileNo());
            existing.setName(newPatient.getName());
            existing.setRelativName(newPatient.getRelativName());
            patientRepository.save(existing);

            return "Patient Updated Sucessfully";
        }

        return "Patient with id not found";
    }


    public String UpdateUsingpatch(int id , String assdoc , String relativename , int mobile)
    {   
        patient existing = findPatientById(id);

        if(existing != null)
        {

            existing.setAssigendDoctor(assdoc);
            existing.setRelativName(relativename);
            existing.setMobileNo(mobile);
            patientRepository.save(existing);
            return "The patient update successfully";
        }

        return "The patient with id not found";
    }
} 
