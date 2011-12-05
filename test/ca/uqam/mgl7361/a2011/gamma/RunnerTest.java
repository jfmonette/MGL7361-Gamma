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
		Executions executions = runner.run(testCase);
		double result = executions.getNumberOfExecutions();
		assertTrue(expected == result);
	}
	
	@Test
	public void itTestsGetNumberOfTestsWithATestSuite() {
		Runner runner = new Runner();
		MockTestSuite testSuite = new MockTestSuite();
		int expected = testSuite.getTestMethods().size();
		Executions executions = runner.run(testSuite);
		double result = executions.getNumberOfExecutions();
		assertTrue(expected == result);
	}
	
	@Test
	public void itTestsGetExecutionTimeOfTestsWithATestCase() {
		Runner runner = new Runner();
		MockTestCase testCase = new MockTestCase();
		Executions executions = runner.run(testCase);
		double result = executions.getExecutionTime();
		assertTrue(result > 0);
	}
	
	@Test
	public void itTestsGetExecutionTimeOfTestsWithATestSuite() {
		Runner runner = new Runner();
		MockTestSuite testSuite = new MockTestSuite();
		Executions executions = runner.run(testSuite);
		double result = executions.getExecutionTime();
		assertTrue(result > 0);
	}
}
