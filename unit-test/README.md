# Bài thực hành kiểm thử đơn vị với JUnit 5

Dự án này tập trung vào việc hướng dẫn triển khai kiểm thử đơn vị (Unit Test), cách xử lý logic nghiệp vụ và áp dụng quy trình làm việc chuẩn hóa trên GitHub.

## 1. Mục tiêu bài học

* **Kiểm thử đơn vị**: Làm quen và sử dụng thành thạo JUnit 5.
* **Xử lý dữ liệu**: Áp dụng kỹ thuật kiểm tra và lọc dữ liệu đầu vào (Validation).
* **Quy trình làm việc**: Sử dụng GitHub Issues và quản lý mã nguồn bằng commit message chuẩn.

## 2. Mô tả bài toán

Thực hiện xây dựng lớp `StudentAnalyzer` để phân tích danh sách điểm số của học sinh với các yêu cầu sau:

* **Phân loại**: Xác định số lượng học sinh đạt loại Giỏi (điểm số $\ge 8.0$).
* **Tính toán**: Tính toán giá trị trung bình cộng từ danh sách điểm hợp lệ.
* **Ràng buộc dữ liệu**:
    * Điểm hợp lệ: Nằm trong khoảng $[0, 10]$.
    * Điểm không hợp lệ: Các giá trị $< 0$ hoặc $> 10$ sẽ bị loại bỏ khỏi quá trình tính toán.

## 3. Cấu trúc thư mục

```text
unit-test/
├── src/
│   └── StudentAnalyzer.java       # Chứa logic xử lý chính
├── test/
│   └── StudentAnalyzerTest.java   # Chứa các kịch bản kiểm thử
└── README.md                      # Tài liệu hướng dẫn dự án

- ## 4. Kết quả kiểm thử



![Kết quả chạy kiểm thử JUnit](image/test.jpg)
