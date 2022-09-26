package labProject.entitiy;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "laborant" , uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laborant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "laborant_id")
	private Long laborantId; 
	
	@Column(name = "laborant_name")
	private String laborantName;
	
	@Column(name = "laborant_surname")
	private String laborantSurname;
	

	private String email;


	private String password;

	@OneToMany(mappedBy = "reportId")
	private List<Report> reports;
	
	@ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
	@JoinTable(
			name = "laborants_roles",
			joinColumns = @JoinColumn(name = "laborant_id", referencedColumnName = "laborant_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<Role> roles;
	
}
