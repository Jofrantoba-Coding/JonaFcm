package com.jofrantoba.fcm.entity;

import com.jofrantoba.fcm.constants.EnumNotificationPayLoad;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.json.JSONObject;

/**
*
* @author jofrantoba
*/
@Data
@EqualsAndHashCode(callSuper=false)
public class AndroidNotificationPayLoad extends NotificationPayLoad{		
	private String icon;	
	private String tag;
	private String color;				
	
	public JSONObject buildPayLoadAndroid(){
		JSONObject obj = new JSONObject();
		if(title!=null && !title.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramTitle.getTag(), title);					
		}
		if(body!=null && !body.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramBody.getTag(), body);					
		}
		if(icon!=null && !icon.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramIcon.getTag(), icon);					
		}
		if(sound!=null && !sound.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramSound.getTag(), sound);					
		}
		if(tag!=null && !tag.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramTag.getTag(), tag);					
		}
		if(color!=null && !color.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramColor.getTag(), color);					
		}
		if(clickAction!=null && !clickAction.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramClickAction.getTag(), clickAction);					
		}
		if(bodyLocKey!=null && !bodyLocKey.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramBodyLocKey.getTag(), bodyLocKey);					
		}
		if(bodyLocArgs!=null && !bodyLocArgs.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramBodyLocArgs.getTag(), bodyLocArgs);					
		}
		if(titleLocKey!=null && !titleLocKey.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramTitleLocKey.getTag(), titleLocKey);					
		}
		if(titleLocArgs!=null && !titleLocArgs.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramTitleLocArgs.getTag(), titleLocArgs);					
		}
		payload=obj.toString();
		return obj;
	}		
	
}
