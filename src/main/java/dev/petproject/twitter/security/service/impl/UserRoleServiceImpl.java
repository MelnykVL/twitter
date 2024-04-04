package dev.petproject.twitter.security.service.impl;

import dev.petproject.twitter.security.model.UserRole;
import dev.petproject.twitter.security.repository.UserRoleRepository;
import dev.petproject.twitter.security.service.UserRoleService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

  private final UserRoleRepository userRoleRepository;

  public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
    this.userRoleRepository = userRoleRepository;
  }

  @Override
  public Optional<UserRole> findUserRole() {
    return this.userRoleRepository.findByAuthority("ROLE_USER");
  }
}
