package dev.petproject.twitter.security.converter;

import dev.petproject.twitter.security.model.UserAccount;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.User;

public interface UserAccountToUserConverter extends Converter<UserAccount, User> { }
