package dev.petproject.twitter.security.mapper;

import dev.petproject.twitter.security.model.UserAccount;
import dev.petproject.twitter.security.web.model.RegisterRequest;

// TODO: Use Converter interface instead own Mapper interface
public interface RegisterRequestToUserAccountMapper extends Mapper<UserAccount, RegisterRequest> {}
