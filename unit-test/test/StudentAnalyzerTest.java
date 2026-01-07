import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

public class StudentAnalyzerTest {

    @Test
    void testCountExcellentStudents_normal() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(2,
            analyzer.countExcellentStudents(
                Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
            )
        );
    }

    @Test
    void testCountExcellentStudents_empty() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0,
            analyzer.countExcellentStudents(Collections.emptyList())
        );
    }

    @Test
    void testCalculateValidAverage_normal() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(8.17,
            analyzer.calculateValidAverage(
                Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
            ),
            0.01
        );
    }

    @Test
    void testCalculateValidAverage_onlyInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0,
            analyzer.calculateValidAverage(Arrays.asList(-5.0, 15.0))
        );
    }
}
