<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="view/css/login.css" type="text/css">
</head>
<body>
<div class="container"></div>

<div class="wrapper">
  <div class="card-switch">
    <label class="switch">
      <input type="checkbox" class="toggle" />
      <span class="slider"></span>
      <span class="card-side"></span>
      <div class="flip-card__inner">
        <div class="flip-card__front">
        
          <div class="title">Log in</div>
          
          <form class="flip-card__form" action="/login/logincheck" method="post">
            <input class="flip-card__input" name="username" placeholder="Username" type="text" />
            <input class="flip-card__input" name="password" placeholder="Password" type="password" />
            <button class="flip-card__btn" type="submit">Login</button>
          </form>
          
        </div>
        
        
        
        <div class="flip-card__back">
        
          <div class="title">Sign up</div>
          <form class="flip-card__form" action="/login/registeruser" method="post">
            <input class="flip-card__input" name="usernamee" placeholder="Username" type="text" />
            <input class="flip-card__input" name="passworde" placeholder="Password" type="password" />
            <button class="flip-card__btn" type="submit">Register !</button>
          </form>
          
        </div>
      </div>
    </label>
  </div>
</div>

 
</body>
</html>
