package com.hostpitalmanagement.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="Patient")
@Data
public class patient {
    @Id
    @Column(name = "id" , nullable =  false)
    private int id;

    @Column(name="name" )
    private String name;

    @Column(name = "Disease")
    private String Disease;

    @Column(name = "MobileNO" )
    private int mobileNo;

    @Column(name="AssignedDoctorName")
    private String AssigendDoctor;
    
    @Column(name="RelativeName")
    private String relativName;

}
