package de.tha.prog2.task02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnalysisResultTest {

    @Test
    void testGetter() {
        AnalysisResult result = new AnalysisResult(1.0, 10.0, 30.0, 6.0, 8.0);

        assertEquals(1.0, result.getMin());
        assertEquals(10.0, result.getMax());
        assertEquals(30.0, result.getSum());
        assertEquals(6.0, result.getMean());
        assertEquals(8.0, result.getSampleVariance());
    }

    @Test
    void testToString() {
        AnalysisResult result = new AnalysisResult(1.0, 10.0, 30.0, 6.0, 8.0);

        String expected = "AnalysisResult{min=1.0, max=10.0, sum=30.0, mean=6.0, sampleVariance=8.0}";

        assertEquals(expected, result.toString());
    }

    @Test
    void testToStringOneDecimal() {
        AnalysisResult result = new AnalysisResult(1.23, 9.87, 20.55, 5.14, 3.76);

        String expected = "AnalysisResult{min=1.2, max=9.9, sum=20.6, mean=5.1, sampleVariance=3.8}";

        assertEquals(expected, result.toString());
    }
}