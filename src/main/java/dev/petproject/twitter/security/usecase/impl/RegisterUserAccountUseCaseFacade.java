package dev.petproject.twitter.security.usecase.impl;

import dev.petproject.twitter.security.converter.RegisterRequestToUserAccountConverter;
import dev.petproject.twitter.security.model.UserAccount;
import dev.petproject.twitter.security.service.UserAccountService;
import dev.petproject.twitter.security.usecase.RegisterUserAccountUseCase;
import dev.petproject.twitter.security.web.model.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserAccountUseCaseFacade implements RegisterUserAccountUseCase {

  private final UserAccountService userAccountService;
  private final RegisterRequestToUserAccountConverter registerRequestToUserAccountConverter;

  public RegisterUserAccountUseCaseFacade(UserAccountService userAccountService,
      RegisterRequestToUserAccountConverter registerRequestToUserAccountConverter) {
    this.userAccountService = userAccountService;
    this.registerRequestToUserAccountConverter = registerRequestToUserAccountConverter;
  }

  @Override
  public void register(RegisterRequest registerRequest) {
    UserAccount userAccount = this.registerRequestToUserAccountConverter.convert(registerRequest);
    this.userAccountService.createUserAccount(userAccount);
  }
}
