package dev.petproject.twitter.user.profile.service.impl;

import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.profile.repository.UserProfileRepository;
import dev.petproject.twitter.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

  private final UserProfileRepository userProfileRepository;

  public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
    this.userProfileRepository = userProfileRepository;
  }

  @Override
  public void createUserProfile(UserProfile userProfile) {
    if (this.userProfileRepository.existsById(userProfile.getId())) {
      String errorMessage = String.format("User profile with specified Id = %d already exists", userProfile.getId());
      throw new RuntimeException(errorMessage);
    }
    if (this.userProfileRepository.existsByNickname(userProfile.getNickname())) {
      String errorMessage = String.format("User profile with specified Nickname = %s already exists",
          userProfile.getNickname());
      throw new RuntimeException(errorMessage);
    }
    this.userProfileRepository.save(userProfile);
  }

  @Override
  public UserProfile findUserProfileById(long userProfileId) {
    return this.userProfileRepository.findById(userProfileId)
        .orElseThrow(() -> {
          String errorMessage = String.format("User with Id = %d does not exist", userProfileId);
          return new RuntimeException(errorMessage);
        });
  }
}
