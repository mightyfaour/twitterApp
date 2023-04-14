package com.philipneo.twitterapp.service;

import com.philipneo.twitterapp.data.model.Tweet;
import com.philipneo.twitterapp.data.model.User;

import java.util.List;

public interface TweetService {
    Tweet createTweet(Tweet tweet);
    List<Tweet> getTweetsByAuthor(User author);
}
