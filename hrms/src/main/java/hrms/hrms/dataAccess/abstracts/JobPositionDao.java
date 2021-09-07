package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrms.hrms.entities.concretes.JobPosition;


public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {

	@Query("Select name from JobPosition")
	List<String> findAllByJobPositionName();
	
	@Query("From JobPosition where isActive = active")
	List<JobPosition> findAllByIsActive();
	
	@Query("From JobPosition order by deadline")
	List<JobPosition> findAllOrderedByDeadline();
	
}