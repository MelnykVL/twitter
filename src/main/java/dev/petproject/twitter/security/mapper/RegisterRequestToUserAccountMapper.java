package dev.petproject.twitter.security.mapper;

import dev.petproject.twitter.security.model.UserAccount;
import dev.petproject.twitter.security.web.model.RegisterRequest;
import org.springframework.core.convert.converter.Converter;

public interface RegisterRequestToUserAccountMapper extends Converter<RegisterRequest, UserAccount> { }
