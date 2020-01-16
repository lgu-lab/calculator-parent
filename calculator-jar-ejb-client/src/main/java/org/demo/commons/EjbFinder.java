package org.demo.commons;

import javax.naming.NamingException;

public class EjbFinder {

	private static final JndiFinder jndiFinder = new JndiFinder("localhost", 8080);
	
	public static final JndiFinder getJndiFinder() {
		return jndiFinder ;
	}
	
	public static final  <T> T lookup(String name, Class<T> clazz) throws NamingException {
		return jndiFinder.lookup(name, clazz);
	}
}
