<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navBar.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../../pub/css/loginFinal.css">

<div class="content">
    <div class="form-area">
        <h1>User Login</h1>
        <form id="loginForm" action="/login/loginSubmit" method="POST">
            <div class="form-group">
                <div class="input-icon">
                    <i class="fa-solid fa-user-secret fa-beat"></i>
                </div>
                <label id="emailLabel" for="email">Email: </label>
                <input type="text" name="username" id="email" placeholder="email@domain.com"><br>
            </div>
            <div class="form-group">
                <div class="input-icon">
                    <i class="fa-solid fa-user-lock fa-beat"></i>
                </div>
                <label id="passwordLabel" for="password">Password: </label>
                <input type="text" name="password" id="password" placeholder="ex: Banana"><br>
            </div>
            <button type="submit" class="btn btn-login">Login</button>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp" />
