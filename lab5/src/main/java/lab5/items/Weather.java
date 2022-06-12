package lab5.items;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
	
@Entity
@Table(name="weather")

public class Weather implements Serializable{
		
	@Id
	@GeneratedValue
	int id;
	String city;
	String date;
	double temp;
	double temp_min;
	double temp_max;
	double feels_like;
	String description;
		
	public Weather() {
			
	}
		
	public Weather(int id, String city, String date, double temp, double temp_min, double temp_max, double feels_like, String description) {
		super();
		this.id = id;
		this.city = city;
		this.date = date;
		this.temp = temp;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.feels_like = feels_like;
		this.description = description;
	}

	public int getId() {
		return id;
	}
		
	public String getCity() {
		return city;
	}

	public String getDate() {
		return date;
	}

	public double getTemp() {
		return temp;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public double getTemp_max() {
		return temp_max;
	}

	public double getFeels_like() {
		return feels_like;
	}

	public String getDescription() {
		return description;
	}


	public void setId(int id) {
		this.id = id;
	}
		
	public void setCity(String city) {
		this.city = city;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}

	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}

	public void setFeels_like(double feels_like) {
		this.feels_like = feels_like;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@Override
	public String toString() {
		return "{\"id\": \"" + id + "\", \"city\": \"" + city + "\", \"date\": \"" + date + "\", \"temp\": " + temp + ", \"temp_min\": " + temp_min + ", \"temp_max\": " + temp_max + ", \"feels_like\": " + feels_like + ", \"description\": \"" + description + "\"}";
	}
	
}
