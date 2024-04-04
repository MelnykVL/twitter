package dev.petproject.twitter.user.profile.api.service.impl;

import dev.petproject.twitter.security.api.model.CurrentUserApiModel;
import dev.petproject.twitter.security.api.service.IdentityApiService;
import dev.petproject.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserProfileApiServiceImpl implements CurrentUserProfileApiService {

  private final IdentityApiService identityApiService;
  private final UserProfileService userProfileService;

  public CurrentUserProfileApiServiceImpl(IdentityApiService identityApiService,
      UserProfileService userProfileService) {
    this.identityApiService = identityApiService;
    this.userProfileService = userProfileService;
  }

  @Override
  public UserProfile currentUserProfile() {
    CurrentUserApiModel currentUser = this.identityApiService.currentUserAccount()
        .orElseThrow(() -> new RuntimeException("The user must be authorized in the system"));

    return this.userProfileService.findUserProfileById(currentUser.userAccountId())
        .orElseThrow(() -> {
          String errorMessage = String.format("User with Id = %d does not exist", currentUser.userAccountId());
          throw new RuntimeException(errorMessage);
        });
  }
}
