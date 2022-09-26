package labProject.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import labProject.dto.ReportDto;
import labProject.entitiy.Laborant;
import labProject.entitiy.Patient;
import labProject.entitiy.Report;
import labProject.repository.ReportRepository;

@Service
public class ReportServiceImpl  implements ReportService{

	
	private ReportRepository reportRepository;
	private LaborantService laborantService;
	private PatientService patientService;
	
	public ReportServiceImpl(ReportRepository reportRepository,LaborantService laborantService , PatientService patientService){
		this.reportRepository = reportRepository;
		this.laborantService = laborantService;
		this.patientService = patientService;
	}



	@Override
	public List<Report> findAll(String keyword) {
		if(keyword != null) {
			return this.reportRepository.findAll(keyword);
		}
		return this.reportRepository.findAll();
	}

	@Override
	public void deleteReport(Long id) {
	    this.reportRepository.deleteById(id);
	}

	@Override
	public Report getOneReportById(Long id) {
		return this.reportRepository.findById(id).orElse(null);
	}



	@Override
	public Report  saveReport(ReportDto dto, MultipartFile multipartFile) throws IOException {
		Laborant laborant = this.laborantService.getOneLaborantById(dto.getLaborantId());
		Patient patient = this.patientService.getOnePatientById(dto.getPatientId());
		Report report = new Report();
		report.setReportTitle(dto.getReportTitle());
		report.setReportDescription(dto.getReportDescription());
		report.setDate(dto.getDate());
		report.setLaborant(laborant);
		report.setPatient(patient);
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		report.setImg(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
		return this.reportRepository.save(report);
	}


	}
	


