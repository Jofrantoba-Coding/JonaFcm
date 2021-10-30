/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.fcm.entity;

import java.io.Serializable;
import java.util.Collection;
import lombok.Data;

/**
 *
 * @author jona
 */
@Data
public class NotificationPayLoad implements Serializable {

    protected String title;
    protected String body;
    protected String sound;
    protected String clickAction;
    protected String bodyLocKey;
    protected Collection<String> bodyLocArgs;
    protected String titleLocKey;
    protected Collection<String> titleLocArgs;
    protected String payload;
}
