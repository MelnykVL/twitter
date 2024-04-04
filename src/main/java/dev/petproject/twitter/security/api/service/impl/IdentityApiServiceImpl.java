package dev.petproject.twitter.security.api.service.impl;

import dev.petproject.twitter.security.api.model.CurrentUserApiModel;
import dev.petproject.twitter.security.api.service.IdentityApiService;
import dev.petproject.twitter.security.service.UserAccountService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class IdentityApiServiceImpl implements IdentityApiService {

  private final UserAccountService userAccountService;

  public IdentityApiServiceImpl(UserAccountService userAccountService) {
    this.userAccountService = userAccountService;
  }

  @Override
  public Optional<CurrentUserApiModel> currentUserAccount() {
    Authentication authentication = SecurityContextHolder.getContext()
        .getAuthentication();
    if (authentication == null) {
      return Optional.empty();
    }
    String username = authentication.getName();

    return this.userAccountService.findUserByUsername(username)
        .map(userAccount -> new CurrentUserApiModel(userAccount.getId()));
  }
}
