package org.demo.ejb.calculator;

import javax.naming.NamingException;

import org.demo.commons.EjbFinder;

public class CalculatorProvider {
	
	// "ejb:application-name/module-name/distinct-name/ejb-name!interface-class"
//	public static final String CALCULATOR_NAME = "ejb:app/module//ejbname!" + CalculatorRemote.class.getCanonicalName();
//	public static final String CALCULATOR_NAME =
//	"java:global/calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT/CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote";
	public static final String CALCULATOR_NAME1 = // OK
	                    "calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT/CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote";
	public static final String CALCULATOR_NAME2 = // OK
                    "ejb:calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT/CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote";
	public static final String CALCULATOR_NAME3 = // With distinct name : OK
			// syntax : "ejb:appName/moduleName/distinctName/beanName!viewClassName
                    "ejb:calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT//CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote";
	
	public static final String CALCULATOR_NAME4 = // NOT OK
	"java:jboss/exported/calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT/CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote";
	
	public static final String CALCULATOR_NAME = CALCULATOR_NAME3 ;
	
	public static CalculatorRemote getInterface() throws NamingException {
//		JndiFinder ejb = new JndiFinder("localhost", 8080);
//		return ejb.lookup(CALCULATOR_NAME, CalculatorRemote.class);
		return EjbFinder.lookup(CALCULATOR_NAME, CalculatorRemote.class);
	}
}
