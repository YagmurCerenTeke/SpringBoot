package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.PersonnelService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Personnel;

@RestController
@RequestMapping("/api/personnels")
public class PersonnelController {

	private PersonnelService personnelService;

	@Autowired
	public PersonnelController(PersonnelService personnelService) {
		super();
		this.personnelService = personnelService;
	}

	@GetMapping("/getall")
	public DataResult<List<Personnel>> getAll() {
		return this.personnelService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Personnel personnel) {
		return this.personnelService.add(personnel);
	}
}
