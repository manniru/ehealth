package com.anas.ehealth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Sms {

	public static void main(String[] args) {
		Sms sms = new Sms();
		sms.sendsms("601123765837", "hellotestingmesssage");
		

	}
	
	public String sendsms(String mobileno, String message) {
		String rt = "";
		try {
			URL url = new URL("http://mannirserver.appspot.com/sms.jsp?no="+mobileno+"&key=13132&msg="+message);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String strTemp = "";
			while (null != (strTemp = br.readLine())) {
				System.out.println(strTemp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return rt;
	}

}
