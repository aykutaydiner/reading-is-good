package com.getir.readingisgood.domain.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class BaseApiResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Long timestamp;
	private boolean success;
	private String responseMessage;
	
	public BaseApiResponse() {
		this.timestamp = System.currentTimeMillis();
	}
	
	public BaseApiResponse( boolean success) {
		this(success, null);
	}

	public BaseApiResponse(boolean success, String responseMessage) {
		this.id = UUID.randomUUID().toString();
		this.timestamp = System.currentTimeMillis();
		this.success = success;
		this.responseMessage = responseMessage;
	}
	
	
}
