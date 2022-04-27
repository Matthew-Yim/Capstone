<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navBar.jsp" />
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet" href="../../pub/css/search.css">

<h1 style="color: white">Search</h1>

<form action="/searchProduct" style="color: white" method="GET">
    Product Name : <input type="text" name="productName" value="${productName}">
    <button class="button" type="submit">Submit</button>
</form>

<br>

<c:if test="${not empty productName}">
    <h5 class="text">Search Results Found ${productsModelKey.size()}</h5>
    <c:if test="${productsModelKey.size() == 0}" >
        <h5>${error}</h5>
    </c:if>
    <br>
</c:if>


<table class="table">
    <tr scope="row" class="glow">
        <th>Image</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Category</th>
    </tr>
    <c:forEach items="${productsModelKey}" var="product">
        <tr scope="row" class="glow">
            <td><img style="border-radius: 0 50% 50% 50%; height: 100px; width: 100px;" src="../../../pub/images/${product.imageUrl}"  alt=""></td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.category}</td>
            <sec:authorize access="!isAuthenticated()">
                <td>
                    <a href="/AddCart/${product.id}">
                        <button class="button" style="font-size: 20px">Add to Cart</button>
                    </a>
                </td>
            </sec:authorize>
            <sec:authorize access="hasAuthority('ADMIN')">
                <td>
                    <a href="/product/edit/${product.id}">
                        <button class="button" style="font-size: 20px">Edit</button>
                    </a>
                </td>
                <td>
                    <a href="/product/delete/${product.id}">
                        <button class="button" style="font-size: 20px">Delete</button>
                    </a>
                </td>
                <p style="color: white">${error}</p>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>


<jsp:include page="../include/footer.jsp" />