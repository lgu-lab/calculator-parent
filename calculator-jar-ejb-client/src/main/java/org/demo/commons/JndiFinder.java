package org.demo.commons;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JndiFinder {

	private final String providerURL ;
	
	
	public JndiFinder(String providerURL) {
		super();
		this.providerURL = providerURL;
	}

	public JndiFinder(String host, int port) {
		super();
		// Build URL like "http-remoting://localhost:8080"
		this.providerURL = "http-remoting://" + host + ":" + port ;
	}

	private void log(String msg) {
		System.out.println("LOG:" + msg);
	}
	/**
	 * Creates and return a JNDI "InitialContext" <br>
	 * NB : requires "jboss-ejb-client" dependency to provide the "initial context factory"
	 * 
	 * @return
	 * @throws NamingException
	 */
	private Context createInitialContext() throws NamingException {
		log("createInitialContext()" );

		Properties jndiProperties = new Properties();
		
		// Define the InitialContext factory class
		//jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory"); // deprecated
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory"); // recommended
		
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		
		// Define remote server URL 
		//jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		jndiProperties.put(Context.PROVIDER_URL, providerURL);
		
		
		// The environment property "jboss.naming.client.ejb.context" indicates that 
		// the InitialContext implementation of the remote naming project 
		// will also create an internal EJB client context via the EJB client library. 
		// This allows the invocation of EJB components with the remote naming project.
		
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		
		return new InitialContext(jndiProperties);
	}
	
	public Object lookup(String name) throws NamingException {
		log("lookup(" + name +")" );
		Context context = createInitialContext();
		return context.lookup(name);
	}

	public <T> T lookup(String name, Class<T> clazz) throws NamingException {
		log("lookup(" + name + "," + clazz.getCanonicalName() + ")" );
//		if ( ! clazz.isInterface() ) {
//			throw new IllegalArgumentException("'" + clazz.getCanonicalName() + "' is not an interface");
//		}
		Object o = lookup(name);
		return clazz.cast(o);
	}

//	private static Context createInitialContext() throws NamingException {
//		Properties jndiProperties = new Properties();
//		// requires "jboss-ejb-client" dependency
//		
//		Properties jndiProps = new Properties();
//		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
//		jndiProps.put(Context.PROVIDER_URL,"remote://localhost:4447");
//		
//		jndiProperties.put("jboss.naming.client.ejb.context", true);
//		
//		return new InitialContext(jndiProperties);
//	}

}
