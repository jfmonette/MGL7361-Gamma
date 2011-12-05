package ca.uqam.mgl7361.a2011.gamma.analysis.formats;

import java.util.Collection;
import ca.uqam.mgl7361.a2011.gamma.analysis.StatisticalAnalysis;

public class HTMLFormat implements Format {

	public String applyFormat(Collection<StatisticalAnalysis> analysises) {
		StringBuilder formattedAnalysises = new StringBuilder();
		formattedAnalysises.append("<html>\n");
		formattedAnalysises.append("<head>\n");
		formattedAnalysises.append("<link rel=\"stylesheet\" href=\"http://twitter.github.com/bootstrap/1.4.0/bootstrap.min.css\">");
		formattedAnalysises.append("</head>\n");
		formattedAnalysises.append("<body>\n");
		formattedAnalysises.append("<h1>Executions history analysis</h1>");
		for (StatisticalAnalysis analysis : analysises) {
			formattedAnalysises.append("<div style=\"width:400px;margin:20px\">\n");
		
			formattedAnalysises.append("<table class=\"bordered-table\">\n");
			formattedAnalysises.append("<tr>\n");
			formattedAnalysises.append("<th colspan=2>\n");
			formattedAnalysises.append(analysis.getName());
			formattedAnalysises.append("</th>\n");
			formattedAnalysises.append("<tr>\n")
			;
			formattedAnalysises.append("<tr>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append("<span class=\"label\">Minimum</span>");
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append(analysis.getMin());
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("</tr>\n");
			
			formattedAnalysises.append("<tr>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append("<span class=\"label\">Maximum</span>");
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append(analysis.getMax());
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("</tr>\n");
			
			formattedAnalysises.append("<tr>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append("<span class=\"label\">Mean</span>");
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append(analysis.getMean());
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("</tr>\n");
			
			formattedAnalysises.append("<tr>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append("<span class=\"label\">Standard deviation</span>");
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append(analysis.getStandardDeviation());
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("</tr>\n");
			
			formattedAnalysises.append("<tr>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append("<span class=\"label\">25th percentile</span>");
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append(analysis.getQuarterPercentile());
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("</tr>\n");
			
			formattedAnalysises.append("<tr>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append("<span class=\"label\">Median</span>");
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append(analysis.getMedian());
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("</tr>\n");
			
			formattedAnalysises.append("<tr>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append("<span class=\"label\">75th percentile</span>");
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("<td>\n");
			formattedAnalysises.append(analysis.getThreeQuarterPercentile());
			formattedAnalysises.append("</td>\n");
			formattedAnalysises.append("</tr>\n");
			
			formattedAnalysises.append("</div>\n");
		}
		formattedAnalysises.append("</body>\n");
		formattedAnalysises.append("</html>");
			
		return formattedAnalysises.toString();
	}

	public String getFileExtention() {
		return "html";
	}

}
