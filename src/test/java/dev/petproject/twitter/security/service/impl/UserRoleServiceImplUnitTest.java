package dev.petproject.twitter.security.service.impl;

import dev.petproject.twitter.common.exception.TwitterException;
import dev.petproject.twitter.security.model.UserRole;
import dev.petproject.twitter.security.repository.UserRoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserRoleServiceImplUnitTest {

  @Mock
  private UserRoleRepository userRoleRepository;

  @InjectMocks
  private UserRoleServiceImpl userRoleService;

  @Test
  void findUserRole_ShouldReturnNonEmptyUserRole() {
    UserRole expectedUserRole = new UserRole();
    expectedUserRole.setId(1L);
    expectedUserRole.setAuthority("ROLE_USER");

    Mockito.when(userRoleRepository.findByAuthority(expectedUserRole.getAuthority()))
        .thenReturn(Optional.of(expectedUserRole));

    UserRole actualResult = userRoleService.findUserRole();

    assertEquals(expectedUserRole, actualResult);
    verify(userRoleRepository, Mockito.times(1)).findByAuthority(any());
  }

  @Test
  void findUserRole_ShouldThrowTwitterException() {
    UserRole expectedUserRole = new UserRole();
    expectedUserRole.setId(1L);
    expectedUserRole.setAuthority("ROLE_USER");

    Mockito.when(userRoleRepository.findByAuthority(expectedUserRole.getAuthority()))
        .thenReturn(Optional.empty());

    assertThrows(TwitterException.class, () -> userRoleService.findUserRole());
    verify(userRoleRepository, Mockito.times(1)).findByAuthority(any());
  }
}