# Bài thực hành kiểm thử với JUnit

1. Mục tiêu

2. Mô tả bài toán
Xây dựng lớp `StudentAnalyzer` để phân tích điểm số học sinh:
- Đếm số học sinh đạt loại Giỏi (>= 8.0)
- Tính điểm trung bình của các điểm hợp lệ (từ 0 đến 10)
- Bỏ qua các giá trị không hợp lệ (<0 hoặc >10)

## 3. Cấu trúc thư mục
unit-test/
├── src/
│ └── StudentAnalyzer.java
├── test/
│ └── StudentAnalyzerTest.java
└── README.md

## 4. Cách chạy chương trình
- Mở project bằng IntelliJ IDEA hoặc Eclipse
- Đảm bảo đã cấu hình JDK 8 trở lên

## 5. Cách chạy kiểm thử đơn vị
### Cách 1: IntelliJ IDEA
1. Chuột phải file `StudentAnalyzerTest.java`
2. Chọn **Run 'StudentAnalyzerTest'**
3. Quan sát kết quả kiểm thử (PASS/FAIL)

### Cách 2: Eclipse
1. Chuột phải file test
2. Chọn **Run As → JUnit Test**

## 6. Công nghệ sử dụng
- Java
- JUnit 5
- Git & GitHub
