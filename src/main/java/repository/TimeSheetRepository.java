package repository;

import model.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSheetRepository
        extends JpaRepository<TimeSheet, Integer> {
}
