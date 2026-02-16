package com.hostpitalmanagement.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hostpitalmanagement.project.model.patient;
import com.hostpitalmanagement.project.service.PatientService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/patient/operation")
public class patientController {
    @Autowired
    PatientService patientService;

    //save patient info
    @PostMapping("/saveInfo")
    public String postMethodName(@RequestBody List<patient> li) {
        
        return patientService.SavePatient(li);
    }

    //findall patient
    @GetMapping("/getall")
    public List<patient> getall()
    {
        return patientService.findAllPatient();
    }

    @GetMapping("/findbyid/{id}")
    public patient Findbyid(@PathVariable int id)
    {
        return patientService.findPatientById(id);
    }
    
    @DeleteMapping("/DeleteById/{id}")
    public String deletbyid(@PathVariable int id)
    {
        return patientService.DeletePatientById(id);
    }

    @GetMapping("/counttotal")
    public String CountTotalPatient()
    {
        return patientService.CountTotalPatient();
    }


    @PutMapping("UpdatePut/{id}")
    public String putMethodName(@PathVariable int id, @RequestBody patient newPatient) {
    
        return patientService.UpdateUpt(id, newPatient);
    }
    

    @PatchMapping("UpdatePatch/{id}")
    public String updatePatch(@PathVariable int id , @RequestParam String relativename , @RequestParam int mobile , @RequestParam String assdoc)
    {
        return patientService.UpdateUsingpatch(id, assdoc, relativename, mobile);
    }
}
