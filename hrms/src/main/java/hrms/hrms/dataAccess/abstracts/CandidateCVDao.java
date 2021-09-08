package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrms.hrms.entities.concretes.CV;


public interface CandidateCVDao extends JpaRepository<CV,Integer>{

	
	@Query("From CV where candidate_id = :candidate_id")
	List<CV> getAllByCandidate(int candidate_id);
}
