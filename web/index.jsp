<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Welcome</title>
  <link rel="stylesheet" href="<c:url value="/styles/styles.css"/>" type="text/css">
</head>
<body class="main">
<header>
  <div class="nav">
    <ul>
      <li class="home"><a class="active" href="#">Home</a></li>
      <li class="home"><a href="Controller?command=to_ships_page">Ships</a></li>
      <li class="tutorials"><a href="Controller?command=to_models_page">Models</a></li>
    </ul>
  </div>
</header>
<div style="text-align:center">
  <h1>Hello, skipper.</h1>
</div>
</body>
</html>
