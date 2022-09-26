package labProject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import labProject.dto.ReportDto;
import labProject.entitiy.Report;
import labProject.service.ReportService;

@Controller

public class ReportController {

	private ReportService reportService;

	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}
	
	@ModelAttribute("report")
	public ReportDto reportRegisterDto() {
		return new ReportDto();
	}
	
	@GetMapping("/registrationReport")
	public String showRegistrationForm() {
		return "reportRegister";
	}
	
	@PostMapping("/registrationReport")
	public String registerReport(@ModelAttribute("report") ReportDto dto,   @RequestParam("image") MultipartFile multipartFile) throws IOException {
		this.reportService.saveReport(dto, multipartFile);
		return "redirect:/registrationReport?success";
	}
	
	@GetMapping("/reports")
	public String getAllReport(Model model, @Param("Keyword") String keyword) {
		List<Report> listReport = this.reportService.findAll(keyword);
		model.addAttribute("listReport",listReport);
		return "reports";
	}
	
	@GetMapping("/registrationReport/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("report", this.reportService.getOneReportById(id));
		model.addAttribute("pageTitle","Edit Report (ID: " + id + ")");
		return "editReport";
	  }
	

	@GetMapping("/report/delete/{id}")
	public String deletePatient(@PathVariable("id") Long id,RedirectAttributes ra) {
		this.reportService.deleteReport(id);
		return "redirect:/reports";
	}
	
	

	@GetMapping("/detail/{id}")
	public String showIndex(@PathVariable("id") Long id, Model model) {
		Report report = this.reportService.getOneReportById(id);
		model.addAttribute("report", report);
		return "details";
	}

	
	
	
}
