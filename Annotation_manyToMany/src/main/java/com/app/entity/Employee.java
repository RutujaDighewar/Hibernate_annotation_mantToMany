package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name = "employee_certificate", joinColumns = {@JoinColumn(name="eid")}, inverseJoinColumns= {@JoinColumn(name="cid")})
	private List<Certifications> certicatesList;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", certicatesList=" + certicatesList + "]";
	}
	
	
	
	
}
