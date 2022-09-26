package labProject.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import labProject.entitiy.Laborant;
import labProject.service.LaborantService;

@Controller
public class LaborantController {
	
	
	private LaborantService laborantService;

	public LaborantController(LaborantService laborantService) {
		this.laborantService = laborantService;
	}
	
	@ModelAttribute("laborant")
	public Laborant laborantRegistration() {
		return new Laborant();
	}
	
	@GetMapping("/registrationLaborant")
	public String showRegistrationForm() {
		return "laborantRegister";
	}
	

	@PostMapping("/registrationLaborant")
	public String registerLaborant(@ModelAttribute("laborant") Laborant laborant) {
		this.laborantService.saveLaborant(laborant);
		return "redirect:/registrationLaborant?success";
	}
	

	@GetMapping("/laborants")
	public String getAllUser(Model model, @Param("Keyword") String keyword) {
		List<Laborant> listLaborants = this.laborantService.findAll(keyword);
		model.addAttribute("listLaborants",listLaborants);
		return "laborants";
	}
	
	
	@GetMapping("/registrationLaborant/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("patient", this.laborantService.getOneLaborantById(id));
		model.addAttribute("pageTitle","Edit Patient (ID: " + id + ")");
		return "editLaborant";
	  }

	@GetMapping("/laborant/delete/{id}")
	public String deletePatient(@PathVariable("id") Long id,RedirectAttributes ra) {
		this.laborantService.deleteLaborant(id);
		return "redirect:/laborants";
	}
	
	
}
