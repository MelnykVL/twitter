package dev.petproject.twitter.security.repository;

import dev.petproject.twitter.security.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

  boolean existsByUsername(String username);

  Optional<UserAccount> findByUsername(String username);
}