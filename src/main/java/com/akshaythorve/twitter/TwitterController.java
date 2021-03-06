package com.akshaythorve.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//rest controller to fetch the tweets.

@RestController
@RequestMapping(TwitterController.TWITTER_BASE_URI)
public class TwitterController {

    public static final String TWITTER_BASE_URI = "tweets";

    // IOC - inversion of control to Twitter API and injecting object to this class.
    @Autowired
    private Twitter twitter;

    @RequestMapping(value = "{hashTag}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Tweet> getTweets(@PathVariable final String hashTag) {
        return twitter.searchOperations().search(hashTag, 25).getTweets();

    }

}
