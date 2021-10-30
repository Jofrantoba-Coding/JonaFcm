package com.jofrantoba.fcm.entity;

import org.json.JSONObject;

/**
*
* @author jofrantoba
*/
public class DataPayLoad {
	JSONObject obj = new JSONObject();
	
	public void add(String Key,Object value){
		obj.put(Key, value);
	}
	
	public JSONObject buildPayLoad(){
		return obj;
	}
}
