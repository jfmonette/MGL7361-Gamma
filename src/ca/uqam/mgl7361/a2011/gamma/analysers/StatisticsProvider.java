package ca.uqam.mgl7361.a2011.gamma.analysers;

import java.util.*;
import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

public class StatisticsProvider {
	private DescriptiveStatistics stats = new DescriptiveStatistics();
	
	public void add(Double value) {
		stats.addValue(value);
	}
	
	public void addAll(Collection<Double> values) {
		for (double value : values) {
			stats.addValue(value);
		}
	}
	
	public double getMin() {
		return stats.getMin();
	}
	
	public double getMax() {
		return stats.getMax();
	}
	
	public double getStandardDeviation() {
		return stats.getStandardDeviation();
	}
	
	public double getMean() {
		return stats.getMean();
	}
	
	public double getPercentile(double p) {
		return stats.getPercentile(p);
	}
	
	public double getMedian() {
		return stats.getPercentile(50);
	}
}
