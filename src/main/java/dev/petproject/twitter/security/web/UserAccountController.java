package dev.petproject.twitter.security.web;

import dev.petproject.twitter.security.usecase.impl.RegisterUserAccountUseCaseFacade;
import dev.petproject.twitter.security.web.model.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class UserAccountController {

    private final RegisterUserAccountUseCaseFacade registerRequestToUserAccountMapper;

    public UserAccountController(RegisterUserAccountUseCaseFacade registerRequestToUserAccountMapper) {
        this.registerRequestToUserAccountMapper = registerRequestToUserAccountMapper;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
        registerRequestToUserAccountMapper.register(registerRequest);
    }
}