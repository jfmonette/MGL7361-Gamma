package ca.uqam.mgl7361.a2011.gamma.analysis;

import java.util.*;

import ca.uqam.mgl7361.a2011.gamma.executions.*;

public class ExecutionsAnalyser {
	private StatisticsProvider stats = new StatisticsProvider();
	
	public Collection<StatisticalAnalysis> analyse(ExecutionsHistory history) {
		Collection<StatisticalAnalysis> analysises = new ArrayList<StatisticalAnalysis>();
		analysises.add(getExecutionTimeAnalysis(history));
		analysises.add(getNumberOfExecutionsByDayAnalysis(history));
		analysises.add(getTurnAroundTimeAnalysis(history));
		return analysises;
	}

	private StatisticalAnalysis getExecutionTimeAnalysis(ExecutionsHistory history) {
		StatisticalAnalysis analysis = new StatisticalAnalysis();
		stats.addAll(history.getExecutionTimes());
		analysis.setName("Execution Time Analysis");
		analysis.setMax(stats.getMax());
		analysis.setMean(stats.getMean());
		analysis.setMedian(stats.getMedian());
		analysis.setMin(stats.getMin());
		analysis.setQuarterPercentile(stats.getPercentile(25));
		analysis.setStandardDeviation(stats.getStandardDeviation());
		analysis.setThreeQuarterPercentile(stats.getPercentile(75));
		return analysis;
	}
	
	private StatisticalAnalysis getNumberOfExecutionsByDayAnalysis(ExecutionsHistory history) {
		StatisticalAnalysis analysis = new StatisticalAnalysis();
		stats.addAll(history.getNumberOfExecutionsByDay());
		analysis.setName("Number of Executions by Day Analysis");
		analysis.setMax(stats.getMax());
		analysis.setMean(stats.getMean());
		analysis.setMedian(stats.getMedian());
		analysis.setMin(stats.getMin());
		analysis.setQuarterPercentile(stats.getPercentile(25));
		analysis.setStandardDeviation(stats.getStandardDeviation());
		analysis.setThreeQuarterPercentile(stats.getPercentile(75));
		return analysis;
	}
	
	private StatisticalAnalysis getTurnAroundTimeAnalysis(ExecutionsHistory history) {
		StatisticalAnalysis analysis = new StatisticalAnalysis();
		stats.addAll(history.getTurnAroundTimes());
		analysis.setName("Turn-around time Analysis");
		analysis.setMax(stats.getMax());
		analysis.setMean(stats.getMean());
		analysis.setMedian(stats.getMedian());
		analysis.setMin(stats.getMin());
		analysis.setQuarterPercentile(stats.getPercentile(25));
		analysis.setStandardDeviation(stats.getStandardDeviation());
		analysis.setThreeQuarterPercentile(stats.getPercentile(75));
		return analysis;
	}
}
