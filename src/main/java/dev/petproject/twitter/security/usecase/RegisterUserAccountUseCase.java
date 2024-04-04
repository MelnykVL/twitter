package dev.petproject.twitter.security.usecase;

import dev.petproject.twitter.security.web.model.RegisterRequest;

public interface RegisterUserAccountUseCase {

  void register(RegisterRequest registerRequest);
}
