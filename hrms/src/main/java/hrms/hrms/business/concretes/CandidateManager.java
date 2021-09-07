package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.dataAccess.abstracts.CandidateDao;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;

@Service
public class CandidateManager implements CandidateService {

	CandidateDao candidateDao;
	MernisKpsServiceAdapter mernisKpsServiceAdapter;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisKpsServiceAdapter mernisKpsServiceAdapter) {
		super();
		this.candidateDao = candidateDao;
		this.mernisKpsServiceAdapter = mernisKpsServiceAdapter;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"Candidates listed.");
	}

	@Override
	public Result add(Candidate candidate) {
		if (mernisKpsServiceAdapter.isValid(candidate) && this.duplicateCheck(candidate)) {
			candidateDao.save(candidate);
			return new SuccessResult("Employer added.");
		} else {
			return new ErrorResult("Employer already exists.");
		}
	}

	@Override
	public boolean duplicateCheck(Candidate candidate) {
		for (Candidate user : this.candidateDao.findAll()) {
			if (user.getEmail() == candidate.getEmail() || user.getIdentityNumber() == candidate.getIdentityNumber()) {
				System.out.println("User email or identity number already exists.");
				return false;
			}
		}
		return true;
	}

}
