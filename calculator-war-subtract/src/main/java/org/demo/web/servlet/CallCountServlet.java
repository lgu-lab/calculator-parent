package org.demo.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.ejb.calculator.CalculatorLocal;

/**
 * Servlet
 */
@WebServlet(urlPatterns = "/count")
public class CallCountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	//private CalculatorImpl calculator; // Use EJB implementation directly ==> Deployment error (interface required)
	private CalculatorLocal calculator; // Local interface

	/**
	 * Default constructor.
	 */
	public CallCountServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		long r = calculator.getCallCounter();
		out.append("Call counter = " + r);
	}

}
