<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navBar.jsp" />
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet" href="../../pub/css/search.css">

<h1 style="color: white">Search</h1>

<form action="/searchUser" style="color: white" method="GET">
    Product Name : <input type="text" name="userName" value="${userName}">
    <button class="button" type="submit">Submit</button>
</form>

<br>

<c:if test="${not empty userName}">
    <h5 class="text">Search Results Found ${usersModelKey.size()}</h5>
    <c:if test="${usersModelKey.size() == 0}" >
        <h5>${error}</h5>
    </c:if>
    <br>
</c:if>


<table class="table">
    <tr scope="row" class="glow">
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <sec:authorize access="isAuthenticated()">
            <th>Password</th>
        </sec:authorize>
    </tr>
    <c:forEach items="${usersModelKey}" var="user">
        <tr scope="row" class="glow">
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <sec:authorize access="isAuthenticated()">
                <td>${user.password}</td>
            </sec:authorize>
            <sec:authorize access="hasAuthority('ADMIN')">
                <td>
                    <a href="/user/edit/${user.id}">
                        <button class="button" style="font-size: 20px">Edit</button>
                    </a>
                </td>
                <td>
                    <a href="/user/delete/${user.id}">
                        <button class="button" style="font-size: 20px">Delete</button>
                    </a>
                </td>
                <p style="color: white">${error}</p>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>


<jsp:include page="../include/footer.jsp" />