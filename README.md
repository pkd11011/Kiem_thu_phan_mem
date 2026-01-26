# Tài liệu dự án kiểm thử

## Mục lục
1. [Giới thiệu chung](#giới-thiệu-chung)
2. [Chương 1 — Pixel Perfect với Can't Unsee](#chương-1--pixel-perfect-với-cant-unsee)
3. [Chương 2 — Kiểm thử đơn vị (JUnit)](#chương-2--kiểm-thử-đơn-vị-junit)
4. [Chương 3 — Kiểm thử E2E với Cypress](#chương-3--kiểm-thử-e2e-với-cypress)
5. [Thông tin người thực hiện](#thông-tin-người-thực-hiện)

## Giới thiệu chung
Bộ bài tập rèn luyện tư duy kiểm thử qua ba chương độc lập:
- Chương 1: Quan sát sai lệch giao diện (Pixel Perfect) qua thử thách Can't Unsee.
- Chương 2: Luyện JUnit với bài toán phân tích điểm số học sinh.
- Chương 3: Viết và chạy kịch bản E2E Cypress trên trang https://www.saucedemo.com.

## Chương 1 — Pixel Perfect với Can't Unsee
- Nền tảng: https://cantunsee.space.
- Kỹ năng rèn luyện: độ tương phản, kiểu chữ, căn lề và khoảng cách.
- Kết quả: đạt hạng Platinum (Top 5%).
- Minh chứng: ![Chứng chỉ Can't Unsee Platinum](cantunsee.jpg)

## Chương 2 — Kiểm thử đơn vị (JUnit)
### Mục tiêu
Xây dựng và kiểm thử lớp xử lý điểm số StudentAnalyzer với các quy tắc bỏ qua dữ liệu không hợp lệ.

### Mã nguồn
- Logic: [unit-test/src/StudentAnalyzer.java](unit-test/src/StudentAnalyzer.java)
- Kiểm thử JUnit 5: [unit-test/test/StudentAnalyzerTest.java](unit-test/test/StudentAnalyzerTest.java)

### Chức năng chính
- `countExcellentStudents(List<Double>)`: đếm điểm trong khoảng 8.0–10.0, bỏ qua null và giá trị ngoài miền hợp lệ.
- `calculateValidAverage(List<Double>)`: tính trung bình các điểm hợp lệ 0.0–10.0, trả về 0.0 nếu danh sách rỗng hoặc null.

### Kịch bản kiểm thử
- Dữ liệu hợp lệ ảnh hưởng đúng đến trung bình.
- Loại bỏ giá trị nhỏ hơn 0 hoặc lớn hơn 10 và phần tử null.
- Biên 0 và 10 được chấp nhận; 10.1 bị loại.
- Tập dữ liệu toàn giá trị không hợp lệ trả về 0.0.

### Bảng quyết định
| Trạng thái input | Trong 0–10 | Trong 8–10 | Ảnh hưởng trung bình (`calculateValidAverage`) | Đếm giỏi (`countExcellentStudents`) |
|------------------|------------|------------|-----------------------------------------------|--------------------------------------|
| null             | –          | –          | Bỏ qua                                        | Bỏ qua                               |
| < 0              | Không      | Không      | Bỏ qua                                        | Bỏ qua                               |
| > 10             | Không      | Không      | Bỏ qua                                        | Bỏ qua                               |
| 0 ≤ điểm < 8     | Có         | Không      | Tính vào trung bình                          | Bỏ qua                               |
| 8 ≤ điểm ≤ 10    | Có         | Có         | Tính vào trung bình                          | Tăng bộ đếm (giỏi)                   |

| Trạng thái danh sách           | Kết quả `calculateValidAverage` | Kết quả `countExcellentStudents` |
|--------------------------------|---------------------------------|-----------------------------------|
| `scores == null`               | 0.0                             | 0                                 |
| Rỗng                           | 0.0                             | 0                                 |
| Chỉ null/ngoài 0–10            | 0.0                             | 0                                 |
| Có ít nhất một điểm hợp lệ     | Trung bình điểm hợp lệ          | Số lượng điểm trong [8,10]        |

### Cách chạy
- Mở thư mục unit-test và chạy bộ kiểm thử JUnit 5 bằng IDE (IntelliJ/Eclipse) hoặc lệnh `mvn test`/`gradle test` nếu đã cấu hình công cụ build tương ứng.

## Chương 3 — Kiểm thử E2E với Cypress
### Cấu trúc thư mục
- Cấu hình: [cypress-exercise/cypress.config.js](cypress-exercise/cypress.config.js)
- Kịch bản: [cypress-exercise/cypress/e2e/login_spec.cy.js](cypress-exercise/cypress/e2e/login_spec.cy.js), [cypress-exercise/cypress/e2e/workflow.cy.js](cypress-exercise/cypress/e2e/workflow.cy.js)
- Dữ liệu mẫu và hỗ trợ: [cypress-exercise/cypress/fixtures/example.json](cypress-exercise/cypress/fixtures/example.json), [cypress-exercise/cypress/support/e2e.js](cypress-exercise/cypress/support/e2e.js), [cypress-exercise/cypress/support/commands.js](cypress-exercise/cypress/support/commands.js)

### Thiết lập môi trường
1. `cd cypress-exercise`
2. `npm install`

### Chạy kiểm thử
- Giao diện: `npx cypress open --e2e`
- Chế độ không giao diện: `npx cypress run --spec "cypress/e2e/**/*.cy.js"`

### Phạm vi kịch bản
- TC01: Đăng nhập với tài khoản chuẩn `standard_user/secret_sauce`, chuyển tới `/inventory.html`.
- TC02: Đăng nhập sai, hiển thị banner lỗi.
- TC03: Thêm sản phẩm đầu tiên, huy hiệu giỏ = 1; xóa sản phẩm, huy hiệu biến mất.
- TC04: Thêm hàng -> giỏ -> checkout, nhập First/Last/Zip, tới `/checkout-step-two.html`.

### Lưu ý cấu hình
- Thời gian chờ command/request/response: 10s; tải trang: 30s.
- Kích thước viewport: 1280x720; `numTestsKeptInMemory` đặt 0 để giảm lưu trữ log.

## Thông tin người thực hiện
- Họ và tên: Phạm Khắc Đô
- Mã sinh viên: BCS230024
- Email: phamdo1132@gmail.com

*Cập nhật lần cuối: 26/01/2026*
