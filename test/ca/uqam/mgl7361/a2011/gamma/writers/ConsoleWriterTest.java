package ca.uqam.mgl7361.a2011.gamma.writers;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import ca.uqam.mgl7361.a2011.gamma.*;
import ca.uqam.mgl7361.a2011.gamma.executions.ExecutionsCollection;
import ca.uqam.mgl7361.a2011.gamma.formats.*;
import ca.uqam.mgl7361.a2011.gamma.mocking.*;
import java.io.*;

public class ConsoleWriterTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

	@Test
	public void itTestsWriteWithTestCaseUsingPlainTextFormat() {
		Runner runner = new Runner();
		MockTestCase testCase = new MockTestCase();
		ExecutionsCollection executions = runner.run(testCase);
		ConsoleWriter writer = new ConsoleWriter();
		Format format = new PlainTextFormat();
		writer.write(executions, format);
		String expected = format.applyFormat(executions);
		assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void itTestsWriteWithTestSuiteUsingPlainTextFormat() {
		Runner runner = new Runner();
		MockTestSuite testSuite = new MockTestSuite();
		ExecutionsCollection executions = runner.run(testSuite);
		ConsoleWriter writer = new ConsoleWriter();
		Format format = new PlainTextFormat();
		writer.write(executions, format);
		String expected = format.applyFormat(executions);
		assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void itTestsWriteWithTestCaseUsingXMLFormat() {
		Runner runner = new Runner();
		MockTestCase testCase = new MockTestCase();
		ExecutionsCollection executions = runner.run(testCase);
		ConsoleWriter writer = new ConsoleWriter();
		Format format = new XMLFormat();
		writer.write(executions, format);
		String expected = format.applyFormat(executions);
		assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void itTestsWriteWithTestSuiteUsingXMLFormat() {
		Runner runner = new Runner();
		MockTestSuite testSuite = new MockTestSuite();
		ExecutionsCollection executions = runner.run(testSuite);
		ConsoleWriter writer = new ConsoleWriter();
		Format format = new XMLFormat();
		writer.write(executions, format);
		String expected = format.applyFormat(executions);
		assertEquals(expected, outContent.toString());
	}

}
