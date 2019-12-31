package org.demo.ejb.calculator;

import javax.ejb.Local;

@Local
public interface CalculatorLocal {
	
	public long add(long i, long j);
    public long subtract(long i, long j);
    public long multiply(long i, long j);
    public double divide(long i, long j);
    
}
