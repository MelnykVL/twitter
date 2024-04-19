package dev.petproject.twitter.security.service.impl;

import dev.petproject.twitter.security.converter.UserAccountToUserConverter;
import dev.petproject.twitter.security.service.UserAccountService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserAccountService userAccountService;
  private final UserAccountToUserConverter converter;

  public UserDetailsServiceImpl(UserAccountService userAccountService, UserAccountToUserConverter converter) {
    this.userAccountService = userAccountService;
    this.converter = converter;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return this.userAccountService.findUserByUsername(username)
        .map(this.converter::convert)
        .orElseThrow(() -> new UsernameNotFoundException("Bad credentials"));
  }
}
