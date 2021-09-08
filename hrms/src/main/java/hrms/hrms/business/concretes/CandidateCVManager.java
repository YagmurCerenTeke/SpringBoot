package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.CandidateCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CandidateCVDao;
import hrms.hrms.entities.concretes.CV;

@Service
public class CandidateCVManager implements CandidateCVService {

	CandidateCVDao candidateCVDao;

	@Autowired
	public CandidateCVManager(CandidateCVDao candidateCVDao) {
		super();
		this.candidateCVDao = candidateCVDao;
	}

	@Override
	public Result add(CV cv) {
		candidateCVDao.save(cv);
		return new SuccessResult("CV added.");
	}

	@Override
	public DataResult<List<CV>> getAllByCandidate(int candidate_id) {
		return new SuccessDataResult<List<CV>>(this.candidateCVDao.getAllByCandidate(candidate_id), "CV for specified candidate listed.");
	}

	
}
