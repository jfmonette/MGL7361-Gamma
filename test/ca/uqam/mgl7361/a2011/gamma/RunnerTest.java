package ca.uqam.mgl7361.a2011.gamma;

import static org.junit.Assert.*;
import org.junit.Test;
import ca.uqam.mgl7361.a2011.gamma.executions.*;
import ca.uqam.mgl7361.a2011.gamma.mocking.*;

public class RunnerTest {
		
	@Test
	public void itTestsGetNumberOfTestsWithATestCase() {
		Runner runner = new Runner();
		MockTestCase testCase = new MockTestCase();
		int expected = testCase.getTestMethods().size();
		ExecutionsCollection executions = runner.run(testCase);
		int result = executions.getNumberOfExecutions();
		assertEquals(expected, result);
	}
	
	@Test
	public void itTestsGetNumberOfTestsWithATestSuite() {
		Runner runner = new Runner();
		MockTestSuite testSuite = new MockTestSuite();
		int expected = testSuite.getTestMethods().size();
		ExecutionsCollection executions = runner.run(testSuite);
		int result = executions.getNumberOfExecutions();
		assertEquals(expected, result);
	}
	
	@Test
	public void itTestsGetExecutionTimeOfTestsWithATestCase() {
		Runner runner = new Runner();
		MockTestCase testCase = new MockTestCase();
		ExecutionsCollection executions = runner.run(testCase);
		long result = executions.getExecutionTime();
		assertTrue(result > 0);
	}
	
	@Test
	public void itTestsGetExecutionTimeOfTestsWithATestSuite() {
		Runner runner = new Runner();
		MockTestSuite testSuite = new MockTestSuite();
		ExecutionsCollection executions = runner.run(testSuite);
		long result = executions.getExecutionTime();
		assertTrue(result > 0);
	}
}
