package dev.petproject.twitter.security.service.impl;

import dev.petproject.twitter.security.service.AccessTokenService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class JwtAccessTokenServiceImpl implements AccessTokenService {

  private final JwtEncoder jwtEncoder;

  public JwtAccessTokenServiceImpl(JwtEncoder jwtEncoder) { this.jwtEncoder = jwtEncoder; }

  @Override
  public String generateIdToken(Authentication authentication) {
    UserDetails userDetails = Optional.of(authentication.getDetails())
        .filter(UserDetails.class::isInstance)
        .map(UserDetails.class::cast)
        .orElseThrow(() -> new RuntimeException("Failed to create UserDetails from Authentication."));
    List<String> roles = userDetails.getAuthorities()
        .stream()
        .map(GrantedAuthority::getAuthority)
        .toList();
    Instant issuedAt = Instant.now();
    Instant expirseAt = issuedAt.plus(10, ChronoUnit.MINUTES);
    JwtClaimsSet claimsSet = JwtClaimsSet.builder()
        .claim("scope", roles)
        .issuedAt(issuedAt)
        .expiresAt(expirseAt)
        .subject(userDetails.getUsername())
        .build();

    return this.jwtEncoder.encode(JwtEncoderParameters.from(claimsSet))
        .getTokenValue();
  }
}
