package dev.petproject.twitter.user.tweet.mapper;

import dev.petproject.twitter.security.mapper.Mapper;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetPageResponse;
import org.springframework.data.domain.Page;

public interface TweetPageResponseMapper extends Mapper<TweetPageResponse, Page<Tweet>> { }
