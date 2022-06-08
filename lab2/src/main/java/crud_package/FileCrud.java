package crud_package;

import fileInputOutput.FileIO;
import fileInputOutput.IOInterface;
import weather_package.Weather;

public class FileCrud implements Lab2CrudInterface {
	
	IOInterface fio;
	
	public FileCrud() {
		
		this.fio = new FileIO();
		
	}
	

	@Override
	public Weather readWeather() {
		// TODO Auto-generated method stub
		return (Weather) fio.loadFromFile();
	}

	@Override
	public void updateWeather(Weather weather) {
		// TODO Auto-generated method stub
		fio.saveToFile(weather);
	}

}
