package ca.uqam.mgl7361.a2011.gamma.writers;

import ca.uqam.mgl7361.a2011.gamma.executions.Executions;
import ca.uqam.mgl7361.a2011.gamma.formats.Format;

public class ConsoleWriter  implements Writer {

	public void write(Executions executions, Format format) {
		String executionStringRepresentation = format.applyFormat(executions);
		System.out.print(executionStringRepresentation);
	}

}
