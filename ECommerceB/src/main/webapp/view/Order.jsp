<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Order and Cart Page</title>
<link rel="stylesheet" href="view/css/order.css" type="text/css">
</head>
<body>
  <header>
    <h1>Order and Cart Page</h1>
    <nav class="user-actions">
      <form action="/user/userinf" method="get">
        <button type="submit" class="btn btn-info">Show User Orders & Cart</button>
      </form>
        <form action="/home" method="get">
        <button type="submit" class="btn btn-info">Home</button>
      </form>
      <form action="/account" method="get">
        <button type="submit" class="btn btn-info">Account</button>
      </form>
       <form action="/login/logout" method="post">
        <button type="submit" class="btn btn-logout">Logout</button>
      </form>
    </nav>
  </header>

  <main>
    <section class="cart-section">
      <h2>Cart</h2>
      <div class="cart-actions">
        <form action="user/cart" method="get">
          <button type="submit" class="btn">View Cart</button>
        </form>

        <form action="user/cart" method="post" class="inline-form">
          <label for="cart-product-id">Product ID:</label>
          <input type="text" id="cart-product-id" name="value" required />
          <button type="submit" class="btn">Add to Cart</button>
        </form>
      </div>
    </section>

    <section class="order-section">
      <h2>Order</h2>
      <div class="order-actions">
        <form action="user/order" method="get">
          <button type="submit" class="btn">View Orders</button>
        </form>

        <form action="user/status" method="get">
          <button type="submit" class="btn">Order Status</button>
        </form>

        <form action="user/order" method="post" class="inline-form">
          <label for="order-product-id">Product ID:</label>
          <input type="text" id="order-product-id" name="value" required />
          <button type="submit" class="btn">Buy</button>
        </form>

        <form action="user/orderall" method="get">
          <button type="submit" class="btn">Order with Order Status</button>
        </form>
      </div>
    </section>

    <hr />

    <section class="info-section">
      <p>
        To remove any cart item, send Product ID with DELETE method on <code>user/cart</code>.<br />
        To update an Order Status, send Product ID with PUT method on <code>user/status</code>.
      </p>
      <p><a href="/home/about" class="link-about">About Us</a></p>
    </section>
  </main>
</body>
</html>