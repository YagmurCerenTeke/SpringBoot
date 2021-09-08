package hrms.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.CandidateCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CV;



@RestController
@RequestMapping("/api/candidatecv")
public class CandidateCVController {

	private CandidateCVService candidateCVService;

	@Autowired
	public CandidateCVController(CandidateCVService candidateCVService) {
		super();
		this.candidateCVService = candidateCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CV cv) {
		return this.candidateCVService.add(cv);
	}
	
	@GetMapping("/getcandidatecv")
	public DataResult<List<CV>> getAllByCandidate(int candidate_id) {
		return this.candidateCVService.getAllByCandidate(candidate_id);
	}
}



