package ca.uqam.mgl7361.a2011.gamma;

import java.lang.reflect.Method;
import ca.uqam.mgl7361.a2011.gamma.executions.*;
import ca.uqam.mgl7361.a2011.gamma.executions.Execution.Result;

public class Runner {
	public Executions run(Test test) {
		Executions executions = new Executions(test.getName());
		for (Method testMethod : test.getTestMethods()) {
			executions.add(run(testMethod));
		}
		return executions;
	}
	
	private Execution run(Method testMethod) {
		Execution execution = new Execution();
		execution.setName(testMethod.getName());
		long startTime = System.nanoTime();
		try {
			invokeTestMethod(testMethod);
			execution.setResult(Result.Successful);
		} catch (Exception e) {
			execution.setResult(Result.Failed);
		}
		execution.setExecutionTime(System.nanoTime() - startTime);
		return execution;
	}

	private void invokeTestMethod(Method testMethod) throws Exception {
		String testClassName = testMethod.getDeclaringClass().getName();
		Test testInstance = (Test)Class.forName(testClassName).newInstance();
		testInstance.setUp();
		testMethod.invoke(testInstance);
		testInstance.tearDown();
	}
}
