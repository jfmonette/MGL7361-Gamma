package ca.uqam.mgl7361.a2011.gamma.executions;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uqam.mgl7361.a2011.gamma.executions.Execution.Result;

public class ExecutionsHistoryTest {
	private static ExecutionsHistory history = new ExecutionsHistory();
	private static Random randomGenererator = new Random();
	private static int numberOfExecutionsInHistory = randomGenererator.nextInt(20);
	private static int numberOfExecutionInExecutions = randomGenererator.nextInt(10);

	@BeforeClass
	public static void setUpBeforeClass() {
		for (int i = 0 ; i < numberOfExecutionsInHistory; i++) {
			Executions executions = new Executions("Executions" + i);
			executions.setExecutionDate(new Date(2011, 10, 10 + i));
			Result result = getRandomResult();
			for (int j = 0 ; j < numberOfExecutionInExecutions; j++) {
				Execution execution = new Execution();
				execution.setExecutionTime(getRandomExecutionTime());
				execution.setResult(result);
				executions.add(execution);
			}
			history.add(executions);
		}
	}

	private static Result getRandomResult() {
		Result result;
		boolean randomBoolean = randomGenererator.nextBoolean();
		if (randomBoolean) {
			result = Result.Successful;
		}
		else {
			result = Result.Failed;
		}
		return result;
	}

	private static long getRandomExecutionTime() {
		return (long)randomGenererator.nextInt(100);
	}

	@Test
	public void testGetExecutionTimes() {
		Collection<Double> times = history.getExecutionTimes();
		int expected = numberOfExecutionsInHistory;
		int result = times.size();
		assertEquals(expected, result);
	}

	@Test
	public void testGetNumberOfExecutionsByDay() {
		Collection<Double> executions = history.getNumberOfExecutionsByDay();
		int expected = numberOfExecutionsInHistory;
		int result = executions.size();
		assertEquals(expected, result);
	}

	@Test
	public void testGetTurnAroundTimes() {
		Collection<Double> turnAroundTimes = history.getTurnAroundTimes();
		int maxExpected = numberOfExecutionsInHistory;
		int result = turnAroundTimes.size();
		assertTrue(result <= maxExpected);
	}

}
