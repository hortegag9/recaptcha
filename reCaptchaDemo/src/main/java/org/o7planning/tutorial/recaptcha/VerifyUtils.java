package org.o7planning.tutorial.recaptcha;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

public class VerifyUtils {
	
	public static final String SITE_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
	
	public static boolean verify(String gRecaptchaResponse) {
		
		if(gRecaptchaResponse == null || gRecaptchaResponse.length() == 0) {
			return false;
		}
		
		try {
			
			// Open a Connection to URL above
			URL verifyUrl = new URL(SITE_VERIFY_URL);
			HttpsURLConnection conn = (HttpsURLConnection) verifyUrl.openConnection();
			
			// Add the Header informations to the Request to prepare send to the server.
			conn.setRequestMethod("POST");
	        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
	        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	        
	       // Data will be sent to the server.
	       String posParams = "secret="+MyConstans.SECRET_KEY+"&response="+gRecaptchaResponse;
	       System.out.println("posParams: "+posParams);
	       
	       //send Request
	       conn.setDoOutput(true);
	       
	       // Get the output stream of Connection.
           // Write data in this stream, which means to send data to Server.
           OutputStream outStream = conn.getOutputStream();           
           outStream.write(posParams.getBytes());
           System.out.println("stream of connection: "+outStream.toString());
           outStream.flush();
           outStream.close();
           
           
           // Response code return from Server.
           int responseCode = conn.getResponseCode();
           System.out.println("responseCode=" + responseCode);
           
           // Get the Input Stream of Connection to read data sent from the Server.
           InputStream is = conn.getInputStream();
           JsonReader jsonReader = Json.createReader(is);
           JsonObject jsonObject = jsonReader.readObject();
           jsonReader.close();
           System.out.println("Response: "+jsonObject);
           boolean success = jsonObject.getBoolean("success");
           return success;
		
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

}
