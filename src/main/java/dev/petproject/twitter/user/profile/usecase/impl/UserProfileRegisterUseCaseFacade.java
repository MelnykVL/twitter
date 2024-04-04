package dev.petproject.twitter.user.profile.usecase.impl;

import dev.petproject.twitter.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.profile.service.UserProfileService;
import dev.petproject.twitter.user.profile.usecase.UserProfileRegisterUseCase;
import dev.petproject.twitter.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRegisterUseCaseFacade implements UserProfileRegisterUseCase {

  private final UserProfileService userProfileService;
  private final UserProfileRegisterRequestToUserProfileMapper mapper;

  public UserProfileRegisterUseCaseFacade(UserProfileService userProfileService,
      UserProfileRegisterRequestToUserProfileMapper mapper) {
    this.userProfileService = userProfileService;
    this.mapper = mapper;
  }

  @Override
  public void registerUserProfile(UserProfileRegisterRequest registerRequest) {
    UserProfile userProfile = this.mapper.map(registerRequest);
    this.userProfileService.createUserProfile(userProfile);
  }
}
