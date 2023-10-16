package com.tunhy.twiter.response;

import lombok.Data;

@Data
public class ApiResponse {
	
	private String messgage;
	private boolean  status;
	
	public String getMessgage() {
		return messgage;
	}
	public void setMessgage(String messgage) {
		this.messgage = messgage;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
