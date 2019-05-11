package org.usehhapi.ConnectApi;
import java.io.UnsupportedEncodingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.usehhapi.DataStructure.Areas;
import org.usehhapi.DataStructure.Vacancy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Query {
	
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
		int Allkeys = KeySkills.size();
		Connect http = new Connect();  
		
  	
		JSONParser parser = new JSONParser();
		ObservableList<String> names = FXCollections.observableArrayList();
		ObservableList<String> idlist = FXCollections.observableArrayList();
		String areatext = "clusters=true&area="+area.getId()+"&";
		//String urlAll = "https://api.hh.ru/vacancies?text=java&per_page=100&page=1";	
		//String urlAll = "https://api.hh.ru/areas";	
		int c = 0;	
		try {
			//response = http.connectToApi(urlAll);
		
			
				for ( page=0;page<vacCounter;page++)
				{		   
					 urlAll = "https://api.hh.ru/vacancies?"+areatext+"text="+textname+"&per_page=1&page="+page+"";
					//System.out.println(urlAll);
					//"https://api.hh.ru/vacancies?clusters=true&area=113&text=инженер&per_page=10&page=1";
					response = http.connectToApi(urlAll);	
					//System.out.println(response);
					if(response.toString().length()>0)
					{
						objk  = parser.parse(response.toString());
						jsonObject = (JSONObject) objk;
						JSONArray jsonArray = (JSONArray) jsonObject.get("items");	
						/*System.out.println(page);*/
					if (jsonArray != null) 
						{ 
							
						//for (int j=0;j<jsonArray.size();j++)
						//	{
							
							//System.out.println("/////////////////////////////////////////////////////////////");
								//������������ ������ ������������ �� ��������
							   JSONObject jo = (JSONObject) jsonArray.get(0);
							   //System.out.println(page);
							  String id = (String) jo.get("id");
							  
							  Connect http1 = new Connect();    
							if(idlist.indexOf(id) == -1) {	
								JSONParser parser1 = new JSONParser();
							   
								String Vacancyurl= "https://api.hh.ru/vacancies/"+id+"";	
									
								StringBuffer response1 = http1.connectToApi(Vacancyurl);
								Object objk1  = parser1.parse(response1.toString());
								jsonObject = (JSONObject) objk1;
								JSONObject address =   (JSONObject) jsonObject.get("address");
								JSONArray KeySkillobj = (JSONArray) jsonObject.get("key_skills");
								//System.out.println(address);
							  // String responsibility = ""+jsonSnipped.get("responsibility");
							  // String requirement = ""+jsonSnipped.get("key_skills");
							  // String expirience = ""+ jsonSnipped.get("requirement");
							 //  JSONObject jsonSalary = (JSONObject) jo.get("salary");
							  // String from = ""+jsonSalary.get("from");
							  // String to = ""+jsonSalary.get("to");
							   //String currency = ""+jsonSalary.get("currency");
							   
							   //JSONObject alternateUrl = (JSONObject) jo.get("alternate_url");
							  String name = ""+ jo.get("name");
							 //System.out.println("\n"+name1);
							  // String alternateUrl = ""+ jo.get("alternate_url"); 
							 //System.out.println("objk1="+objk1);
							  int counter = 0;
							  for(int i = 0; i < KeySkillobj.size();i++) {
								  JSONObject ja = (JSONObject) KeySkillobj.get(i);
								  for(int c1 = 0; c1 < KeySkills.size();c1++) {
									  String skillname = (String) ja.get("name");
									  if(skillname.toLowerCase().contains(KeySkills.get(c1).toLowerCase())) {
										  counter++; 
									  }
								  }
								//System.out.println(" "+ja.get("name"));  
							  }
							 
							  if(counter > 0) {
								  //names.add(name1);
								  idlist.add(id);
								  //System.out.println("\n"+name1);
								  //System.out.println("\n"+name);
								  //System.out.println("\n"+jsonArray1);
								  //System.out.println("\\\\\\\\\\\\\\n");
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
								  Vacancy Vac = new Vacancy("https://hh.ru/vacancy/"+id, name, city, Vacancyurl, Allkeys, counter);
								  Vacancies.add(Vac);
							  }
							  
							  //System.out.println("\n"+jsonObject.get("area"));
							  //JSONObject jsonObject1 = (JSONObject) jsonObject.get("area");
							 // System.out.println("\n"+jsonObject1.get("name"));
							  // System.out.println("requirement="+expirience);
							   //System.out.println("from="+from);
							  // System.out.println("to="+to);
							  
							  // System.out.println("alternateUrl="+alternateUrl);
						  c++;
							
						   //}
							}
						}
					}
				
						
						 		
				
		}System.out.println("c="+c);System.out.println(pages);
		}
		
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int l = 0;
		for(int i = 0; i < names.size();i++) {
			System.out.println(" "+names.get(i));
			l++;
		}
		System.out.println(l);
	}
	
}
