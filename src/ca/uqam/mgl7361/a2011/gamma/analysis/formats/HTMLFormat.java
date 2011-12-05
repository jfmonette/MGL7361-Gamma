package ca.uqam.mgl7361.a2011.gamma.analysis.formats;

import java.util.Collection;
import ca.uqam.mgl7361.a2011.gamma.analysis.StatisticalAnalysis;

public class HTMLFormat implements Format {

	public String applyFormat(Collection<StatisticalAnalysis> analysises) {
		StringBuilder formattedAnalysises = new StringBuilder();
		formattedAnalysises.append("<html>\n");
		formattedAnalysises.append("<body>\n");
		for (StatisticalAnalysis analysis : analysises) {
			formattedAnalysises.append("<div>\n");
			formattedAnalysises.append("<h1>\n");
			formattedAnalysises.append(analysis.getName());
			formattedAnalysises.append("</h1>\n");
			formattedAnalysises.append("</div>\n");
			formattedAnalysises.append("<p>\n");
			formattedAnalysises.append("Minimum : ");
			formattedAnalysises.append(analysis.getMin());
			formattedAnalysises.append("</p>\n");
			formattedAnalysises.append("<p>\n");
			formattedAnalysises.append("Maximum : ");
			formattedAnalysises.append(analysis.getMax());
			formattedAnalysises.append("</p>\n");
			formattedAnalysises.append("<p>\n");
			formattedAnalysises.append("Mean : ");
			formattedAnalysises.append(analysis.getMean());
			formattedAnalysises.append("</p>\n");
			formattedAnalysises.append("<p>\n");
			formattedAnalysises.append("Standard deviation : ");
			formattedAnalysises.append(analysis.getStandardDeviation());
			formattedAnalysises.append("</p>\n");
			formattedAnalysises.append("<p>\n");
			formattedAnalysises.append("25th percentile : ");
			formattedAnalysises.append(analysis.getQuarterPercentile());
			formattedAnalysises.append("</p>\n");
			formattedAnalysises.append("<p>\n");
			formattedAnalysises.append("Median : ");
			formattedAnalysises.append(analysis.getMedian());
			formattedAnalysises.append("</p>\n");
			formattedAnalysises.append("<p>\n");
			formattedAnalysises.append("75th percentile : ");
			formattedAnalysises.append(analysis.getThreeQuarterPercentile());
			formattedAnalysises.append("</p>\n");
		}
		formattedAnalysises.append("</body>\n");
		formattedAnalysises.append("</html>");
			
		return formattedAnalysises.toString();
	}

	public String getFileExtention() {
		return "html";
	}

}
