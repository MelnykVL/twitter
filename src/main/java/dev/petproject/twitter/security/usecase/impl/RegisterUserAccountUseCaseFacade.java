package dev.petproject.twitter.security.usecase.impl;

import dev.petproject.twitter.security.mapper.RegisterRequestToUserAccountMapper;
import dev.petproject.twitter.security.model.UserAccount;
import dev.petproject.twitter.security.service.UserAccountService;
import dev.petproject.twitter.security.usecase.RegisterUserAccountUseCase;
import dev.petproject.twitter.security.web.model.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserAccountUseCaseFacade implements RegisterUserAccountUseCase {

  private final UserAccountService userAccountService;
  private final RegisterRequestToUserAccountMapper registerRequestToUserAccountMapper;

  public RegisterUserAccountUseCaseFacade(UserAccountService userAccountService,
      RegisterRequestToUserAccountMapper registerRequestToUserAccountMapper) {
    this.userAccountService = userAccountService;
    this.registerRequestToUserAccountMapper = registerRequestToUserAccountMapper;
  }

  @Override
  public void register(RegisterRequest registerRequest) {
    UserAccount userAccount = this.registerRequestToUserAccountMapper.convert(registerRequest);
    this.userAccountService.createUserAccount(userAccount);
  }
}
