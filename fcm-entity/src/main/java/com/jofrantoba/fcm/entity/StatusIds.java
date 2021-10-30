package com.jofrantoba.fcm.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class StatusIds implements Serializable{
	private String id;
	private String statusMessage;
	private String newId;
	private Boolean isCorrect;
		
}
