package labProject.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import labProject.dto.ReportDto;
import labProject.entitiy.Laborant;
import labProject.entitiy.Patient;
import labProject.entitiy.Report;

public interface ReportService {
	
	Report  saveReport(ReportDto dto,MultipartFile multipartFile) throws IOException;
	
	List<Report> findAll(String keyword);
	
	void deleteReport(Long id);

	Report getOneReportById(Long id);
	

	

}
