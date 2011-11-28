package ca.uqam.mgl7361.a2011.gamma;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

abstract public class TestSuite implements Test
{
    private Collection<Test> tests = new ArrayList<Test>();
    
    public final void addTest(Test t)
    {
        tests.add(t);
    }

	public String getName() {
		return this.getClass().getName();
	}

	public Collection<Method> getTestMethods() {
		Collection<Method> testMethods = new ArrayList<Method>();
		testMethods.addAll(getSelfTestMethods());
		testMethods.addAll(getInnerTestMethods());
    	return  testMethods;
	}

	private Collection<Method> getSelfTestMethods() {
		Collection<Method> testMethods = new ArrayList<Method>();
		for (Method method : this.getClass().getMethods()) {
    		if (method.getName().startsWith("test") || method.getName().equals("execute") )
    			testMethods.add(method);
    	}
		return testMethods;
	}
	private Collection<Method> getInnerTestMethods() {
		Collection<Method> testMethods = new ArrayList<Method>();
		for (Test test : tests) {
			testMethods.addAll(test.getTestMethods());
		}
		return testMethods;
	}
}