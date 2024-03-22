package dev.petproject.twitter.security.repository;

import dev.petproject.twitter.security.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    boolean existsByUsername(String username);
}