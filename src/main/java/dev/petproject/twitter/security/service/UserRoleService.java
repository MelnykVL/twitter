package dev.petproject.twitter.security.service;

import dev.petproject.twitter.security.model.UserRole;

import java.util.Optional;

public interface UserRoleService {

    Optional<UserRole> findUserRole();
}
