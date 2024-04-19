package dev.petproject.twitter.security.service.impl;

import dev.petproject.twitter.common.exception.TwitterException;
import dev.petproject.twitter.security.model.UserRole;
import dev.petproject.twitter.security.repository.UserRoleRepository;
import dev.petproject.twitter.security.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

  private final UserRoleRepository userRoleRepository;

  public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
    this.userRoleRepository = userRoleRepository;
  }

  @Override
  public UserRole findUserRole() {
    return this.userRoleRepository.findByAuthority("ROLE_USER")
        .orElseThrow(() -> new TwitterException("User role not found"));
  }
}
