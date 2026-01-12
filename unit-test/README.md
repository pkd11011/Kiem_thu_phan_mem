# Bài Thực Hành Kiểm Thử Đơn Vị Với JUnit 5

Dự án này tập trung vào việc hướng dẫn triển khai kiểm thử đơn vị (Unit Test), cách xử lý logic nghiệp vụ và áp dụng quy trình làm việc chuẩn hóa trên GitHub.

![Badge: Java](https://img.shields.io/badge/Java-17-orange) ![Badge: JUnit](https://img.shields.io/badge/JUnit-5.9-green) ![Badge: Trạng thái](https://img.shields.io/badge/status-hoàn_thành-success)

## 📋 Mục Lục

- [1. Mục Tiêu Bài Học](#1-mục-tiêu-bài-học)
- [2. Mô Tả Bài Toán](#2-mô-tả-bài-toán)
- [3. Cấu Trúc Thư Mục](#3-cấu-trúc-thư-mục)
- [4. Bắt Đầu](#4-bắt-đầu)
  - [4.1. Yêu Cầu Hệ Thống](#41-yêu-cầu-hệ-thống)
  - [4.2. Cài Đặt Và Chạy](#42-cài-đặt-và-chạy)
- [5. Kết Quả Kiểm Thử](#5-kết-quả-kiểm-thử)
- [6. Kiểm Thử](#6-kiểm-thử)

## 1. Mục Tiêu Bài Học

* **Kiểm thử đơn vị**: Làm quen và sử dụng thành thạo JUnit 5.
* **Xử lý dữ liệu**: Áp dụng kỹ thuật kiểm tra và lọc dữ liệu đầu vào (Validation).
* **Quy trình làm việc**: Sử dụng GitHub Issues và quản lý mã nguồn bằng commit message chuẩn.

## 2. Mô Tả Bài Toán

Thực hiện xây dựng lớp `StudentAnalyzer` để phân tích danh sách điểm số của học sinh với các yêu cầu sau:

* **Phân loại**: Xác định số lượng học sinh đạt loại Giỏi (điểm số ≥ 8.0).
* **Tính toán**: Tính toán giá trị trung bình cộng từ danh sách điểm hợp lệ.
* **Ràng buộc dữ liệu**:
    * Điểm hợp lệ: Nằm trong khoảng [0, 10].
    * Điểm không hợp lệ: Các giá trị < 0 hoặc > 10 sẽ bị loại bỏ khỏi quá trình tính toán.

## 3. Cấu Trúc Thư Mục

```text
unit-test/
├── src/
│   └── StudentAnalyzer.java       # Chứa logic xử lý chính
├── test/
│   └── StudentAnalyzerTest.java   # Chứa các kịch bản kiểm thử
└── README.md                      # Tài liệu hướng dẫn dự án
