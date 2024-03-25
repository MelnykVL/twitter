package dev.petproject.twitter.user.profile.mapper.impl;

import dev.petproject.twitter.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRegisterRequestToUserProfileMapperImpl implements UserProfileRegisterRequestToUserProfileMapper {

    @Override
    public UserProfile map(UserProfileRegisterRequest registerRequest) {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(1L);
        userProfile.setNickname(registerRequest.nickname());
        userProfile.setImageLink(registerRequest.imageLink());

        return userProfile;
    }
}
