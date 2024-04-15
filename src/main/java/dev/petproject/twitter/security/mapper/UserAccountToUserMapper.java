package dev.petproject.twitter.security.mapper;

import dev.petproject.twitter.security.model.UserAccount;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.User;

public interface UserAccountToUserMapper extends Converter<UserAccount, User> { }
