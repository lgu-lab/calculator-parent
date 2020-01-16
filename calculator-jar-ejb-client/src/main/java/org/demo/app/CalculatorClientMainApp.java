package org.demo.app;

import org.demo.ejb.calculator.CalculatorProvider;
import org.demo.ejb.calculator.CalculatorRemote;

public class CalculatorClientMainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Starting...");
		try {
			System.out.println("Getting CalculatorRemote ...");
//			CalculatorRemote calculator = JndiFinder.getCalculator();
			CalculatorRemote calculator = CalculatorProvider.getInterface();
			System.out.println("CalculatorRemote found");
			
			System.out.println("Invoking CalculatorRemote ...");

			System.out.println("result = " + calculator.add(2,3) );
			System.out.println("result = " + calculator.add(20,33));
			System.out.println("result = " + calculator.add(14,20));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
