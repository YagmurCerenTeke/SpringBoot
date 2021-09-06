package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.dataAccess.abstracts.CandidateDao;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.business.concretes.MernisKpsServiceAdapter;

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
	public List<Candidate> getAll() {
		return candidateDao.findAll();
	}

	@Override
	public void add(Candidate candidate) {
		if (mernisKpsServiceAdapter.isValid(candidate) && this.duplicateCheck(candidate)) {
			candidateDao.save(candidate);
		} else {
			System.out.println("User is not valid.");
		}
	}

	@Override
	public boolean duplicateCheck(Candidate candidate) {
		for (Candidate user : this.getAll()) {
			if (user.getEmail() == candidate.getEmail() || user.getIdentityNumber() == candidate.getIdentityNumber()) {
				System.out.println("User email or identity number already exists.");
				return false;
			}
		}
		return true;
	}

}