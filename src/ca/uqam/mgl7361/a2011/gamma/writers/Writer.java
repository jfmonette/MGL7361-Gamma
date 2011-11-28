package ca.uqam.mgl7361.a2011.gamma.writers;

import ca.uqam.mgl7361.a2011.gamma.Execution;
import ca.uqam.mgl7361.a2011.gamma.formats.Format;

public interface Writer {
	void write(Execution execution, Format format);
}
