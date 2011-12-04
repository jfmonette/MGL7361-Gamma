package ca.uqam.mgl7361.a2011.gamma.analysers;

public class StatisticalAnalysis {
	private String name;
	private double min;
	private double max;
	private double mean;
	private double standardDeviation;
	private double quarterPercentile;
	private double median;
	private double threeQuarterPercentile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	public double getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	public double getQuarterPercentile() {
		return quarterPercentile;
	}
	public void setQuarterPercentile(double quarterPercentile) {
		this.quarterPercentile = quarterPercentile;
	}
	public double getMedian() {
		return median;
	}
	public void setMedian(double median) {
		this.median = median;
	}
	public double getThreeQuarterPercentile() {
		return threeQuarterPercentile;
	}
	public void setThreeQuarterPercentile(double threeQuarterPercentile) {
		this.threeQuarterPercentile = threeQuarterPercentile;
	}

}
