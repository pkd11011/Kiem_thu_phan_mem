import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {

    private StudentAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new StudentAnalyzer();
    }
    private List<Double> parseScores(String scoreString) {
        List<Double> scoreList = new ArrayList<>();
        String[] scoreStrings = scoreString.split(";");
        for (String s : scoreStrings) {
            scoreList.add(Double.parseDouble(s.trim()));
        }
        return scoreList;
    }

    // ============ countExcellentStudents - Parameterized Tests ============
    @ParameterizedTest(name = "{index} - Scores: {0} => Expected: {1} excellent students")
    @CsvSource({
        "'9.0;8.5;7.0;11.0;-1.0', 2",      // Normal: 9.0 (✓), 8.5 (✓), 7.0 (✗), 11.0 (✗), -1.0 (✗)
        "'8.0;10.0;7.9', 2",                // Boundary: 8.0 (✓ exact), 10.0 (✓ exact), 7.9 (✗ just below)
        "'7.99;8.0;8.01;10.0;10.01', 3",   // Boundary precision: 8.0, 8.01, 10.0 are excellent
    })
    void testCountExcellentStudents_validData(String scores, int expected) {
        List<Double> scoreList = parseScores(scores);
        assertEquals(expected, analyzer.countExcellentStudents(scoreList));
    }

    @Test
    void testCountExcellentStudents_empty() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    void testCountExcellentStudents_null() {
        assertEquals(0, analyzer.countExcellentStudents(null));
    }

    @Test
    void testCountExcellentStudents_listWithNullElement() {
        // Edge case: List contains null element - should skip gracefully
        List<Double> scores = new ArrayList<>();
        scores.add(9.0);
        scores.add(null);  // Should be skipped, not cause crash
        scores.add(8.5);
        
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    // ============ calculateValidAverage - Parameterized Tests ============
    @ParameterizedTest(name = "{index} - Scores: {0} => Expected Average: {1}")
    @CsvSource({
        "'9.0;8.5;7.0;11.0;-1.0', 8.17",   // Normal: Valid (9.0, 8.5, 7.0) = 24.5/3 ≈ 8.17
        "'0.0;10.0', 5.00",                 // Boundary: Min (0.0), Max (10.0) => avg = 5.0
        "'-5.0;15.0', 0.00",                // Only invalid: Both out of range => avg = 0.0
        "'8.0;10.1;9.0', 8.50",            // Above boundary: 10.1 excluded => (8.0 + 9.0) / 2 = 8.5
    })
    void testCalculateValidAverage_validData(String scores, double expected) {
        List<Double> scoreList = parseScores(scores);
        assertEquals(expected, analyzer.calculateValidAverage(scoreList), 0.01);
    }

    @Test
    void testCalculateValidAverage_empty() {
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);
    }

    @Test
    void testCalculateValidAverage_null() {
        assertEquals(0.0, analyzer.calculateValidAverage(null), 0.01);
    }

    @Test
    void testCalculateValidAverage_listWithNullElement() {
        // Edge case: List contains null element - should skip gracefully
        List<Double> scores = new ArrayList<>();
        scores.add(8.0);
        scores.add(null);   // Should be skipped, not cause crash
        scores.add(9.0);
        scores.add(7.0);
        
        double expected = (8.0 + 9.0 + 7.0) / 3.0;  // 24.0 / 3 = 8.0
        assertEquals(expected, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    void testCalculateValidAverage_boundaryJustAbove() {
        // Special boundary test: 10.1 (just above valid range)
        double result = analyzer.calculateValidAverage(Arrays.asList(10.1, 8.0, 9.0));
        assertEquals(8.5, result, 0.01);  // Only 8.0 and 9.0 are valid
    }
}
