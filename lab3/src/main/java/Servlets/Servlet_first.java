package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import Weathers.Mock;
import Weathers.Weather;

/**
 * Servlet implementation class Servlet_first
 */
@WebServlet("/Servlet_first/*")
public class Servlet_first extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Weather> lu = new Mock().getWeatherList();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_first() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setContentType("application/json");
		response.getWriter().println(lu);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Weather weather = Helpers.weatherParse(request);
		weather.setId(Helpers.getNextId(lu));
		lu.add(weather);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Weather weather = Helpers.weatherParse(request);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		System.out.println(id);
		response.setContentType("application/json");
		int index = Helpers.getIndexByWeatherId(id, lu);
		lu.set(index,weather);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		System.out.println(id);
		response.setContentType("application/json");
		int index = Helpers.getIndexByWeatherId(id, lu);
		lu.remove(index);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		setAccessControlHeaders(response);
		response.setStatus(HttpServletResponse.SC_OK);
		
	}
	
	private void setAccessControlHeaders(HttpServletResponse resp){
	
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "*");
		resp.setHeader("Access-Control-Allow-Headers", "*");
		
	}

}
