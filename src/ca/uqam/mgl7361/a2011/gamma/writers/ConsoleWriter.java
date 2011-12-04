package ca.uqam.mgl7361.a2011.gamma.writers;

import ca.uqam.mgl7361.a2011.gamma.executions.ExecutionsCollection;
import ca.uqam.mgl7361.a2011.gamma.formats.Format;

public class ConsoleWriter  implements Writer {

	public void write(ExecutionsCollection executions, Format format) {
		String executionStringRepresentation = format.applyFormat(executions);
		System.out.print(executionStringRepresentation);
	}

}
