package repository;

import model.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionRepository
        extends JpaRepository<JobPosition, Integer> {
}
