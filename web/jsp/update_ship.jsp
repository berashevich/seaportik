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
      <li class="tutorials"><a href="#">Models</a></li>
    </ul>
  </div>
</header>

<form method="post" action="Controller">
<div align="center">
<div style="max-width: 200px">

<div class="descline">
  <h4>Choose model</h4>
  <div class="category">
    <select name="modelId" class="form-control">
      <c:forEach items="${requestScope.models}" var="model">
        <option <c:if test="${requestScope.ship.model.equals(model)}">selected</c:if> value="${model.id}">${model.name}</option>
      </c:forEach>
    </select>
  </div>
</div>

<div align="right" style="margin-top: 15px">
    <input type="hidden" name="shipId" value="${requestScope.shipId}">
    <input type="hidden" name="command" value="update_ship">
    <button type="submit" class="btn btnsearch saveBtn">save</button>
</div>
</div>
</div>
</form>

</body>
</html>
