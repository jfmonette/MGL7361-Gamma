package ca.uqam.mgl7361.a2011.gamma.writers;

import ca.uqam.mgl7361.a2011.gamma.executions.ExecutionsCollection;
import ca.uqam.mgl7361.a2011.gamma.formats.Format;

public interface Writer {
	void write(ExecutionsCollection executions, Format format);
}
