package labProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import labProject.entitiy.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
	

	@Query("SELECT r FROM Report r WHERE r.reportTitle LIKE %?1%"
			+ " OR r.date LIKE %?1%")
	List<Report> findAll(String keyword);

	@Query("SELECT r FROM Report r  Order By r.date")
	List<Report> findAll();
	
	

}
