package com.jofrantoba.fcm.entity;

import java.io.Serializable;
import java.util.Collection;
import lombok.Data;

@Data
public class DataResponse implements Serializable{
	private Long multicast_id;
	private Integer success;
	private Integer failure;
	private Integer canonical_ids;
	private Collection<Result> results;
	private String message_id;
		
}
