package dev.petproject.twitter.user.profile.api.service.impl;

import dev.petproject.twitter.common.exception.TwitterException;
import dev.petproject.twitter.security.api.model.CurrentUserApiModel;
import dev.petproject.twitter.security.api.service.IdentityApiService;
import dev.petproject.twitter.user.profile.api.service.UserProfileApiService;
import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileApiServiceImpl implements UserProfileApiService {

  private final IdentityApiService identityApiService;
  private final UserProfileService userProfileService;

  public UserProfileApiServiceImpl(IdentityApiService identityApiService, UserProfileService userProfileService) {
    this.identityApiService = identityApiService;
    this.userProfileService = userProfileService;
  }

  @Override
  public UserProfile currentUserProfile() {
    CurrentUserApiModel currentUser = this.identityApiService.currentUserAccount()
        .orElseThrow(() -> new TwitterException("The user must be authorized in the system"));
    return this.userProfileService.findUserProfileById(currentUser.userAccountId());
  }

  @Override
  public UserProfile findUserProfileById(long userProfileId) {
    return this.userProfileService.findUserProfileById(userProfileId);
  }
}
