package com.philipneo.twitterapp.data.repositories;

import com.philipneo.twitterapp.data.model.Tweet;
import com.philipneo.twitterapp.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findByAuthorOrderByCreatedAtDesc(User author);
}
