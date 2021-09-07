package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobPosition;


public interface JobPositionService {

	DataResult<List<JobPosition>> getAll();
	
	Result add(JobPosition jobPosition);

	boolean duplicateCheck(JobPosition jobPosition);
	
	DataResult<List<String>> findAllByJobPositionName();
	
	DataResult<List<JobPosition>> findAllByIsActive();
	
	DataResult<List<JobPosition>> findAllOrderedByDeadline();
}
