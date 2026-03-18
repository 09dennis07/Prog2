package de.tha.prog2.task02;

public class AnalysisResult {
	
	public static void main(String[] args) {
		
	}
	
	private double min;
	private double max;
	private double sum;
	private double mean;
	private double sampleVariance;
	
	public AnalysisResult(double min, double max, double sum, double mean, double sampleVariance) {
		this.min = min;
		this.max = max;
		this.sum = sum;
		this.mean = mean;
		this.sampleVariance = sampleVariance;
	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}

	public double getSum() {
		return sum;
	}

	public double getMean() {
		return mean;
	}

	public double getSampleVariance() {
		return sampleVariance;
	}
	
	public String toString() {
		return String.format(java.util.Locale.US,"AnalysisResult{min=%.1f, max=%.1f, sum=%.1f, mean=%.1f, sampleVariance=%.1f}",
				min, max, sum, mean, sampleVariance);
	}

}
