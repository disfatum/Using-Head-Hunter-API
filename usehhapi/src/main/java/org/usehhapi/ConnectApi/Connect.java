package org.usehhapi.ConnectApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connect {
	private final String USER_AGENT = "Mozilla/5.0";
	 //Получение 100 вакансий для страны и запись в БД
	//Функция подключения к api hh и формирования ответа
		public StringBuffer connectToApi(String url) throws Exception 
		{
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			StringBuffer response = new StringBuffer();
			con.setRequestMethod("GET");

			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			if(responseCode==200)
			{
				//System.out.println("\nSending 'GET' request to URL : " + url);
				//System.out.println("Response Code : " + responseCode);

				BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
				String inputLine;
				
				
				while ((inputLine = in.readLine()) != null) 
				{
					response.append(inputLine);
				}
				in.close();
			}		
			return response;
		}
}
