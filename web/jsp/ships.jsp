<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">
    <link type="text/css" rel="stylesheet" href="<c:url value="/styles/style.css"/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/styles/bootstrap.min.css"/>"/>

</head>
<body class="main">
<header>
    <div class="nav">
        <ul>
            <li class="home"><a href="Controller?command=to_main_page">Home</a></li>
            <li class="home"><a class="active" href="#">Ships</a></li>
            <li class="tutorials"><a href="Controller?command=to_models_page">Models</a></li>
        </ul>
    </div>
</header>
<div class="container content col-md-10 col-lg-10 col-md-offset-1 col-lg-offset-1 ">
    <div class="searchcontainer col-md-12 col-lg-12">
        <div class="description  col-md-12 col-lg-12 col-xs-12 col-sm-12">
            <div class="cast  col-md-12 col-lg-12 col-xs-12 col-sm-12">


                <table class="table tablecast">
                    <thead>
                    <tr>
                        <th>Number</th>
                        <th>Model</th>
                        <th>Seats</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>

                        <form method="post" action="Controller">

                            <td>
                                <input class="form-control" name="shipId" type="text" style="max-width: 150px"
                                       maxlength="10" required pattern="[A-Za-z0-9\-]{6,10}">
                            </td>

                            <td>
                                <div class="category">
                                    <select name="modelId" class="form-control" style="max-width: 150px">
                                        <c:forEach items="${requestScope.models}" var="model">
                                            <option value="${model.id}">${model.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </td>

                            <td></td>

                            <td></td>

                            <td>
                                <input type="hidden" name="command" value="add_ship">
                                <button type="submit" class="btn btnsearch saveBtn" style="min-width: 65px">add</button>
                            </td>
                        </form>

                    </tr>
                    <c:forEach items="${requestScope.ships}" var="ship">
                        <tr>
                            <td>${ship.id}</td>
                            <td>${ship.model.name}</td>
                            <td>${ship.model.cargoSeats}</td>
                            <td>
                                <form method="post" action="Controller">
                                    <input type="hidden" name="id" value="${ship.id}">
                                    <input type="hidden" name="command" value="to_update_ship_page">
                                    <button type="submit" class="btn btnsearch updateBtn">update</button>
                                </form>
                            </td>
                            <td>
                                <form method="post" action="Controller">
                                    <input type="hidden" name="id" value="${ship.id}">
                                    <input type="hidden" name="command" value="delete_ship">
                                    <button type="submit" class="btn btnsearch deleteBtn">delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<script type="text/javascript">
    function validate(elem){
        if(elem.value != '') {


        } else {
            alert("Enter plate number.");
            elem.focus();
            return false;
        }

        /*if(elem.value!='' && elem2.value!=''){
            if(elem.value.match(/\.(jpg|jpeg|png|gif)$/) && elem2.value.match(/\.(jpg|jpeg|png|gif)$/)) {
                return true;
            }else{
                alert("${file_format}");
                elem.focus();
                return false;
            }
        }else {
            alert("${choose_image}");
            elem.focus();
            return false;
        }*/
    }
</script>
