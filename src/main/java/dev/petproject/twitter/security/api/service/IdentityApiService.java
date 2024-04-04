package dev.petproject.twitter.security.api.service;

import dev.petproject.twitter.security.api.model.CurrentUserApiModel;
import java.util.Optional;

public interface IdentityApiService {

  Optional<CurrentUserApiModel> currentUserAccount();
}
