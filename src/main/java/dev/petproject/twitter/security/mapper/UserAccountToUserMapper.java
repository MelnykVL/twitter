package dev.petproject.twitter.security.mapper;

import dev.petproject.twitter.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;

public interface UserAccountToUserMapper extends Mapper<User, UserAccount> {}
