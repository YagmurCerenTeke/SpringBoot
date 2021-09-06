package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobPositionService;
import hrms.hrms.dataAccess.abstracts.JobPositionDao;

import hrms.hrms.entities.concretes.JobPosition;



@Service
public class JobPositionManager implements JobPositionService {

	JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public List<JobPosition> getAll() {
		return jobPositionDao.findAll();
	}

	@Override
	public void add(JobPosition jobPosition) {
		if(this.duplicateCheck(jobPosition)) {
			jobPositionDao.save(jobPosition);		
		}
	}

	@Override
	public boolean duplicateCheck(JobPosition jobPosition) {
		for (JobPosition user : this.getAll()) {
			if (user.getName() == jobPosition.getName()) {
				System.out.println("Position already exists.");
				return false;
			}
		}
		return true;
	}

}