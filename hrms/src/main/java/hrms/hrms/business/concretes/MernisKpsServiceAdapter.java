package hrms.hrms.business.concretes;

import hrms.hrms.webService.MernisKpsService;

import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.UserValidatorService;
import hrms.hrms.entities.concretes.Candidate;

@Service
public class MernisKpsServiceAdapter implements UserValidatorService<Candidate> {

	@Override
	public boolean isValid(Candidate candidate) {
MernisKpsService mernisKpsService = new MernisKpsService();
		
		return mernisKpsService.tcKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()), 
				candidate.getFirstName(), candidate.getLastName(), candidate.getBirthYear());
	
	}



}
