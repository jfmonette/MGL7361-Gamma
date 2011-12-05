package ca.uqam.mgl7361.a2011.gamma.analysis;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import ca.uqam.mgl7361.a2011.gamma.executions.Execution;
import ca.uqam.mgl7361.a2011.gamma.executions.Executions;
import ca.uqam.mgl7361.a2011.gamma.executions.ExecutionsHistory;
import ca.uqam.mgl7361.a2011.gamma.executions.Execution.Result;

public class ExecutionsAnalyserTest {

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
	public void testAnalyse() {
		ExecutionsAnalyser analyser = new ExecutionsAnalyser();
		Collection<StatisticalAnalysis> analysises = analyser.analyse(history);
		int expected = 3;
		int result = analysises.size();
		assertEquals(expected, result);
	}
}
