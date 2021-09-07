package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "name")
	private String name;

	@Column(name = "details")
	private String details;
	
	@Column(name = "employerId")
	private int employerId;
	
	@Column(name = "city")
	private String city; 
	
	@Column(name = "numberOfCandidatesToHire")
	private int numberOfCandidatesToHire;
	
	@Column(name = "salaryMax")
	private int salaryMax;
	
	@Column(name = "salaryMin")
	private int salaryMin;

	@Column(name = "deadline")
	private String deadline;
	
	@Column(name = "isActive")
	private String isActive;
}
