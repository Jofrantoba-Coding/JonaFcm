/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.fcm.xmpp;

import com.jofrantoba.fcm.entity.AndroidNotificationPayLoad;
import com.jofrantoba.fcm.entity.DataPayLoad;
import com.jofrantoba.fcm.entity.NotificationMessage;
import com.jofrantoba.fcm.shared.UnknownException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.log4j.Log4j2;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
@Log4j2
public class TestXmppFcmNotification extends TestBase {

    @Test
    void send1() throws NoSuchAlgorithmException, KeyManagementException{       
            int contador = 0;
            //while (true) {                
                try {
                    contador = contador + 1;
                    NotificationMessage not = new NotificationMessage();
                    //not.setTargetTo("dWWgMtn5GBA:APA91bGSiN7a2LVuuHl3ydyTZtjCdNd2fnAQNJ9QMSaAEN_Tu4cZKK8ViFU4CH0nDY7rZ1Xt372G7huI3DonnvZFUdBALzkPGaBZRCFwB5nbq2KpYUMb9zzFTthZ1gLC-1wmu00oxEky");
                    //not.setTargetTo("e1iMVdE_JMM:APA91bH-a08EINdsPgBTyxOz3NOkFlPPnYBpufF9Rs_9f4gSWntR2AprYXOovkdsYnZj_RuqkmE9U9VHTbmi-iyZTfCstdsMb4ECu6d_xya6YOtWIvBt4Ll0Hi0vx3IbAeZoLc995awC");
                    not.setTargetTo("fsOJ_pDTlKk:APA91bGM-8FhUpBTxl2TSh0GkVNuWkRXGoDCq953yZyUeltUzF2BUhpvwvzDzktSd-s8E5oh7g3VXNNdebHvRElpo_OY9KGKLYmOq1QoGnisorhxm1G2FWk2VVgX5xk1j3bBnbc-r5Jc");
                    not.setOptionMessageId(java.util.UUID.randomUUID().toString());
                    not.setOptionRestrictedPackageName("com.indiant");
                    not.setOptionPriority(10);
                    AndroidNotificationPayLoad payLoad = new AndroidNotificationPayLoad();
                    payLoad.setTitle("INDIANT");
                    payLoad.setBody("HOLA MUNDO");
                    payLoad.setColor("#ffffff");
                    payLoad.setSound("default");
                    DataPayLoad dataPayLoad = new DataPayLoad();
                    dataPayLoad.add("idNotification", 121354654);
                    not.setPayLoadData(dataPayLoad.buildPayLoad());
                    not.setPayLoadNotification(payLoad.buildPayLoadAndroid());
                    String projectId = "728034091568";
                    String serverKey = "AIzaSyCKB1cXore70KWHAswFW7kqRKoF_e_tXng";                    
                    XmppFcmNotification xmpp = new XmppFcmNotification(projectId, serverKey);
                    xmpp.initXmppDeveloper(false);
                    xmpp.sendNotificationXmpp(not);
                    log.info("Send Message");
                } catch (SmackException | IOException | XMPPException ex) {
                    log.error(ex.getLocalizedMessage());
                } 
            //}        
    }
}
