/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.fcm.http;

import com.jofrantoba.fcm.constants.EnumContentType;
import com.jofrantoba.fcm.constants.EnumResponse;
import com.jofrantoba.fcm.entity.AndroidNotificationPayLoad;
import com.jofrantoba.fcm.entity.DataPayLoad;
import com.jofrantoba.fcm.entity.DataResponse;
import com.jofrantoba.fcm.entity.NotificationMessage;
import com.jofrantoba.fcm.entity.StatusIds;
import com.jofrantoba.fcm.shared.UnknownException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
@Log4j2
public class TestHttpFcmConnection extends TestBase{
    private final static String FIREBASE_SERVER_KEY="AIzaSyCKB1cXore70KWHAswFW7kqRKoF_e_tXng";
    //private final static String FIREBASE_SERVER_KEY="AIzaSyCf-kRyN7Cv47SI1j30sqkmRJmUl7K3OO0";
    
    @Test
    void send1()throws UnknownException{
        try{
        NotificationMessage not=new NotificationMessage();   
    	//not.setTargetTo("e1iMVdE_JMM:APA91bH-a08EINdsPgBTyxOz3NOkFlPPnYBpufF9Rs_9f4gSWntR2AprYXOovkdsYnZj_RuqkmE9U9VHTbmi-iyZTfCstdsMb4ECu6d_xya6YOtWIvBt4Ll0Hi0vx3IbAeZoLc995awC");
    	//not.setTargetTo("xx");
    	Collection<String> ids=new ArrayList<String>();
    	ids.add("fsOJ_pDTlKk:APA91bGM-8FhUpBTxl2TSh0GkVNuWkRXGoDCq953yZyUeltUzF2BUhpvwvzDzktSd-s8E5oh7g3VXNNdebHvRElpo_OY9KGKLYmOq1QoGnisorhxm1G2FWk2VVgX5xk1j3bBnbc-r5Jc");
    	ids.add("fsOJ_pDTlKk:APA91bGM-8FhUpBTxl2TSh0GkVNuWkRXGoDCq953yZyUeltUzF2BUhpvwvzDzktSd-s8E5oh7g3VXNNdebHvRElpo_OY9KGKLYmOq1QoGnisorhxm1G2FWk2VVgX5xk1j3bBnbc-r5Jc");
    	ids.add("fsOJ_pDTlKk:APA91bGM-8FhUpBTxl2TSh0GkVNuWkRXGoDCq953yZyUeltUzF2BUhpvwvzDzktSd-s8E5oh7g3VXNNdebHvRElpo_OY9KGKLYmOq1QoGnisorhxm1G2FWk2VVgX5xk1j3bBnbc-r5Jc");
    	ids.add("fsOJ_pDTlKk:APA91bGM-8FhUpBTxl2TSh0GkVNuWkRXGoDCq953yZyUeltUzF2BUhpvwvzDzktSd-s8E5oh7g3VXNNdebHvRElpo_OY9KGKLYmOq1QoGnisorhxm1G2FWk2VVgX5xk1j3bBnbc-r5Jc");
    	ids.add("fsOJ_pDTlKk:APA91bGM-8FhUpBTxl2TSh0GkVNuWkRXGoDCq953yZyUeltUzF2BUhpvwvzDzktSd-s8E5oh7g3VXNNdebHvRElpo_OY9KGKLYmOq1QoGnisorhxm1G2FWk2VVgX5xk1j3bBnbc-r5Jc");
    	ids.add("fsOJ_pDTlKk:APA91bGM-8FhUpBTxl2TSh0GkVNuWkRXGoDCq953yZyUeltUzF2BUhpvwvzDzktSd-s8E5oh7g3VXNNdebHvRElpo_OY9KGKLYmOq1QoGnisorhxm1G2FWk2VVgX5xk1j3bBnbc-r5Jc");
    	ids.add("fsOJ_pDTlKk:APA91bGM-8FhUpBTxl2TSh0GkVNuWkRXGoDCq953yZyUeltUzF2BUhpvwvzDzktSd-s8E5oh7g3VXNNdebHvRElpo_OY9KGKLYmOq1QoGnisorhxm1G2FWk2VVgX5xk1j3bBnbc-r5Jc");
    	ids.add("eS1lnW8_D7A:APA91bGKBvdP1ZT26eFcHRXKYD1pny1oUdegL95BsBdPPIGoe0IL4EJKCBZfscsfrRMsxNUjaixvFhn9vayRQYmVFiiZQlOmOKFyRfSrUgh8kldnP1kF9TfJorsj0l8AifXzQKFFomQH");
    	
    	not.setTargetRegistrationIds(ids);
    	not.setOptionRestrictedPackageName("com.indiant");
    	not.setOptionPriority(10);            
    	AndroidNotificationPayLoad payLoad=new AndroidNotificationPayLoad();
    	payLoad.setTitle("INDIANT");
    	payLoad.setBody("HOLA MUNDO");
    	payLoad.setColor("#ffffff");
    	payLoad.setSound("default");
    	DataPayLoad dataPayLoad=new DataPayLoad();
    	dataPayLoad.add("idNotification", 121354654);
    	not.setPayLoadData(dataPayLoad.buildPayLoad());
    	not.setPayLoadNotification(payLoad.buildPayLoadAndroid());    	
    	HttpFcmConection cnx=new HttpFcmConection(FIREBASE_SERVER_KEY,EnumContentType.JSON.getValue());    	    	
    	DataResponse dataResponse=(DataResponse)cnx.sendNotificationHttp(not).get(EnumResponse.RESPONSEMESSAGE.getValue());
    	Collection<StatusIds> status=not.viewStatusIds(dataResponse.getResults());
    	Iterator<StatusIds> i=status.iterator();
    	while(i.hasNext()){
    		StatusIds bean=i.next();
                log.info("ID:{}",bean.getId());    	
                log.info("Status Message:{}",bean.getStatusMessage());    	
                log.info("Is Correct:{}",bean.getIsCorrect());    	
    	}
    	log.info("DataResponse:{}",dataResponse);    	
        }catch(IOException ex){
            throw new UnknownException(this.getClass(),ex.getMessage(),ex.fillInStackTrace());
        }
    }
}
