package mock;

import crud_package.Lab2CrudInterface;
import weather_package.Weather;

public class Lab2CrudMock implements Lab2CrudInterface {

	@Override
	public Weather readWeather() {
		// TODO Auto-generated method stub
		return new Weather ("Kyiv", "09.09.0009", 9, -9, 9, 9, "9999999");
	}

	@Override
	public void updateWeather(Weather weather) {
		// TODO Auto-generated method stub

	}

}
