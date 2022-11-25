package repository;

import model.PhoneNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumbersRepository
        extends JpaRepository<PhoneNumbers, Integer> {
}
