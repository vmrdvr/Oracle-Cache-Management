package com.ravi.project.weather_radar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherConnection {

	public static void main(String args[]) throws Exception {

		WeatherConnection wc = new WeatherConnection();

		wc.sendGet();

	}

	private void sendGet() throws Exception {

		final String url = "https://www.bbc.co.uk/programmes";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");

		// con.setRequestProperty("bbc", "BBC One");
		// con.setRequestProperty("User-Agent", "USER_AGENT");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

}
