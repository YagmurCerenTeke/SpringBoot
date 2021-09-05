package hrms.hrms;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hrms.hrms.api.controllers.PersonnelController;
import hrms.hrms.business.abstracts.PersonnelService;
import hrms.hrms.entities.concretes.Personnel;

@SpringBootApplication
public class HrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
		
	}

}
