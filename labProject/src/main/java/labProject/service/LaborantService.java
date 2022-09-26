package labProject.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import labProject.entitiy.Laborant;


public interface LaborantService extends UserDetailsService{

	Laborant saveLaborant(Laborant laborant);
	
	Laborant getOneLaborantById(Long id);
	
	List<Laborant> findAll(String keyword);
	
	void deleteLaborant(Long id);
}
