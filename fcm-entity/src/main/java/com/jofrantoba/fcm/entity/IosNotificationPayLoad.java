package com.jofrantoba.fcm.entity;

import com.jofrantoba.fcm.constants.EnumNotificationPayLoad;
import java.util.Collection;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.json.JSONObject;
/**
*
* @author jofrantoba
*/
@Data
@EqualsAndHashCode(callSuper=false)
public class IosNotificationPayLoad extends NotificationPayLoad{			
	private String badge;						
	
	public JSONObject buildPayLoadIos(){
		JSONObject obj = new JSONObject();
		if(title!=null && !title.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramTitle.getTag(), title);					
		}
		if(body!=null && !body.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramBody.getTag(), body);					
		}
		if(sound!=null && !sound.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramSound.getTag(), sound);					
		}
		if(badge!=null && !badge.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramBadge.getTag(), badge);					
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
