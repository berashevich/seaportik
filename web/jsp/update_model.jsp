<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Welcome</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.3.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-multiselect.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">
  <link type="text/css"  rel="stylesheet" href="<c:url value="/styles/style.css"/>"/>
  <link type="text/css"  rel="stylesheet"  href="<c:url value="/styles/bootstrap.min.css"/>" />
  <link rel="stylesheet" href="<c:url value="/styles/bootstrap-multiselect.css"/>" type="text/css">

</head>
<body class="main">
<header>
  <div class="nav">
    <ul>
      <li class="home"><a href="Controller?command=to_main_page">Home</a></li>
      <li class="home"><a href="Controller?command=to_ships_page">Ships</a></li>
      <li class="home"><a href="Controller?command=to_models_page">Models</a></li>
    </ul>
  </div>
</header>

<form method="post" action="Controller">
<div align="center">
<div style="max-width: 200px">
<div class=" filmname descline">
  <h4>Model name</h4>
  <input class="form-control" name="model" type="text" value="${requestScope.model.name}"
         maxlength="30" required pattern="[A-Za-z0-9\-]{4,30}">
</div>

<div class="descline">
  <h4>Cargo seats</h4>
  <input class="form-control" name="seats" type="text" value="${requestScope.model.cargoSeats}"
         maxlength="6" required pattern="[0-9]{1,6}">
</div>

<div align="right" style="margin-top: 15px">
    <input type="hidden" name="modelId" value="${requestScope.model.id}">
    <input type="hidden" name="command" value="update_model">
    <button type="submit" class="btn btnsearch saveBtn">save</button>
</div>
</div>
</div>
</form>

</body>
</html>
