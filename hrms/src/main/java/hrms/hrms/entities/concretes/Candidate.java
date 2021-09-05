package hrms.hrms.entities.concretes;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="Candidates")
public class Candidate {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "identityNumber")
	private String identityNumber;
	
	@Column(name = "birthYear")
	private int birthYear;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	public Candidate() {
		super();
	}

	public Candidate(int id, String firstName, String lastName, String identityNumber, int birthYear, String email,
			String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNumber = identityNumber;
		this.birthYear = birthYear;
		this.email = email;
		this.password = password;
	}

}


