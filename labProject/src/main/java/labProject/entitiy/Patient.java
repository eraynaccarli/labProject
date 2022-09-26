package labProject.entitiy;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private Long patientId; 
	
	@Column(name = "patient_name")
	private String patientName;
	
	@Column(name = "patient_surname")
	private String patientSurname;
	
	@Column(name = "patient_tc", length = 7, unique = true)
	private String patientTc;
	
	@OneToMany(mappedBy = "patient")
	private List<Report> reports;

	
	
	

	
}
