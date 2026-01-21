describe('Chức năng Đăng nhập', () => {
  
  beforeEach(() => {
    // Trước mỗi case, truy cập trang chủ
    cy.visit('https://www.saucedemo.com');
    cy.wait(2000); // Chờ trang load
  });

  it('TC01: Đăng nhập thành công với user chuẩn', () => {
    cy.get('#user-name').type('standard_user');
    cy.get('#password').type('secret_sauce');
    cy.get('#login-button').click();
    
    // Assertion: URL phải chuyển sang trang inventory
    cy.url().should('include', '/inventory.html');
  });

  it('TC02: Đăng nhập thất bại với thông tin sai', () => {
    cy.get('#user-name').type('wrong_user');
    cy.get('#password').type('wrong_pass');
    cy.get('#login-button').click();
    
    // Assertion: Hiển thị thông báo lỗi màu đỏ
    cy.get('[data-test="error"]').should('be.visible')
      .and('contain', 'Username and password do not match');
  });
});