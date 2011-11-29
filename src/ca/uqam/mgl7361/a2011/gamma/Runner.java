package ca.uqam.mgl7361.a2011.gamma;

import java.lang.reflect.Method;
import java.util.*;

import ca.uqam.mgl7361.a2011.gamma.Execution.TestResult;

public class Runner {
	
	public Execution run(Collection<Test> tests) {
		Execution execution = new Execution();
		Collection<Method> testMethods = getAllTestMethods(tests);
		long startTime = System.nanoTime();
		for (Method testMethod : testMethods) {
			try {
				invokeTestMethod(testMethod);
				execution.put(testMethod, TestResult.SUCCESSFUL);
			} catch (Exception e) {
				execution.put(testMethod, TestResult.FAILED);
			}
		}
		execution.setExecutionTime(System.nanoTime() - startTime);
		return execution;
	}
	
	public Execution run(Test test) {
		Collection<Test> tests = new ArrayList<Test>();
		tests.add(test);
		Execution execution = run(tests);  
		return execution;
	}
	
	private Collection<Method> getAllTestMethods(Collection<Test> tests) {
		Collection<Method> testMethods = new ArrayList<Method>();
		for (Test test : tests) {
			testMethods.addAll(test.getTestMethods());
		}
		return testMethods;
	}
	
	private void invokeTestMethod(Method testMethod) throws Exception {
		String testClassName = testMethod.getDeclaringClass().getName();
		Test testInstance = (Test)Class.forName(testClassName).newInstance();
		testInstance.setUp();
		testMethod.invoke(testInstance);
		testInstance.tearDown();
	}
}
