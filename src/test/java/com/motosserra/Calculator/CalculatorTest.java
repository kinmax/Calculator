package com.motosserra.Calculator;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest
{
	private Calculator c;
	
	@Before
	public void inicializa()
	{
		c = new Calculator();
	}
	
	@Test
	@Parameters({ "5+3+2,10", "5,5", "-5,-5", "+5,5", "12-4-2,6", "-12-4-2,-18", "-12+7+2,-3", "+12-4-2,6", "+12+7+2,21" })
	public void calculatorTests(String exp, int expected)
	{
		int resp = c.evaluate(exp);
		assertEquals(expected, resp);
	}
	
	@Test(expected = InvalidExpressionException.class)
	public void expressaoInvalida() 
	{
		int rEsp = c.evaluate("3+4A");
	}
}
