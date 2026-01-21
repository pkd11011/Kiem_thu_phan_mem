# Software Testing

## Mục lục
1. [Mục tiêu](#mục-tiêu)
2. [Tổng quan dự án](#tổng-quan-dự-án)
3. [Báo cáo kết quả](#báo-cáo-kết-quả-test-report)
4. [Tư duy Kiểm thử](#tư-duy-kiểm-thử-testing-mindset)
5. [Kiểm thử E2E với Cypress](#kiểm-thử-e2e-với-cypress)
6. [Thông tin người thực hiện](#thông-tin-người-thực-hiện)

## Mục tiêu
* Rèn luyện khả năng quan sát sai lệch giao diện (Pixel Perfect) qua thử thách Can't Unsee.
* Xây dựng và chạy bộ kiểm thử E2E bằng Cypress cho luồng mua hàng trên SauceDemo.

## Tổng quan dự án
Nằm trong khuôn khổ **Chapter 1: Testing Principles**, thử thách này đóng vai trò là bài kiểm tra đầu vào về khả năng quan sát chi tiết (**Pixel Perfect**) của một kiểm thử viên. Mục tiêu cốt lõi là rèn luyện tư duy nhạy bén trong việc phát hiện các lỗi sai lệch giao diện (UI Defect) so với bản thiết kế chuẩn (Design System).

* **Nền tảng thực hiện:** [Can't Unsee](https://cantunsee.space)
* **Kỹ năng rèn luyện:** * **Contrast:** Phân tích độ tương phản màu sắc.
    * **Typography:** Nhận diện sự khác biệt về font-weight, size và spacing.
    * **Alignment & Padding:** Kiểm tra tính chính xác của khoảng cách và căn lề.

---

## Báo cáo kết quả (Test Report)

Tôi đã hoàn thành thử thách với kết quả thuộc nhóm xuất sắc, khẳng định năng lực quan sát ở mức độ chuyên sâu:

* **Xếp hạng:** <kbd>Platinum</kbd> (Top 5% người chơi toàn cầu).
* **Đặc điểm nhận diện:** * Khả năng phát hiện sai lệch cực nhỏ (chênh lệch 1-2px).
    * Tốc độ phản xạ và đưa ra quyết định dựa trên quy chuẩn UI/UX.
    * Tập trung cao độ trong các kịch bản so sánh phức tạp.

> [!TIP]
> **Minh chứng kết quả:**
> ![Kết quả Cant Unsee](cantunsee.jpg)
> *Hình 1: Chứng chỉ hoàn thành cấp độ Platinum - Visual Perception.*

---

## Tư duy Kiểm thử (Testing Mindset)

Thông qua thử thách này, tôi đã đúc kết và áp dụng các tiêu chuẩn "vàng" vào quy trình kiểm thử giao diện thực tế:

1.  **Tính nhất quán (Consistency):** Đảm bảo các thành phần (Icons, Buttons, Radius) đồng nhất trên toàn bộ hệ thống.
2.  **Độ chính xác về khoảng cách (Space & Grid):** Áp dụng quy tắc 4px/8px để kiểm tra Padding và Margin, tránh tình trạng "lệch mắt" gây khó chịu cho người dùng.
3.  **Khả năng truy cập (Accessibility):** Luôn đặt câu hỏi về độ tương phản của Text so với Background để đảm bảo tính dễ đọc theo chuẩn WCAG.

---

## Kiểm thử E2E với Cypress

* **Mục tiêu:** Tự động hóa các kịch bản mua hàng trên https://www.saucedemo.com để kiểm thử luồng chính (happy path) và lỗi đăng nhập.
* **Môi trường:** Node.js 18+, Cypress 15.9.0 (cấu hình tại thư mục `cypress-exercise`).

### Cài đặt & chạy nhanh
1. `cd cypress-exercise`
2. `npm install`
3. Chạy giao diện: `npx cypress open --e2e`
4. Chạy headless: `npx cypress run --spec "cypress/e2e/**/*.cy.js"`

### Phạm vi kịch bản
* **TC01:** Đăng nhập chuẩn (`standard_user/secret_sauce`) và được điều hướng tới `/inventory.html`.
* **TC02:** Đăng nhập sai thông tin, hiển thị banner lỗi đỏ với nội dung cảnh báo.
* **TC03:** Thêm sản phẩm đầu tiên vào giỏ, kiểm tra badge = 1, sau đó xóa và badge biến mất.
* **TC04:** Thêm sản phẩm → giỏ hàng → checkout; điền thông tin (First/Last/Zip) và tới bước `checkout-step-two.html`.

> Lưu ý: `cypress.config.js` đã tăng timeout (command/request/response = 10s, page load = 30s) và thiết lập viewport 1280x720 để ổn định khi chạy CI.

---

## Thông tin người thực hiện
* **Họ và tên:** Phạm Khắc Đô
* **Mã sinh viên:** BCS230024
* **Email:** phamdo1132@gmail.com

---
*Last updated: January 21, 2026*
