package com.hostpitalmanagement.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hostpitalmanagement.project.model.Doctor;
import com.hostpitalmanagement.project.service.DoctorService;

@RestController
@RequestMapping("/DoctorApi/Operation")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/save")
    public String save(@RequestBody Doctor doctor)
    {
        String response = doctorService.saveDoctor(doctor);
        return response;
    }

    @GetMapping("/findall")
    public List<Doctor> getall()
    {
        List<Doctor> li = doctorService.findAllDoctor();
        return li;
    }

    @GetMapping("/findbyid/{id}")
    
    public Doctor getById(@PathVariable int id)
    {
        Doctor doc = doctorService.findDoctorById(id);
        return doc;
    }

    @GetMapping("/count")
    public String totalNum()
    {
        return doctorService.countDoc();
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deleteDocById(@PathVariable int id)
    {
        return doctorService.deleteDoctorById(id);
    }


    //update doctor using put 
    @PutMapping("/UpdateUsingPut/{id}")
    public String UpdatePut(@PathVariable int id , @RequestBody Doctor newDoc)
    {
        return doctorService.UpdateUsingPut(id, newDoc);
    }

    //update doctor using patch
    @PatchMapping("/UpdateUsingPatch/{id}")
    public String UpdatePatch(@PathVariable int id ,@RequestParam String email , @RequestParam String mobile    )
    {
        return doctorService.UpdateUsingPatch(id, mobile, email);
    }
}
