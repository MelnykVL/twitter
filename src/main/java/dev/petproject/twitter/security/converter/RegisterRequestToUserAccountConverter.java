package dev.petproject.twitter.security.converter;

import dev.petproject.twitter.security.model.UserAccount;
import dev.petproject.twitter.security.web.model.RegisterRequest;
import org.springframework.core.convert.converter.Converter;

public interface RegisterRequestToUserAccountConverter extends Converter<RegisterRequest, UserAccount> { }
