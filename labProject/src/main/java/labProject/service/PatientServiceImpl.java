package labProject.service;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import labProject.entitiy.Patient;
import labProject.repository.PatientRepository;


@Service
public class PatientServiceImpl implements PatientService {

	
	private PatientRepository patientRepository;
	
	
	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;

	}
	
	@Override
	public Patient patientSave(Patient patient) {
			return this.patientRepository.save(patient);
	}

	@Override
	public Patient getOnePatientById(Long patientId) {
		return this.patientRepository.findById(patientId).orElse(null);
	}

	@Override
	public List<Patient> findAll(String keyword) {
		if(keyword != null) {
			return this.patientRepository.findAll(keyword);
		}
		return this.patientRepository.findAll();
	}


	@Override
	public void deletePatient(Long id) {
		this.patientRepository.deleteById(id);
	}


	

	

}
