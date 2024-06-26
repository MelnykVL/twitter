package dev.petproject.twitter.user.profile.converter.impl;

import dev.petproject.twitter.common.exception.TwitterException;
import dev.petproject.twitter.security.api.model.CurrentUserApiModel;
import dev.petproject.twitter.security.api.service.IdentityApiService;
import dev.petproject.twitter.user.profile.converter.UserProfileRegisterRequestToUserProfileConverter;
import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRegisterRequestToUserProfileConverterImpl
    implements UserProfileRegisterRequestToUserProfileConverter {

  private final IdentityApiService identityApiService;

  public UserProfileRegisterRequestToUserProfileConverterImpl(IdentityApiService identityApiService) {
    this.identityApiService = identityApiService;
  }

  @Override
  public UserProfile convert(UserProfileRegisterRequest registerRequest) {
    CurrentUserApiModel currentUserApiModel = this.identityApiService.currentUserAccount()
        .orElseThrow(() -> new TwitterException("To create a user profile, the user must be authorized in the system"));

    UserProfile userProfile = new UserProfile();
    userProfile.setId(currentUserApiModel.userAccountId());
    userProfile.setNickname(registerRequest.nickname());
    userProfile.setImageLink(registerRequest.imageLink());

    return userProfile;
  }
}
