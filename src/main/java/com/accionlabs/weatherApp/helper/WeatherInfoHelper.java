package com.accionlabs.weatherApp.helper;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherInfoHelper {

	private static final Logger logger = LoggerFactory.getLogger(WeatherInfoHelper.class);
	
	public static String fetchWeatherInfo(String city, String country) throws ClientProtocolException, IOException {
		logger.info("Inside WeatherInfoHelper getWeatherInfo() "+city);
		final String appId = "4ldizzTB";
        final String consumerKey = "dj0yJmk9NDZSNGFYSFl5WFJoJmQ9WVdrOU5HeGthWHA2VkVJbWNHbzlNQT09JnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTM3";
        final String consumerSecret = "6cee422dba9a08c26d6d8f0d12807b37a1b4ec0d";
        final String weatherUrl = "https://weather-ydn-yql.media.yahoo.com/forecastrss";

        long timestamp = new Date().getTime() / 1000;
        byte[] nonce = new byte[32];
        Random rand = new Random();
        rand.nextBytes(nonce);
        String oauthNonce = new String(nonce).replaceAll("\\W", "");

        List<String> parameters = new ArrayList<String>();
        parameters.add("oauth_consumer_key=" + consumerKey);
        parameters.add("oauth_nonce=" + oauthNonce);
        parameters.add("oauth_signature_method=HMAC-SHA1");
        parameters.add("oauth_timestamp=" + timestamp);
        parameters.add("oauth_version=1.0");
        // Make sure value is encoded
        parameters.add("location=" + URLEncoder.encode(city+','+country, "UTF-8"));
        parameters.add("format=json");
        Collections.sort(parameters);

        StringBuffer parametersList = new StringBuffer();
        for (int i = 0; i < parameters.size(); i++) {
            parametersList.append(((i > 0) ? "&" : "") + parameters.get(i));
        }

        String signatureString = "GET&" +
            URLEncoder.encode(weatherUrl, "UTF-8") + "&" +
            URLEncoder.encode(parametersList.toString(), "UTF-8");

        String signature = null;
        try {
            SecretKeySpec signingKey = new SecretKeySpec((consumerSecret + "&").getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHMAC = mac.doFinal(signatureString.getBytes());
            Encoder encoder = Base64.getEncoder();
            signature = encoder.encodeToString(rawHMAC);
        } catch (Exception e) {
            System.err.println("Unable to append signature");
            System.exit(0);
        }

        String authorizationLine = "OAuth " +
            "oauth_consumer_key=\"" + consumerKey + "\", " +
            "oauth_nonce=\"" + oauthNonce + "\", " +
            "oauth_timestamp=\"" + timestamp + "\", " +
            "oauth_signature_method=\"HMAC-SHA1\", " +
            "oauth_signature=\"" + signature + "\", " +
            "oauth_version=\"1.0\"";
        String URL= weatherUrl + "?location="+city+","+country+"&format=json";
        
        HttpClient client = HttpClientBuilder.create().build(); // approach 2
    	HttpGet request = new HttpGet(URL);
    	request.setHeader("Authorization", authorizationLine);
    	request.setHeader("X-Yahoo-App-Id", appId);
    	request.setHeader("Content-Type", "application/json");
    	System.out.println("Request >>"+request);
    	HttpResponse response = client.execute(request);
    		
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity);
		System.out.println("Content >>>"+content);
		
        return content;
	}

}
