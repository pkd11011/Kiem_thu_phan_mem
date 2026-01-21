describe('Quy trình Mua hàng & Giỏ hàng', () => {
  
  beforeEach(() => {
    // Đăng nhập sẵn để làm các bước sau
    cy.visit('https://www.saucedemo.com');
    cy.wait(1000);
    cy.get('#user-name').type('standard_user');
    cy.get('#password').type('secret_sauce');
    cy.get('#login-button').click();
    cy.wait(2000); // Chờ load trang inventory
  });

  it('TC03: Thêm và Xóa sản phẩm khỏi giỏ hàng', () => {
    // Thêm sản phẩm đầu tiên
    cy.get('.inventory_item').first().find('button').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');

    // Xóa sản phẩm đó (Nút Add sẽ đổi thành Remove)
    cy.get('.inventory_item').first().find('button').contains('Remove').click();
    
    // Kiểm tra badge giỏ hàng biến mất
    cy.get('.shopping_cart_badge').should('not.exist');
  });

  it('TC04: Quy trình thanh toán (Checkout)', () => {
    // 1. Thêm hàng
    cy.get('.inventory_item').first().find('button').click();
    // 2. Vào giỏ hàng
    cy.get('.shopping_cart_link').click();
    // 3. Nhấn Checkout
    cy.get('#checkout').click();
    
    // 4. Điền thông tin (Yêu cầu bài tập)
    cy.get('#first-name').type('John');
    cy.get('#last-name').type('Doe');
    cy.get('#postal-code').type('12345');
    cy.get('#continue').click();

    // 5. Xác minh đến bước xác nhận (Step Two)
    cy.url().should('include', '/checkout-step-two.html');
    cy.get('.header_secondary_container').should('contain', 'Checkout: Overview');
  });
});