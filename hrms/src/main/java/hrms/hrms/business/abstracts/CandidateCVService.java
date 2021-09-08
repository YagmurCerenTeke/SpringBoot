package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CV;



public interface CandidateCVService {

	Result add(CV cv);
	
	DataResult<List<CV>> getAllByCandidate(int candidate_id);
}

