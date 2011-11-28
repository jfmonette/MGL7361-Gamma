package ca.uqam.mgl7361.a2011.gamma;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

abstract public class TestCase implements Test
{
    public String getName() {
    	return this.getClass().getName();
    }
        
    public Collection<Method> getTestMethods() {
    	Collection<Method> testMethods = new ArrayList<Method>();
    	for (Method method : this.getClass().getMethods()) {
    		if (method.getName().startsWith("test") || method.getName().equals("execute") )
    			testMethods.add(method);
    	}
    	return testMethods;
    }
    
    @Deprecated
    public final void addTest(Testable t)
    {
        //listTest.add(t);
    }
}