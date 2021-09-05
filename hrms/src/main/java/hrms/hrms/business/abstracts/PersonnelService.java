package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.entities.concretes.Personnel;

public interface PersonnelService {
	
	List<Personnel> getAll();
}
