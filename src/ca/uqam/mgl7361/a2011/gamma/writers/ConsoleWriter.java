package ca.uqam.mgl7361.a2011.gamma.writers;

import ca.uqam.mgl7361.a2011.gamma.Execution;
import ca.uqam.mgl7361.a2011.gamma.formats.Format;

public class ConsoleWriter  implements Writer {

	public void write(Execution execution, Format format) {
		String executionStringRepresentation = format.applyFormat(execution);
		System.out.print(executionStringRepresentation);
	}

}
