package dev.petproject.twitter.security.service.impl;

import dev.petproject.twitter.security.model.UserAccount;
import dev.petproject.twitter.security.repository.UserAccountRepository;
import dev.petproject.twitter.security.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public void createUserAccount(UserAccount userAccount) {
        boolean isUsernameExists = this.userAccountRepository.existsByUsername(userAccount.getUsername());
        if (isUsernameExists) {
            throw new RuntimeException("Account with this username already exists");
        }
        this.userAccountRepository.save(userAccount);
    }

    @Override
    public Optional<UserAccount> findUserByUsername(String username) {
        return this.userAccountRepository.findByUsername(username);
    }
}
