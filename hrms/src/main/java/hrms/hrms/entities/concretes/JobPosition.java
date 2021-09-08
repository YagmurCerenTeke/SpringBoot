package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "JobPositions")
public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "details", nullable = false)
	private String details;
	
	@ManyToOne()
	@JoinColumn(name = "Employer_id")
	private Employer employer;
	
	@Column(name = "city", nullable = false)
	private String city; 
	
	@Column(name = "numberOfCandidatesToHire", nullable = false)
	private int numberOfCandidatesToHire;
	
	@Column(name = "salaryMax", nullable = false)
	private int salaryMax;
	
	@Column(name = "salaryMin", nullable = false)
	private int salaryMin;

	@Column(name = "deadline", nullable = false)
	private String deadline;
	
	@Column(name = "isActive", nullable = false)
	private boolean isActive;
}
