package dev.petproject.twitter.user.tweet.mapper;

import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetPageResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

public interface TweetPageResponseMapper extends Converter<Page<Tweet>, TweetPageResponse> { }
