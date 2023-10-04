package com.tunhy.twiter.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
public class Twit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private User user;

	private String content;

	private String image;

	private String video;

	@OneToMany(mappedBy = "twit", cascade = CascadeType.ALL)
	private List<Like> likes = new ArrayList<>();

	@OneToMany
	private List<Twit> replyTwits = new ArrayList<>();

	@ManyToMany
	private List<User> retwitUser = new ArrayList<>();

	@ManyToOne
	private Twit replyFor;
	
	private boolean isReply;
	
	private boolean isTwit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<Twit> getReplyTwits() {
		return replyTwits;
	}

	public void setReplyTwits(List<Twit> replyTwits) {
		this.replyTwits = replyTwits;
	}

	public List<User> getRetwitUser() {
		return retwitUser;
	}

	public void setRetwitUser(List<User> retwitUser) {
		this.retwitUser = retwitUser;
	}

	public Twit getReplyFor() {
		return replyFor;
	}

	public void setReplyFor(Twit replyFor) {
		this.replyFor = replyFor;
	}

	public boolean isReply() {
		return isReply;
	}

	public void setReply(boolean isReply) {
		this.isReply = isReply;
	}

	public boolean isTwit() {
		return isTwit;
	}

	public void setTwit(boolean isTwit) {
		this.isTwit = isTwit;
	}
	
	
	

}
