package dev.petproject.twitter.security.web;

import dev.petproject.twitter.security.usecase.RegisterUserAccountUseCase;
import dev.petproject.twitter.security.web.model.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class UserAccountController {

  private final RegisterUserAccountUseCase registerUserAccountUseCase;

  public UserAccountController(RegisterUserAccountUseCase registerUserAccountUseCase) {
    this.registerUserAccountUseCase = registerUserAccountUseCase;
  }

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public void registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
    registerUserAccountUseCase.register(registerRequest);
  }
}