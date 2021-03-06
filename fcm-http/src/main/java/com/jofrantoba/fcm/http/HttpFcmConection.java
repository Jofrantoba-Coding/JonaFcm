/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.fcm.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.ExponentialBackOff;
import com.google.gson.Gson;
import com.jofrantoba.fcm.constants.EnumEndPoint;
import com.jofrantoba.fcm.constants.EnumHeaderHttpFcm;
import com.jofrantoba.fcm.constants.EnumResponse;
import com.jofrantoba.fcm.entity.DataResponse;
import com.jofrantoba.fcm.entity.NotificationMessage;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author jofrantoba
 */
@Log4j2
public class HttpFcmConection {
	HttpHeaders headers = new HttpHeaders();
	HttpTransport httpTransport = new NetHttpTransport();
	HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
	List<String> authorization = new ArrayList<String>();
	List<String> contentType = new ArrayList<String>();
	GenericUrl urlHttp = new GenericUrl(EnumEndPoint.FCMHTTPS.getUrlEndPoint());

	public HttpFcmConection(String ServeKey, String contentType) {
		this.authorization.add("key=" + ServeKey);
		this.contentType.add(contentType);
		this.headers.set(EnumHeaderHttpFcm.headerAuthorization.getHeader(), this.authorization);
		this.headers.set(EnumHeaderHttpFcm.headerContentType.getHeader(), this.contentType);
	}

	public HashMap<String, Object> sendNotificationHttp(NotificationMessage notification) throws IOException {
		String msgNotification = notification.buildMessageNotification();
		System.out.println(msgNotification);
		HttpContent content = ByteArrayContent.fromString(EnumHeaderHttpFcm.headerContentType.getHeader(),
				msgNotification);
		HttpRequest request = requestFactory.buildPostRequest(urlHttp, content);
		request.setHeaders(headers);
		ExponentialBackOff backoff = new ExponentialBackOff.Builder().setInitialIntervalMillis(500)
				.setMaxElapsedTimeMillis(900000).setMaxIntervalMillis(6000).setMultiplier(1.5)
				.setRandomizationFactor(0.5).build();
		request.setUnsuccessfulResponseHandler(new HttpBackOffUnsuccessfulResponseHandler(backoff));
		HttpResponse response = request.execute();
		InputStream in = response.getContent();
		StringBuilder responseMessage=new StringBuilder();
		if (in == null) {
			responseMessage.append("NO DATA FOUND");
		} else {
			BufferedReader r = new BufferedReader(new InputStreamReader(in));			
			String line = null;
			try {
				while ((line = r.readLine()) != null) {
					responseMessage.append(line);
				}
				r.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Gson gson = new Gson();
        DataResponse dataResponse = gson.fromJson(responseMessage.toString(), DataResponse.class);        
		HashMap<String, Object> resultado = new HashMap<String, Object>();
		resultado.put(EnumResponse.STATUSCODE.getValue(), response.getStatusCode());
		resultado.put(EnumResponse.STATUSMESSAGE.getValue(), response.getStatusMessage());
		resultado.put(EnumResponse.RESPONSEMESSAGE.getValue(), dataResponse);
		return resultado;
	}

}
