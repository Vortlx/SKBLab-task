<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url value="/register" var="register"/>

<c:import url="header.jsp"/>
<div class="col-sm-8 col-md-8 offset-2">
    <div class="card">
        <h4 class="card-header">Форма регистрации</h4>
        <div class="card-body">
            <form:form method="post" action="${register}" modelAttribute="user">
                <div class="form-group">
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <label for="login" class="input-group-text">Логин</label>
                        </div>
                        <form:input path="login" cssClass="form-control"/>
                    </div>
                    <form:errors path="login" cssClass="error"/>
                </div>

                <div class="form-group">
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <label for="password" class="input-group-text">Пароль</label>
                        </div>
                        <form:password path="password" cssClass="form-control"/>
                    </div>
                    <form:errors path="password" cssClass="error"/>
                </div>

                <div class="form-group">
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <label for="confirmPassword" class="input-group-text">Пароль еще раз</label>
                        </div>
                        <form:password path="confirmPassword" cssClass="form-control"/>
                    </div>
                    <form:errors path="" cssClass="error"/>
                </div>

                <div class="form-group">
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <label for="email" class="input-group-text">Email</label>
                        </div>
                        <form:input path="email" cssClass="form-control"/>
                    </div>
                    <form:errors path="email" cssClass="error"/>
                </div>

                <div class="form-group">
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <label for="fio" class="input-group-text">ФИО</label>
                        </div>
                        <form:input path="fio" cssClass="form-control"/>
                    </div>
                    <form:errors path="fio" cssClass="error"/>
                </div>
                <input type="submit" class="btn btn-info" value="Отправить"/>
            </form:form>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>