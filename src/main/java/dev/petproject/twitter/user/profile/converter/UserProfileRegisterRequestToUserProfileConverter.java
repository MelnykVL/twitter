package dev.petproject.twitter.user.profile.converter;

import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.core.convert.converter.Converter;

public interface UserProfileRegisterRequestToUserProfileConverter
    extends Converter<UserProfileRegisterRequest, UserProfile> { }
