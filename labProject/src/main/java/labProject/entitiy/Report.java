package labProject.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "report")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private Long reportId;
	
	@Column(name = "report_title")
	private String reportTitle;
	
	@Column(name = "report_description")
	private String reportDescription;
	
	@Lob
	@Column(name = "img", columnDefinition = "MEDIUMBLOB")
	private String img;
	
	@Column(name = "date")
	private String date;	
	
	@ManyToOne
	@JoinColumn(name = "patientId", nullable = true)
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "laborantId",nullable = true)
	private Laborant laborant;
	

}
