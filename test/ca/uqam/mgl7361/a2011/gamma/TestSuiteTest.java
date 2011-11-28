package ca.uqam.mgl7361.a2011.gamma;

import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;

import ca.uqam.mgl7361.a2011.gamma.mocking.MockTestCase;
import ca.uqam.mgl7361.a2011.gamma.mocking.MockTestSuite;

public class TestSuiteTest {

	@Test
	public void itTestsGetName() {
		String expected = "ca.uqam.mgl7361.a2011.gamma.mocking.MockTestSuite";
		MockTestSuite testSuite = new MockTestSuite();
		String result = testSuite.getName();
		assertEquals(expected, result);
	}
	
	@Test
	public void itTestsTheReturnedTestMethods() {
		MockTestCase testCase = new MockTestCase();
		Collection<Method> expected = new ArrayList<Method>();
    	for (Method method : this.getClass().getMethods()) {
    		if (method.getName().startsWith("test") || method.getName().equals("execute") )
    			expected.add(method);
    	}
    	Collection<Method> result = testCase.getTestMethods();
    	assertTrue(result.containsAll(expected));
	}
}
