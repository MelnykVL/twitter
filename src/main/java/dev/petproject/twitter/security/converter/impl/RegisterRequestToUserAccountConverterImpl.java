package dev.petproject.twitter.security.converter.impl;

import dev.petproject.twitter.common.exception.TwitterException;
import dev.petproject.twitter.security.converter.RegisterRequestToUserAccountConverter;
import dev.petproject.twitter.security.model.UserAccount;
import dev.petproject.twitter.security.model.UserRole;
import dev.petproject.twitter.security.service.UserRoleService;
import dev.petproject.twitter.security.web.model.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Locale;
import java.util.Set;

@Component
public class RegisterRequestToUserAccountConverterImpl implements RegisterRequestToUserAccountConverter {

  private final UserRoleService userRoleService;
  private final PasswordEncoder passwordEncoder;

  public RegisterRequestToUserAccountConverterImpl(UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
    this.userRoleService = userRoleService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserAccount convert(RegisterRequest registerRequest) {
    UserRole userRole = this.userRoleService.findUserRole()
        .orElseThrow(() -> new TwitterException("User role not found"));

    UserAccount userAccount = new UserAccount();
    userAccount.setUsername(registerRequest.username()
        .toLowerCase(Locale.ROOT));
    userAccount.setPassword(this.passwordEncoder.encode(registerRequest.password()));
    userAccount.setAuthorities(Set.of(userRole));

    return userAccount;
  }
}
