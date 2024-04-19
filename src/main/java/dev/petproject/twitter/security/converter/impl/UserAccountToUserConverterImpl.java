package dev.petproject.twitter.security.converter.impl;

import dev.petproject.twitter.security.converter.UserAccountToUserConverter;
import dev.petproject.twitter.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserAccountToUserConverterImpl implements UserAccountToUserConverter {

  @Override
  public User convert(UserAccount userAccount) {
    return new User(userAccount.getUsername(), userAccount.getPassword(), userAccount.getAuthorities());
  }
}
