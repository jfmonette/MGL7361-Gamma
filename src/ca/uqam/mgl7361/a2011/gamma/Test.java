package ca.uqam.mgl7361.a2011.gamma;

import java.lang.reflect.Method;
import java.util.Collection;

interface Test
{
	String getName();
	Collection<Method> getTestMethods();
	void setUp();
	void tearDown();
}