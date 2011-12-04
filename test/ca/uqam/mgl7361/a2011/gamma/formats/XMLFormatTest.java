package ca.uqam.mgl7361.a2011.gamma.formats;

import static org.junit.Assert.*;
import org.junit.Test;
import ca.uqam.mgl7361.a2011.gamma.Runner;
import ca.uqam.mgl7361.a2011.gamma.executions.Executions;
import ca.uqam.mgl7361.a2011.gamma.mocking.MockTestCase;

public class XMLFormatTest {

	@Test
	public void itTestsApplyFormat() {
		Runner runner = new Runner();
		MockTestCase testCase = new MockTestCase();
		Executions executions = runner.run(testCase);
		Format format = new XMLFormat();
		String result = format.applyFormat(executions);
		assertTrue(!result.isEmpty());
	}

}
