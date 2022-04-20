<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navBar.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../../pub/css/registerFinal.css">

<div class="content">
    <div class="form-area">
        <c:if test="${empty formBean.id}">
            <h1>Sign Up5</h1>
        </c:if>

        <c:if test="${not empty formBean.id}">
            <h1>Edit User</h1>
        </c:if>
        <form id="registrationForm" action="/user/registerSubmit"   method="post">
            <div class="form-group">
                <div class="input-icon">
                    <i class="fa-solid fa-signature fa-bounce"></i>
                </div>
                <label id="firstNameLabel" for="firstName">First Name: </label>
                <input type="text" name="email" id="firstName" placeholder="Donkey"><br>
                <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>
            <div class="form-group">
                <div class="input-icon">
                    <i class="fa-solid fa-signature fa-bounce"></i>
                </div>
                <label id="lastNameLabel" for="lastName">Last Name: </label>
                <input type="text" name="email" id="lastName" placeholder="Kong"><br>
                <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>
            <div class="form-group">
                <div class="input-icon">
                    <i class="fa-solid fa-envelope fa-bounce"></i>
                </div>
                <label id="emailLabel" for="email">Email: </label>
                <input type="text" name="email" id="email" placeholder="email@domain.com"><br>
                <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>
            <div class="form-group">
                <div class="input-icon">
                    <i class="fa-solid fa-key fa-bounce"></i>
                </div>
                <label id="passwordLabel" for="password">Password: </label>
                <input type="text" name="password" id="password" placeholder="ex: Banana"><br>
                <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>
            <div class="form-group">
                <div class="input-icon">
                    <i class="fa-solid fa-lock fa-bounce"></i>
                </div>
                <label id="confirmPasswordLabel" for="confirmPassword">Confirm Password: </label>
                <input type="text" name="confirmPassword" id="confirmPassword" placeholder="ex: Banana"><br>
                <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>
            <button type="submit" class="btn btn-login">Login</button>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp" />
