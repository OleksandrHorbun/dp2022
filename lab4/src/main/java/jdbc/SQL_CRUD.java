package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Servlets.LabCRUDInterface;
import Weathers.Weather;

public class SQL_CRUD implements LabCRUDInterface<Weather> {
	
	Connection connection;
	
	public SQL_CRUD() {
		
		this.connection = new Connect().getCon();
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Weather t) {
		// TODO Auto-generated method stub
		try(PreparedStatement st = connection.prepareStatement("INSERT INTO weather (city, date, temp, temp_min, temp_max, feels_like, description)" + "VALUES (?, ?, ?, ?, ?, ?, ?)")){
			
			st.setString(1, t.getCity());
			st.setString(2, t.getDate());
			st.setDouble(3, t.getTemp());
			st.setDouble(4, t.getTemp_min());
			st.setDouble(5, t.getTemp_max());
			st.setDouble(6, t.getFeels_like());
			st.setString(7, t.getDescription());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Weather> read() {
		// TODO Auto-generated method stub
		List<Weather> list = new ArrayList<>();
		try(
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM weather;");
				){
			
			while(rs.next()) {
				
				list.add(new Weather(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getString(8)));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void update(int id, Weather t) {
		// TODO Auto-generated method stub
		
		try(PreparedStatement st = connection.prepareStatement("UPDATE weather" + "SET \"city\"=?, \"date\"=?, \"temp\"=?, \"temp_min\"=?, \"temp_max\"=?, \"feels_like\"=?, \"description\"=? WHERE id=?;")){
			
			st.setString(1, t.getCity());
			st.setString(2, t.getDate());
			st.setDouble(3, t.getTemp());
			st.setDouble(4, t.getTemp_min());
			st.setDouble(5, t.getTemp_max());
			st.setDouble(6, t.getFeels_like());
			st.setString(7, t.getDescription());
			st.setInt(8, id);
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

		try(PreparedStatement st = connection.prepareStatement("DELETE FROM weather WHERE id=?;")){
			
			st.setInt(1, id);
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
