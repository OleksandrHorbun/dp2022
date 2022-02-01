package servlet_package;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import weather_package.Weather;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Servlet_first
 */

@WebServlet("/Servlet_first")

public class Servlet_first extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		Weather weather = new Weather("Kyiv", "2022, 02, 01", -4.5, -7.9, -1.5, -5.29, "Snow");
		
		out.println("[" + weather + "]");
		
	}

}
