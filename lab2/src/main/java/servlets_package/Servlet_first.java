package servlets_package;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mock.Lab2CrudMock;
import weather_package.Weather;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import crud_package.Lab2CrudInterface;

/**
 * Servlet implementation class Servlet_first
 */
public class Servlet_first extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServletConfigInterface servletConfig; 
	Lab2CrudInterface lab2CrudInterface;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_first() {
        super();
        // TODO Auto-generated constructor stub
        this.servletConfig = new ServletConfig();
        this.lab2CrudInterface = servletConfig.getCrud();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		out.println("[" + lab2CrudInterface.readWeather() + "]");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String city = request.getParameter("city");
		String date = request.getParameter("date");
		double temp = Double.parseDouble(request.getParameter("temp"));
		double temp_min = Double.parseDouble(request.getParameter("temp_min"));
		double temp_max = Double.parseDouble(request.getParameter("temp_max"));
		double feels_like = Double.parseDouble(request.getParameter("feels_like"));
		String description = request.getParameter("description");
		
		lab2CrudInterface.updateWeather(new Weather(city, date, temp, temp_min, temp_max, feels_like, description));
		
		
	}

}
