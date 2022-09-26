package labProject.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import labProject.entitiy.Patient;
import labProject.service.PatientService;


public class PatientController {

	private PatientService patientService;
	
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	

	@ModelAttribute("patient")
	public Patient patientRegister() {
		return new Patient();
	}
	
	@GetMapping("/registrationPatient")
	public String showRegistrationForm() {
		return "patientRegister";
	}
	

	@PostMapping("/registrationPatient")
	public String registerPatientAccount(@ModelAttribute("patient") Patient patient) {
		this.patientService.patientSave(patient);
		return "redirect:/registrationPatient?success";
	}
	

	@GetMapping("/patients")
	public String getAllUser(Model model, @Param("Keyword") String keyword) {
		List<Patient> listPatients = this.patientService.findAll(keyword);
		model.addAttribute("listPatients",listPatients);
		return "patients";
	}
	
	
	@GetMapping("/registrationPatient/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("patient", this.patientService.getOnePatientById(id));
		model.addAttribute("pageTitle","Edit Patient (ID: " + id + ")");
		return "editPatient";
	  }

	@GetMapping("/laborant/delete/{id}")
	public String deletePatient(@PathVariable("id") Long id,RedirectAttributes ra) {
		this.patientService.deletePatient(id);
		return "redirect:/laborants";
	}
	
	
}
