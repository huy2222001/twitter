package com.tunhy.twiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunhy.twiter.exception.TwitException;
import com.tunhy.twiter.exception.UserException;
import com.tunhy.twiter.model.Like;
import com.tunhy.twiter.model.Twit;
import com.tunhy.twiter.model.User;
import com.tunhy.twiter.repository.LikeRepository;
import com.tunhy.twiter.repository.TwitRepository;


@Service
public class LikeServiceImplementation implements LikeService{

	@Autowired
	private LikeRepository likeRepository;
	
	@Autowired
	private TwitService twitService;
	
	
	@Autowired
	private TwitRepository twitRepository;
	
	
	@Override
	public Like likeTwit(Long twitId, User user) throws UserException, TwitException {
		Like isLikeExist = likeRepository.isLikeExits(user.getId(), twitId);
		if (isLikeExist != null) {
			likeRepository.deleteById(isLikeExist.getId());
			return isLikeExist;
		}
		Twit twit = twitService.findById(twitId);
		
		Like like = new Like();
		
		like.setUser(user);
		
		Like savedLike = likeRepository.save(like);
		
		twit.getLikes().add(savedLike);
		
		twitRepository.save(twit);
		
		return savedLike;
	}

	@Override
	public List<Like> getAllLikes(Long twitId) throws TwitException {
		Twit twit = twitService.findById(twitId);
		List<Like> likes = likeRepository.findByTwitId(twitId);
		return likes;
	}
	
}
