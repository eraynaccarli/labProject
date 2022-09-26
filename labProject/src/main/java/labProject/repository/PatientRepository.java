package labProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import labProject.entitiy.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	@Query("SELECT p FROM Patient p WHERE p.patientName LIKE %?1%"
			+ " OR p.patientSurname LIKE %?1%"
			+ " OR p.patientTc LIKE %?1%")
	List<Patient> findAll(String keyword);

	@Query("SELECT p FROM Patient p  Order By p.patientName")
	List<Patient> findAll();
	
	Patient findByPatientName(String username);
	
	Patient findByPatientTc(String username);

}
