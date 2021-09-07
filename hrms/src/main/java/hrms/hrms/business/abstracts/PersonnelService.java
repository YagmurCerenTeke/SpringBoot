package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Personnel;

public interface PersonnelService {
	
	DataResult<List<Personnel>> getAll();
	
	Result add(Personnel personnel);
}
