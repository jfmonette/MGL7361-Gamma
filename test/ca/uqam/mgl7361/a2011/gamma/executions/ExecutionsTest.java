package ca.uqam.mgl7361.a2011.gamma.executions;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.uqam.mgl7361.a2011.gamma.executions.Execution.Result;

public class ExecutionsTest {

	@Test
	public void testGetNumberOfExecutions() {
		int expected = 3;
		Executions executions = new Executions("anExecution");
		executions.add(new Execution());
		executions.add(new Execution());
		executions.add(new Execution());
		int result = executions.getNumberOfExecutions();
		assertEquals(result, expected);
	}

	@Test
	public void testGetNumberOfFailures() {
		int expected = 2;
		Executions executions = new Executions("anExecution");
		Execution failedExecution = new Execution();
		failedExecution.setResult(Result.Failed);
		executions.add(failedExecution);
		Execution anotherFailedExecution = new Execution();
		anotherFailedExecution.setResult(Result.Failed);
		executions.add(anotherFailedExecution);
		int result = executions.getNumberOfFailures();
		assertEquals(result, expected);
	}

}
