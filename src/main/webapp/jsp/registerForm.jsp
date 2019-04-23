<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23.04.2019
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Form</title>
    <link rel="shortcut icon" href="<c:url value="/img/favico.ico"/>" type="image/x-icon">

    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet" />
    <link href="<c:url value="/css/registerForm.css"/>" rel="stylesheet" />


    <script type="text/javascript" src="<c:url value="/js/jQuery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
</head>
<body>
    <nav class="custom-navbar navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand logo" href="#">
            <img src="<c:url value="/img/SKBLab_LOGO.png"/>" alt="SKBLab" width="200">
        </a>
    </nav>

    <div class="col-md-8 offset-2">
        <div class="card">
            <h4 class="card-header">Форма регистрации</h4>
            <div class="card-body">
                <form:form method="post" modelAttribute="user">
                    <div class="form-group">
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <label for="login" class="input-group-text">Логин</label>
                            </div>
                            <form:input path="login" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <label for="password" class="input-group-text">Пароль</label>
                            </div>
                            <form:password path="password" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <label for="email" class="input-group-text">Email</label>
                            </div>
                            <form:input path="email" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <label for="fio" class="input-group-text">ФИО</label>
                            </div>
                            <form:input path="fio" cssClass="form-control"/>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
