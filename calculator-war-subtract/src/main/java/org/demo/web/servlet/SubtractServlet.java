package org.demo.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.ejb.calculator.CalculatorRemote;

/**
 * Servlet
 */
@WebServlet(urlPatterns = "/subtract")
public class SubtractServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB // @EJB can only inject "EJB" ( @Inject can inject any type of bean )
	//private CalculatorImpl calculator;  // Use the implementation directly : compile OK but deployment error
	// private CalculatorLocal calculator;  // OK, works fine
	private CalculatorRemote calculator;

	/**
	 * Default constructor.
	 */
	public SubtractServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		long r = calculator.subtract(22, 10);
		out.append("add servlet : r = " + r);
	}

}
