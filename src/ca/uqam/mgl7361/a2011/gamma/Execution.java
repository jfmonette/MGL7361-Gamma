package ca.uqam.mgl7361.a2011.gamma;

import java.lang.reflect.Method;
import java.util.*;

public class Execution {
	private Date time = new Date();
	private Map<Method, TestResult> tests = new HashMap<Method, TestResult>();
	
	public Execution(Date time) {
		this.time = time;
	}
	public Date getTime() {
		return time;
	}
	public void put(Method test, TestResult testResult) {
		tests.put(test, testResult);
	}
	public Map<Method, TestResult> getTestResults() {
		return tests;
	}
	public int getNumberOfTests() {
		return tests.size();
	}
	public int getNumberOfFailures() {
		int numberOfFailures = 0;
		for (TestResult result : tests.values()) {
			if (result.equals(TestResult.FAILED))
				numberOfFailures++;
		}
		return numberOfFailures;
	}
	public enum TestResult {
		SUCCESSFUL,
		FAILED
	}
}
