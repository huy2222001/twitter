package com.tunhy.twiter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunhy.twiter.dto.TwitDto;
import com.tunhy.twiter.dto.mapper.TwitDtoMapper;
import com.tunhy.twiter.exception.TwitException;
import com.tunhy.twiter.exception.UserException;
import com.tunhy.twiter.model.Twit;
import com.tunhy.twiter.model.User;
import com.tunhy.twiter.service.TwitService;
import com.tunhy.twiter.service.UserService;

@RestController
@RequestMapping("/api/twits")
public class TwitController {
	
	@Autowired
	private TwitService twitService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<TwitDto> createTwit(@RequestBody Twit req, 
			@RequestHeader("Authorization") String jwt) throws UserException, TwitException {
		User user = userService.findUserProfileByJwt(jwt);
		
		Twit twit = twitService.createTwit(req, user);
		
		TwitDto twitDto = TwitDtoMapper.toTwitDto(twit, user);
		return new ResponseEntity<>(twitDto, HttpStatus.CREATED);
	}
	
}
