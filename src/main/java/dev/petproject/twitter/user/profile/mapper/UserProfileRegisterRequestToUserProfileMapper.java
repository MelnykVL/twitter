package dev.petproject.twitter.user.profile.mapper;

import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.core.convert.converter.Converter;

public interface UserProfileRegisterRequestToUserProfileMapper
    extends Converter<UserProfileRegisterRequest, UserProfile> { }
