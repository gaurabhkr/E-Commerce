<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Homepage</title>
<link rel="stylesheet" href="view/css/homepage.css" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<%
    String username = (String) session.getAttribute("username");
    UUID userid = (UUID) session.getAttribute("userid");
%>

<!-- Font Awesome CDN -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-..." crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" />

<header>
  <nav class="navbar">
    <ul class="nav-list">
     <li>
<!-- Cart -->
<li>
  <a href="/user/cart" class="cart-link">
    <i class="fa-solid fa-trailer "></i>
    Cart
  </a>
</li>
      
  <!-- My Orders -->
<li>
  <a href="/user" class="orders-link">
    <i class="fa-solid fa-truck"></i>
    My Orders
  </a>
</li>
      <!-- My Account -->
<li>
  <a href="/account" class="account-link">
    <i class="fa-solid fa-user"></i>
    Account
  </a>
</li>
      <li>
        <form action="/login/logout" method="post" class="logout-form">
          <button type="submit" class="btn-logout">Logout</button>
        </form>
      </li>
    </ul>
  </nav>
</header>
<main class="container">

  <section class="user-info">
    <h2>Welcome, <span class="username"><%= username != null ? username : "Guest" %></span></h2>
    <p>User ID: <%= userid != null ? userid.toString() : "N/A" %></p>
  </section>

  <section class="products-section">
    <h3>Products</h3>
    <div class="products-list">
      ${items} <!-- Ensure this is rendered as HTML or iterate with JSTL -->
    </div>
  </section>

  <section class="search-section">
    <h3>Search Products</h3>

    <form action="/home/search" method="get" class="search-form">
      <input type="search"  class="input" name="value" placeholder="Search products..." required>
      <button type="submit">Search</button>
    </form>

    <form action="/home/category" method="get" class="search-form">
      <input type="search"  class="input" name="value" placeholder="Search by category..." required>
      <button type="submit">Search Category</button>
    </form>

    <form action="/home/item" method="get" class="search-form">
      <input type="text"  class="input" name="value" placeholder="Product ID" required>
      <button type="submit">Go to Product</button>
    </form>

    <form action="/home/itemdate" method="get" class="search-form">
      <input type="text"  class="input" name="value" placeholder="Product ID" required>
      <button type="submit">Search by Delivery Date</button>
    </form>
  </section>

</main>

<footer>
  <p><a href="/home/about">About Us</a></p>
</footer>

</body>
</html>

