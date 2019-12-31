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
@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
//	private CalculatorImpl calculator;
	private CalculatorLocal calculator;

	/**
	 * Default constructor.
	 */
	public AddServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		long r = calculator.add(1, 2);
		out.append("add servlet : r = " + r);
	}

}
