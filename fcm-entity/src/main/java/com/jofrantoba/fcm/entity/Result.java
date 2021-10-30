package com.jofrantoba.fcm.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class Result implements Serializable{
	private String message_id;
	private String error;
	private String registration_id;
		
}
