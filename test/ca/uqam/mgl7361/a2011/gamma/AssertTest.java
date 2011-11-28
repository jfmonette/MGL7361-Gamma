package ca.uqam.mgl7361.a2011.gamma;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssertTest {

	@Test
	public void itTestsAssertEqualsWithEqualStrings() {
		boolean expected = true;
		boolean result = Assert.assertEquals("a", "a");
		assertEquals(expected, result);
	}
	
	@Test
	public void itTestsAssertEqualsWithUnequalStrings() {
		boolean expected = false;
		boolean result = Assert.assertEquals("a", "b");
		assertEquals(expected, result);
	}
	
	@Test
	public void itTestsAssertEqualsWithBooleans() {
		boolean expected = true;
		boolean result = Assert.assertEquals(true, true);
		assertEquals(expected, result);
	}
	
	@Test
	public void itTestsAssertEqualsWithUnequalBooleans() {
		boolean expected = false;
		boolean result = Assert.assertEquals(true, false);
		assertEquals(expected, result);
	}
	
	@Test
	public void itTestsAssertEqualsWithIntegers() {
		boolean expected = true;
		boolean result = Assert.assertEquals(5, 5);
		assertEquals(expected, result);
	}
	
	@Test
	public void itTestsAssertEqualsWithUnequalIntegers() {
		boolean expected = false;
		boolean result = Assert.assertEquals(5, 4);
		assertEquals(expected, result);
	}
	
	@Test
	public void itTestsAssertEqualsWithObjects() {
		boolean expected = true;
		Object anObject = new Object();
		Object anotherObject = anObject;
		boolean result = Assert.assertEquals(anObject, anotherObject);
		assertEquals(expected, result);
	}
	
	@Test
	public void itTestsAssertEqualsWithUnequalObjects() {
		boolean expected = false;
		Object anObject = new Object();
		Object anotherObject = new Object();
		boolean result = Assert.assertEquals(anObject, anotherObject);
		assertEquals(expected, result);
	}
	
	

}
