package ca.uqam.mgl7361.a2011.gamma.formats;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.uqam.mgl7361.a2011.gamma.Execution;
import ca.uqam.mgl7361.a2011.gamma.Runner;
import ca.uqam.mgl7361.a2011.gamma.mocking.MockTestCase;

public class PlainTextFormatTest {

	@Test
	public void itTestsApplyFormat() {
		Runner runner = new Runner();
		MockTestCase testCase = new MockTestCase();
		Execution execution = runner.run(testCase);
		Format format = new PlainTextFormat();
		String result = format.applyFormat(execution);
		assertTrue(!result.isEmpty());
	}

}
