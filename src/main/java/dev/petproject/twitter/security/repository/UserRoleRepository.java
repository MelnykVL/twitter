package dev.petproject.twitter.security.repository;

import dev.petproject.twitter.security.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {}
