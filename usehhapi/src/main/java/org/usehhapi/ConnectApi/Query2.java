package org.usehhapi.ConnectApi;

import java.io.UnsupportedEncodingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.usehhapi.DataStructure.Areas;
import org.usehhapi.DataStructure.Vacancy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Query2 {
	
	public void Search(String text, 
			Areas area,
			ObservableList<String> KeySkills,
			ObservableList<Vacancy> Vacancies,
			int vacCounter) throws UnsupportedEncodingException {
		StringBuffer response;
		int pages = 0;
		JSONObject jsonObject;
		Object objk ;	
		String urlAll ="";
		String textname = "";
		textname = text;
		int page = 0;
		Connect http = new Connect();  
		
		JSONParser parser = new JSONParser();
		ObservableList<String> idlist = FXCollections.observableArrayList();
		String areatext = "clusters=true&area="+area.getId()+"&";
		int c = 0;	
		try {
				for ( page=0;page<vacCounter;page++)
				{		   
					urlAll = "https://api.hh.ru/vacancies?"+areatext+"text="+textname+"&per_page=1&page="+page+"";
					response = http.connectToApi(urlAll);
					if(response.toString().length()>0)
					{
						objk  = parser.parse(response.toString());
						jsonObject = (JSONObject) objk;
						JSONArray jsonArray = (JSONArray) jsonObject.get("items");	
						/*System.out.println(page);*/
					if (jsonArray != null) 
						{ 
							//System.out.println("/////////////////////////////////////////////////////////////");
							  JSONObject jo = (JSONObject) jsonArray.get(0);
							  String id = (String) jo.get("id");
							  String name = (String) jo.get("name");
							  JSONObject address =   (JSONObject) jsonObject.get("address");
							  Connect http1 = new Connect();  
							  
							if(idlist.indexOf(id) == -1) {	
								JSONParser parser1 = new JSONParser();
							   
								String Vacancyurl= "https://api.hh.ru/vacancies/"+id+"";	
								StringBuffer response1 = http1.connectToApi(Vacancyurl);
								Object objk1  = parser1.parse(response1.toString());
								jsonObject = (JSONObject) objk1;
								JSONArray KeySkillobj = (JSONArray) jsonObject.get("key_skills");
								int KS = KeySkillobj.size();
								for(int i = 0; i < KeySkillobj.size();i++) {
								  JSONObject ja = (JSONObject) KeySkillobj.get(i);
								  KeySkills.add((String)ja.get("name"));
								 }
							  
							idlist.add(id);
						 
						  String city = "";
						  try {
							  
							  city = ""+ (String) address.get("city");
						  }
						  catch(Exception e) {
							  city = "Не указан";
							  
						  }
						  if(city.equals("") ||city.equals("null")) {
							  city = "Не указан";
						  }
					  Vacancy Vac = new Vacancy("https://hh.ru/vacancy/"+id, name, city, Vacancyurl, c, KS);
					  Vacancies.add(Vac);
					  c++;
							}
						}
					}	
					
				}
				System.out.println("c="+c);System.out.println(pages);
		}
		
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
