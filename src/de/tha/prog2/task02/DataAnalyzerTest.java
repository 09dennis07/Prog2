package de.tha.prog2.task02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataAnalyzerTest {

    private static final double DELTA = 1e-9;

    @Test
    void testMin() {
        DataAnalyzer analyzer = new DataAnalyzer();
        double[] values = {4.0, 2.0, 7.0, -1.0, 3.0};

        assertEquals(-1.0, analyzer.min(values), DELTA);
    }

    @Test
    void testMax() {
        DataAnalyzer analyzer = new DataAnalyzer();
        double[] values = {4.0, 2.0, 7.0, -1.0, 3.0};

        assertEquals(7.0, analyzer.max(values), DELTA);
    }

    @Test
    void testSum() {
        DataAnalyzer analyzer = new DataAnalyzer();
        double[] values = {1.0, 2.0, 3.0, 4.0};

        assertEquals(10.0, analyzer.sum(values), DELTA);
    }

    @Test
    void testMean() {
        DataAnalyzer analyzer = new DataAnalyzer();
        double[] values = {2.0, 4.0, 6.0, 8.0};

        assertEquals(5.0, analyzer.mean(values), DELTA);
    }

    @Test
    void testSampleVariance() {
        DataAnalyzer analyzer = new DataAnalyzer();
        double[] values = {1.0, 2.0, 3.0, 4.0};

        assertEquals(1.6666666666666667, analyzer.sampleVariance(values), DELTA);
    }

    @Test
    void testAnalyze() {
        DataAnalyzer analyzer = new DataAnalyzer();
        double[] values = {1.0, 2.0, 3.0, 4.0};

        AnalysisResult result = analyzer.analyze(values);

        assertEquals(1.0, result.getMin(), DELTA);
        assertEquals(4.0, result.getMax(), DELTA);
        assertEquals(10.0, result.getSum(), DELTA);
        assertEquals(2.5, result.getMean(), DELTA);
        assertEquals(1.6666666666666667, result.getSampleVariance(), DELTA);
    }
}