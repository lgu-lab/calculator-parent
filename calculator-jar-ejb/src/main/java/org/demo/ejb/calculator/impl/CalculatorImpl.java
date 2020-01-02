package org.demo.ejb.calculator.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.demo.ejb.calculator.CalculatorLocal;
import org.demo.ejb.calculator.CalculatorRemote;

@Singleton(name="calculator") // EJB 3.1
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
