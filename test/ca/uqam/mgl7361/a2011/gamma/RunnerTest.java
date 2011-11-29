package ca.uqam.mgl7361.a2011.gamma;

import static org.junit.Assert.*;
import org.junit.Test;

import ca.uqam.mgl7361.a2011.gamma.mocking.MockTestCase;
import ca.uqam.mgl7361.a2011.gamma.mocking.MockTestSuite;

public class RunnerTest {
		
	@Test
	public void itTestsGetNumberOfTestsWithATestCase() {
		Runner runner = new Runner();
		MockTestCase testCase = new MockTestCase();
		int expected = testCase.getTestMethods().size();
		Execution execution = runner.run(testCase);
		int result = execution.getNumberOfTests();
		assertEquals(expected, result);
	}
	
	@Test
	public void itTestsGetNumberOfTestsWithATestSuite() {
		Runner runner = new Runner();
		MockTestSuite testSuite = new MockTestSuite();
		int expected = testSuite.getTestMethods().size();
		Execution execution = runner.run(testSuite);
		int result = execution.getNumberOfTests();
		assertEquals(expected, result);
	}
	
	@Test
	public void itTestsGetExecutionTimeOfTestsWithATestCase() {
		Runner runner = new Runner();
		MockTestCase testCase = new MockTestCase();
		Execution execution = runner.run(testCase);
		long result = execution.getExecutionTime();
		assertTrue(result > 0);
	}
	
	@Test
	public void itTestsGetExecutionTimeOfTestsWithATestSuite() {
		Runner runner = new Runner();
		MockTestSuite testSuite = new MockTestSuite();
		Execution execution = runner.run(testSuite);
		long result = execution.getExecutionTime();
		assertTrue(result > 0);
	}
}
