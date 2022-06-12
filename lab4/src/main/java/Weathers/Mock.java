package Weathers;

import java.util.ArrayList;
import java.util.List;

public class Mock {

	private List<Weather> weatherList = new ArrayList<>();
	
	public Mock() {
		
		this.weatherList.add(new Weather(0, "Kyiv", "08.04.2022", 8, -9, 9, 5, "Clear"));
		this.weatherList.add(new Weather(1, "Warsaw", "08.04.2022", 10, 5, 15, 11, "Cloudy"));
		this.weatherList.add(new Weather(2, "Lviv", "08.04.2022", 10, 0, 15, 0, "Rainy"));
		
	}

	public List<Weather> getWeatherList() {
		return weatherList;
	}

	public void setWeatherList(List<Weather> weatherList) {
		this.weatherList = weatherList;
	}
	
	
}
