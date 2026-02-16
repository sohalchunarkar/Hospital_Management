package com.hostpitalmanagement.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ward")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ward {
@Id
@Column(name = "Ward Num" , nullable = false)
private int wardNum;

@Column(name ="No of Beds" )
private int Nobed;


@Column(name ="Doctor Name" , nullable =  false)
private String Doc_Name;

@Column(name ="Doctor's id" , nullable = false)
private int Doctor_id;

}
