package labProject.service;
import java.util.List;
import labProject.entitiy.Patient;



public interface PatientService {

	Patient patientSave(Patient patient);

	Patient getOnePatientById(Long patientId);
	
	List<Patient> findAll(String keyword);

	void deletePatient(Long id);

}
