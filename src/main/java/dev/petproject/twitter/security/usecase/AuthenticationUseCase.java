package dev.petproject.twitter.security.usecase;

import dev.petproject.twitter.security.web.model.AccessToken;
import dev.petproject.twitter.security.web.model.LoginRequest;

public interface AuthenticationUseCase {

  AccessToken authenticate(LoginRequest loginRequest);
}