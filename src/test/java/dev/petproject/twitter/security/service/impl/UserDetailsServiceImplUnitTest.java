package dev.petproject.twitter.security.service.impl;

import dev.petproject.twitter.security.converter.UserAccountToUserConverter;
import dev.petproject.twitter.security.model.UserAccount;
import dev.petproject.twitter.security.model.UserRole;
import dev.petproject.twitter.security.service.UserAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplUnitTest {

  @Mock
  private UserAccountService userAccountService;
  @Mock
  private UserAccountToUserConverter converter;

  @InjectMocks
  private UserDetailsServiceImpl userDetailsService;

  @Test
  void findUserByUsername_ShouldReturnNonEmptyUserDetails() {
    UserAccount userAccount = new UserAccount();
    userAccount.setUsername("test_user@gmail.com");
    userAccount.setPassword("test_pass");
    userAccount.setAuthorities(Collections.singleton(new UserRole()));

    User expectedUser = new User(userAccount.getUsername(), userAccount.getPassword(), userAccount.getAuthorities());

    Mockito.when(userAccountService.findUserByUsername(userAccount.getUsername()))
        .thenReturn(Optional.of(userAccount));
    Mockito.when(converter.convert(userAccount))
        .thenReturn(expectedUser);

    UserDetails actualResult = userDetailsService.loadUserByUsername(userAccount.getUsername());

    assertEquals(expectedUser, actualResult);
    Mockito.verify(userAccountService, Mockito.times(1))
        .findUserByUsername(any());
    Mockito.verify(converter, Mockito.times(1))
        .convert(any());
  }

  @Test
  void findUserByUsername_ShouldThrowUserNotFoundException() {
    UserAccount userAccount = new UserAccount();
    userAccount.setUsername("test_user@gmail.com");
    userAccount.setPassword("test_pass");
    userAccount.setAuthorities(Collections.singleton(new UserRole()));

    Mockito.when(userAccountService.findUserByUsername(userAccount.getUsername()))
        .thenReturn(Optional.empty());

    assertThrows(UsernameNotFoundException.class,
        () -> userDetailsService.loadUserByUsername((userAccount.getUsername())));
    Mockito.verify(userAccountService, Mockito.times(1))
        .findUserByUsername(any());
    Mockito.verify(converter, Mockito.never())
        .convert(any());
  }
}