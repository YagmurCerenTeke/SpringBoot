package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EmployerDao;
import hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"Employers listed.");
	}

	@Override
	public Result add(Employer employer) {
		if (this.duplicateCheck(employer)) {
			this.employerDao.save(employer);
			return new SuccessResult("Employer added.");
		}
		return new ErrorResult("Employer already exists.");
	}

	@Override
	public boolean duplicateCheck(Employer employer) {
		for (Employer user : this.employerDao.findAll()) {
			if (user.getEmail() == employer.getEmail()) {
				System.out.println("User email already exists.");
				return false;
			}
		}
		return true;
	}

}
