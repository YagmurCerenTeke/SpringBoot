package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.PersonnelService;
import hrms.hrms.dataAccess.abstracts.PersonnelDao;
import hrms.hrms.entities.concretes.Personnel;

@Service
public class PersonnelManager implements PersonnelService {

	PersonnelDao personnelDao;
	
	@Autowired
	public PersonnelManager(PersonnelDao personnelDao) {
		super();
		this.personnelDao = personnelDao;
	}

	@Override
	public List<Personnel> getAll() {
		return personnelDao.findAll();
	}

}