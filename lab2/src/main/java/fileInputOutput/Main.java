package fileInputOutput;

import weather_package.Weather;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Weather weather = new Weather(0, "Kyiv", "08.04.2022", 8, -9, 9, 5, "Clear");

		IOInterface fio = new FileIO();
		
		fio.saveToFile(weather);
		
		System.out.println((Weather)fio.loadFromFile());
		
	}

}
