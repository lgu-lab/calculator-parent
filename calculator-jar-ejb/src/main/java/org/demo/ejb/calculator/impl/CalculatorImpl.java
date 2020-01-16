package org.demo.ejb.calculator.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.demo.ejb.calculator.CalculatorLocal;
import org.demo.ejb.calculator.CalculatorRemote;

/*
 * "mappedName" : cf https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.0/html-single/developing_ejb_applications/index
 * 
 * The @EJB annotation also has a mappedName() attribute. 
 * The specification leaves this as vendor specific metadata, 
 * but JBoss EAP recognizes mappedName() as the global JNDI name of the EJB you are referencing. 
 * If you have specified a mappedName(), 
 * then all other attributes are ignored and this global JNDI name is used for binding.
 * 
 */
//@Singleton(name="calculator", mappedName="calculator") // EJB 3.1
@Singleton(mappedName="calculator") // EJB 3.1
@Local({ CalculatorLocal.class })
@Remote({CalculatorRemote.class})
@Startup // EJB 3.1
public class CalculatorImpl implements CalculatorLocal, CalculatorRemote {

	private long callCounter = 0;
	
	/**
	 * Constructor.
	 * The class must have a default public constructor.
	 */
	public CalculatorImpl() {
		super();
	}

	@PostConstruct
	void init() {
		callCounter = 0;
	}

	@Override
	public long getCallCounter() {
		return callCounter;
	}
	
	@Override
	public long add(long i, long j) {
		callCounter++;
		return (i + j);
	}

	@Override
	public double divide(long i, long j) {
		callCounter++;
		return ((double) i / j);
	}

	@Override
	public long multiply(long i, long j) {
		callCounter++;
		return (i * j);
	}

	@Override
	public long subtract(long i, long j) {
		callCounter++;
		return (i - j);
	}
}
