package com.tunhy.twiter.service;

import java.util.List;

import com.tunhy.twiter.exception.TwitException;
import com.tunhy.twiter.exception.UserException;
import com.tunhy.twiter.model.Like;
import com.tunhy.twiter.model.User;

public interface LikeService {

	public Like likeTwit(Long twitId, User user) throws UserException, TwitException;
	public List<Like> getAllLikes(Long twitId) throws TwitException;
	
	
}
