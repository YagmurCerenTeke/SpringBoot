package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobPositionService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
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
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Job positions listed.");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if (this.duplicateCheck(jobPosition)) {
			this.jobPositionDao.save(jobPosition);

			return new SuccessResult("Position added.");
		}
		return new ErrorResult("Position already exists.");
	}

	@Override
	public boolean duplicateCheck(JobPosition jobPosition) {
			for (JobPosition user : this.jobPositionDao.findAll()) {
				if (user.getName() == jobPosition.getName()) {
					System.out.println("Position already exists.");
					return false;
				}
			}

		return true;
	}

	@Override
	public DataResult<List<String>> findAllByJobPositionName() {
		return new SuccessDataResult<List<String>>(this.jobPositionDao.findAllByJobPositionName(), "Data listelendi.");
	}

	@Override
	public DataResult<List<JobPosition>> findAllByIsActive() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAllByIsActive(), "Data listelendi.");
	}

	@Override
	public DataResult<List<JobPosition>> findAllOrderedByDeadline() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAllOrderedByDeadline(),
				"Data listelendi.");
	}

}
