package com.philipneo.twitterapp.service;

import com.philipneo.twitterapp.data.model.Tweet;
import com.philipneo.twitterapp.data.model.User;
import com.philipneo.twitterapp.data.repositories.TweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetServiceImpl implements TweetService {
    private TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet createTweet(Tweet tweet) {
        // business logic for creating a tweet
        return tweetRepository.save(tweet);
    }

    @Override
    public List<Tweet> getTweetsByAuthor(User author) {
        // business logic for retrieving tweets by author
        return tweetRepository.findByAuthorOrderByCreatedAtDesc(author);
    }
}
