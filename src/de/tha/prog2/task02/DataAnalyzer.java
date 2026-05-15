package de.tha.prog2.task02;

public class DataAnalyzer {
	
	public static void main(String[] args) {
		
	}
	
	public double min(double[] values) {
		double min = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] < min) {
				min = values[i];
			}
		}
		return min;
	}
	
	public double max(double[] values) {
		double max = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] > max) {
				max = values[i];
			}
		}
		return max;
	}
	
	public double sum(double[] values) {
		double sum = 0;
		for (int i = 0; i < values.length; i++) {
				sum += values[i];
		}
		return sum;
	}
	
	public double mean(double[] values) {
		double mean = sum(values) / values.length;
		return mean;
	}
	
	public double sampleVariance(double[] values) {
		double sampleVarianceCount = 0;
		for (int i = 0; i < values.length; i++) {
				sampleVarianceCount += (values[i] - mean(values)) * (values[i] - mean(values));
		}
		double sampleVarianceFinal = sampleVarianceCount / (values.length - 1);
		return sampleVarianceFinal;
	}
	
	public AnalysisResult analyze(double[] values) {
		double min = min(values);
		double max = max(values);
		double sum = sum(values);
		double mean = mean(values);
		double sampleVariance = sampleVariance(values);
		
		AnalysisResult ergebnis = new AnalysisResult(min, max, sum, mean, sampleVariance);
		
		return ergebnis;
	}

}
