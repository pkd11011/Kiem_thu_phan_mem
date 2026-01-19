import java.util.List;
import java.util.Objects;

public class StudentAnalyzer {

    public int countExcellentStudents(List<Double> scores) {
        if (scores == null) {
            return 0;
        }

        return (int) scores.stream()
                .filter(Objects::nonNull)  // Bảo vệ khỏi null elements
                .filter(score -> score >= 8.0 && score <= 10.0)
                .count();
    }

    public double calculateValidAverage(List<Double> scores) {
        if (scores == null) {
            return 0.0;
        }

        return scores.stream()
                .filter(Objects::nonNull)  // Bảo vệ khỏi null elements
                .filter(score -> score >= 0.0 && score <= 10.0)
                .mapToDouble(Double::doubleValue)
                .average()  // Tự động xử lý sum và count
                .orElse(0.0);  // Trả về 0.0 nếu không có phần tử hợp lệ
    }
}
