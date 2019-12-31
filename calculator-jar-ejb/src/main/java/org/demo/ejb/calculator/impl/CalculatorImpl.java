package org.demo.ejb.calculator.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.demo.ejb.calculator.CalculatorLocal;

@Singleton // EJB 3.1
@Startup // EJB 3.1
public class CalculatorImpl implements CalculatorLocal {

	private int version = 0;
	/**
	 * Constructor.
	 * The class must have a default public constructor.
	 */
	public CalculatorImpl() {
		super();
	}

	@PostConstruct
	void init() {
		version = 1;
	}

	public int getVersion() {
		return version;
	}
	
	@Override
	public long add(long i, long j) {

		return (i + j);
	}

	@Override
	public double divide(long i, long j) {

		return ((double) i / j);
	}

	@Override
	public long multiply(long i, long j) {

		return (i * j);
	}

	@Override
	public long subtract(long i, long j) {

		return (i - j);
	}
}
