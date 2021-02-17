package app.repository;

import app.entities.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<UserStatus, Integer> {
    Optional<UserStatus> findByStatus(String status);
}
