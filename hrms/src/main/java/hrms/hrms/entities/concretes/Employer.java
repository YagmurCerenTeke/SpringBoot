package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Employer")
public class Employer {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "website")
	private String website;

	@Column(name = "email")
	private String email;

	@Column(name = "birthYear")
	private int birthYear;

	@Column(name = "phone")
	private String phone;

	@Column(name = "password")
	private String password;

	public Employer() {
		super();
	}

	public Employer(int id, String companyName, String website, String email, int birthYear, String phone,
			String password) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.website = website;
		this.email = email;
		this.birthYear = birthYear;
		this.phone = phone;
		this.password = password;
	}

}
