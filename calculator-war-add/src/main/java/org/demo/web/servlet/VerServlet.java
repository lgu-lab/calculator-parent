package org.demo.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.util.Util;

/**
 * Servlet to demonstrate execution error :
 *   java.lang.NoClassDefFoundError: org/demo/util/Util
 * due to packaging in a JAR file ( in EAR but out of WAR )
 */
@WebServlet(urlPatterns = "/ver")
public class VerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public VerServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.append("Version : " + Util.getVersion() );
	}

}
