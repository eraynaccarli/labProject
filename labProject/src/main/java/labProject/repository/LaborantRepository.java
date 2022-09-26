package labProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import labProject.entitiy.Laborant;


@Repository
public interface LaborantRepository extends JpaRepository<Laborant, Long>{
	
	@Query("SELECT l FROM Laborant l WHERE l.laborantName LIKE %?1%"
			+ " OR l.laborantSurname LIKE %?1%"
			+  "OR l.email LIKE %?1%")
		
	List<Laborant> findAll(String keyword);

	@Query("SELECT l FROM Laborant l  Order By l.laborantName")
	List<Laborant> findAll();

	Laborant findByEmail(String username);
	
	
	
}
