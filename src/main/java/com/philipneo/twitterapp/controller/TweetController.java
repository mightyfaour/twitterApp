package com.philipneo.twitterapp.controller;

import com.philipneo.twitterapp.data.model.Tweet;
import com.philipneo.twitterapp.data.model.User;
import com.philipneo.twitterapp.service.TweetService;
import com.philipneo.twitterapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    private TweetService tweetService;
    private  UserService userService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping
    public Tweet createTweet(@RequestBody Tweet tweet) {
        return tweetService.createTweet(tweet);
    }

    @GetMapping("/{username}")
    public List<Tweet> getTweetsByAuthor(@PathVariable String username) {
        User author = userService.findByUsername(username);
        return tweetService.getTweetsByAuthor(author);
    }
}
