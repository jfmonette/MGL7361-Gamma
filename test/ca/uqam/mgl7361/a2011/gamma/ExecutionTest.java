package ca.uqam.mgl7361.a2011.gamma;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.Date;

import org.junit.Test;

import ca.uqam.mgl7361.a2011.gamma.Execution.TestResult;
import ca.uqam.mgl7361.a2011.gamma.mocking.MockTestCase;

public class ExecutionTest {

	@Test
	public void itTestsTheConstructor() {
		Date expectedTime = new Date();
		Execution expected = new Execution(expectedTime);
		assertEquals(expected.getTime(), expectedTime);
	}
	
	@Test
	public void itTestsAddingASuccessfulTest() {
		MockTestCase testCase = new MockTestCase();
		Execution execution = new Execution(new Date());
		Method aTestMethod = (Method) testCase.getTestMethods().toArray()[0];
		execution.put(aTestMethod, TestResult.SUCCESSFUL);
		assertEquals(execution.getNumberOfTests(), 1);
		assertTrue(execution.getTestResults().containsKey(aTestMethod));
		assertEquals(execution.getNumberOfFailures(), 0);
	}
	
	@Test
	public void itTestsAddingAFailedTest() {
		MockTestCase testCase = new MockTestCase();
		Execution execution = new Execution(new Date());
		Method aTestMethod = (Method) testCase.getTestMethods().toArray()[0];
		execution.put(aTestMethod, TestResult.FAILED);
		assertEquals(execution.getNumberOfTests(), 1);
		assertTrue(execution.getTestResults().containsKey(aTestMethod));
		assertEquals(execution.getNumberOfFailures(), 1);
	}
}
