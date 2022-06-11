package Servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import Weathers.Weather;
import jakarta.servlet.http.HttpServletRequest;

public class Helpers {
		
	public static JsonElement bodyParse(HttpServletRequest request) {
		JsonElement jsonElement=null;	
			
		try {
			jsonElement = JsonParser.parseReader(request.getReader());
		} catch (JsonIOException | JsonSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return jsonElement;
	}
		
	public static Weather weatherParse(HttpServletRequest request) {
		Weather weather = new Weather();
			JsonElement jsonElement = bodyParse(request);
			weather.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
			weather.setCity(jsonElement.getAsJsonObject().get("city").getAsString());
			weather.setDate(jsonElement.getAsJsonObject().get("date").getAsString());
			weather.setTemp(jsonElement.getAsJsonObject().get("temp").getAsDouble());
			weather.setTemp_min(jsonElement.getAsJsonObject().get("temp_min").getAsDouble());
			weather.setTemp_max(jsonElement.getAsJsonObject().get("temp_max").getAsDouble());
			weather.setFeels_like(jsonElement.getAsJsonObject().get("feels_like").getAsDouble());
			weather.setDescription(jsonElement.getAsJsonObject().get("description").getAsString());
			
			return weather;
		}
		
		public static int getNextId(List<Weather> list) {
			int maxId = 0;
			if (list == null) return 0;
			Iterator<Weather> iterator = list.iterator();
			while(iterator.hasNext()) {
				int currentId = iterator.next().getId();
				if(currentId>maxId) maxId=currentId;
			}
			return maxId+1;
		}
		
		public static int getIndexByWeatherId(int id,List<Weather> list) {
			int listId = id;
			
			Iterator<Weather> iterator = list.iterator();
			while(iterator.hasNext()) {
				Weather temp =iterator.next();
				if(temp.getId()==listId) { 
					listId=list.indexOf(temp);
					break;
				}
			}
			return listId;
		}	

}

