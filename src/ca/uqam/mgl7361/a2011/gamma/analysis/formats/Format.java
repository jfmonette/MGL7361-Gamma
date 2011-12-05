package ca.uqam.mgl7361.a2011.gamma.analysis.formats;

import ca.uqam.mgl7361.a2011.gamma.analysis.*;
import java.util.*;

public interface Format {
	String applyFormat(Collection<StatisticalAnalysis> analysises);
	String getFileExtention();
}
