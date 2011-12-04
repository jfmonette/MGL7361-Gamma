package ca.uqam.mgl7361.a2011.gamma.writers;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import ca.uqam.mgl7361.a2011.gamma.*;
import ca.uqam.mgl7361.a2011.gamma.executions.Executions;
import ca.uqam.mgl7361.a2011.gamma.formats.*;
import ca.uqam.mgl7361.a2011.gamma.mocking.*;

public class TextFileWriterTest {

	@Test
	public void itTestsWriteWithTestCaseUsingPlainTextFormat() {
		Runner runner = new Runner();
		MockTestCase testCase = new MockTestCase();
		Executions executions = runner.run(testCase);
		String fileName = "ExecutionsTest.txt";
		TextFileWriter writer = new TextFileWriter(fileName);
		Format format = new PlainTextFormat();
		writer.write(executions, format);
		File f = new File(fileName);
	    assertTrue(f.exists());
	    f.delete();
	}
	
	@Test
	public void itTestsWriteWithTestSuiteUsingPlainTextFormat() {
		Runner runner = new Runner();
		MockTestSuite testSuite = new MockTestSuite();
		Executions executions = runner.run(testSuite);
		String fileName = "ExecutionsTest.txt";
		TextFileWriter writer = new TextFileWriter(fileName);
		Format format = new PlainTextFormat();
		writer.write(executions, format);
		File f = new File(fileName);
	    assertTrue(f.exists());
	    f.delete();
	}
	
	@Test
	public void itTestsWriteWithTestCaseUsingXMLFormat() {
		Runner runner = new Runner();
		MockTestCase testCase = new MockTestCase();
		Executions executions = runner.run(testCase);
		String fileName = "ExecutionsTest.txt";
		TextFileWriter writer = new TextFileWriter(fileName);
		Format format = new XMLFormat();
		writer.write(executions, format);
		File f = new File(fileName);
	    assertTrue(f.exists());
	    f.delete();
	}
	
	@Test
	public void itTestsWriteWithTestSuiteUsingXMLFormat() {
		Runner runner = new Runner();
		MockTestSuite testSuite = new MockTestSuite();
		Executions executions = runner.run(testSuite);
		String fileName = "ExecutionsTest.txt";
		TextFileWriter writer = new TextFileWriter(fileName);
		Format format = new XMLFormat();
		writer.write(executions, format);
		File f = new File(fileName);
	    assertTrue(f.exists());
	    f.delete();
	}

}
