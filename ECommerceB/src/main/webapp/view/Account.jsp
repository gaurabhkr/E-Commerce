<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Account Page</title>
<link rel="stylesheet" href="view/css/account.css" type="text/css" />
</head>
<body>
  <header>
    <h1>User Account Page</h1>
    <nav class="user-actions">
      <form action="/account/user" method="get">
        <button type="submit" class="btn btn-info">Account Information</button>
      </form>
      <form action="/home" method="get">
        <button type="submit" class="btn btn-info">Home</button>
      </form>
      <form action="/user" method="get">
        <button type="submit" class="btn btn-info">Order</button>
      </form>
       <form action="/login/logout" method="post">
        <button type="submit" class="btn btn-logout">Logout</button>
      </form>
    </nav>
  </header>

  <main>
    <section class="account-section">
      <h2>Update Account Details</h2>

      <div class="account-actions">
        <form action="/account/user/contact" method="post" class="inline-form">
          <label for="contact">Contact:</label>
          <input type="text" id="contact" name="value" type="number" required placeholder="Enter Contact" />
          <button type="submit" class="btn">Update</button>
        </form>

        <form action="/account/user/email" method="post" class="inline-form">
          <label for="email">Email:</label>
          <input type="email" id="email" name="value" type="email" required placeholder="Enter Email" />
          <button type="submit" class="btn">Update</button>
        </form>

        <form action="/account/user/name" method="post" class="inline-form">
          <label for="name">Name:</label>
          <input type="text" id="name" name="value" required placeholder="Enter Name" />
          <button type="submit" class="btn">Update</button>
        </form>

        <form action="/account/user/address" method="post" class="inline-form">
          <label for="address">Address:</label>
          <input type="text" id="address" name="value" required placeholder="Enter Address" />
          <button type="submit" class="btn">Update</button>
        </form>

        <form action="/account/user/username" method="post" class="inline-form">
          <label for="username">Username:</label>
          <input type="text" id="username" name="value" required placeholder="Enter Username" />
          <button type="submit" class="btn">Update</button>
        </form>

        <form action="/account/user/password" method="post" class="inline-form">
          <label for="password">Password:</label>
          <input type="password" id="password" name="value" required placeholder="Enter Password" />
          <button type="submit" class="btn">Update</button>
        </form>
      </div>
    </section>

    <hr />

    <section class="info-section">
      <p>For Delete and Put methods of controller are not performed.</p>
      <p><a href="/home/about" class="link-about">About Us</a></p>
    </section>
  </main>
</body>
</html>
