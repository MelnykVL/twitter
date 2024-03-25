package dev.petproject.twitter.user.profile.mapper;

import dev.petproject.twitter.security.mapper.Mapper;
import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.profile.web.model.UserProfileRegisterRequest;

public interface UserProfileRegisterRequestToUserProfileMapper extends Mapper<UserProfile, UserProfileRegisterRequest> {}
