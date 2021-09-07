package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobPositionService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobPosition;


@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	public  DataResult<List<JobPosition>> getAll() {
		return this.jobPositionService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.add(jobPosition);
	}

	@GetMapping("/getpositions")
	public  DataResult<List<String>> findAllByJobPositionName() {
		return this.jobPositionService.findAllByJobPositionName();
	}
	
	@GetMapping("/getactivepositions")
	public  DataResult<List<JobPosition>> findAllByIsActive() {
		return this.jobPositionService.findAllByIsActive();
	}
	
	@GetMapping("/getpositionsorderedbydeadline")
	public  DataResult<List<JobPosition>> findAllOrderedByDeadline() {
		return this.jobPositionService.findAllOrderedByDeadline();
	}
}

