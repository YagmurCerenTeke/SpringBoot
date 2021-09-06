package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.entities.concretes.Candidate;


public interface CandidateService {

	List<Candidate> getAll();
	
	void add(Candidate candidate);
	
	boolean duplicateCheck(Candidate candidate);
	
	
}
