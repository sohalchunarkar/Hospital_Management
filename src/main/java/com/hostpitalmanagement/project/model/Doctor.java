package com.hostpitalmanagement.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
import lombok.Data;
// import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctor")
@Data  // generate constructor using lombok.data
// @AllArgsConstructor  // generate parameterised constructor
// @NoArgsConstructor // generate non parameterised constructor
public class Doctor {

    @Id
    @Column(name = "Id" , nullable = false , unique = true)
    private int id;
    
    @Column(name = "Doctor_name" , nullable =false , unique = true)
    private String name;

    @Column(name = "Specilaziation" , nullable =  false)
    private String specilization;

   @Column(name = "mobile" , nullable =  false , unique =  true)
   private String mobileNo; 
   
   @Column(name = "email" , nullable =  false , unique =  true)
   private String email;


}
