package com.hostpitalmanagement.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostpitalmanagement.project.model.Doctor;
import com.hostpitalmanagement.project.repository.DoctorRepository;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    //saving all the data of the docotrs
   public String saveDoctor(Doctor doc)
   {
    doctorRepository.save(doc);
    return "Doctor Info Saved Successfully";
   }
    
   public List<Doctor> findAllDoctor()
   {
    List<Doctor> list = doctorRepository.findAll();
    return list;
   }

   //finding doctor by id
   public Doctor findDoctorById(int id)
   {
     
    Optional<Doctor> op = doctorRepository.findById(id);
    if(op.isPresent())
    {
        return op.get();
    }
    else{
        return null;
    }

   }
   
   //delete doctor by id
   public String deleteDoctorById(int id)
   {
    doctorRepository.deleteById(id);
    return "Doctor with Id "+id+" Deleted Successfully";
   }
    

   //count total doctors
   public String countDoc()
   {
     long count = doctorRepository.count();
     return "The total docotr present are" + count;
   }


   //Update Using put and patch

   //Update using put :- Update the whole object

   public String UpdateUsingPut(int id , Doctor NewDoc)
   {
      Doctor existingDoctor = findDoctorById(id);
      if(existingDoctor != null)
      {

        doctorRepository.save(NewDoc);
        return "The Doctor Updated Sucessfully";

      }
      
      return "The Doctor with id "+id+" not found";
   }

   //Update using patch :- Update only few fields of The Doctor
   public String UpdateUsingPatch(int id , String mobile , String email)
   {
      Doctor existinDoc = findDoctorById(id);
      if(existinDoc != null)
      {
        existinDoc.setEmail(email);
        existinDoc.setMobileNo(mobile);
        doctorRepository.save(existinDoc);
        return "The Doctor Updated Successfully";
      }
      return "The Doctor with id "+id+" not found";
   }
}
