package ca.uqam.mgl7361.a2011.gamma.analysis.writers;

import java.util.Collection;
import ca.uqam.mgl7361.a2011.gamma.analysis.StatisticalAnalysis;
import ca.uqam.mgl7361.a2011.gamma.analysis.formats.Format;

public interface Writer {
	void write(Collection<StatisticalAnalysis> analysises, Format format);
}
