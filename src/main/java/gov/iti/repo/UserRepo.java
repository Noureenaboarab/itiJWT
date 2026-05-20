package gov.iti.repo;

import gov.iti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String username);

    boolean existsByEmail(String email);
}
