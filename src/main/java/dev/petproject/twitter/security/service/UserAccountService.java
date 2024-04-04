package dev.petproject.twitter.security.service;

import dev.petproject.twitter.security.model.UserAccount;
import java.util.Optional;

public interface UserAccountService {

  void createUserAccount(UserAccount userAccount);

  Optional<UserAccount> findUserByUsername(String username);
}
