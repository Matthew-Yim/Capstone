<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navBar.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="../../../pub/css/icySnows.css">


<table class="table">
    <tr class="glow">
        <th>Image</th>
        <th>Name</th>
        <th>Price</th>
        <th>Category</th>
        <th>Description</th>
    </tr>
    <c:forEach
            items="${tranquilTeas}" var="product">
        <tr scope="row" class="glow">
            <td><img style="border-radius: 0 50% 50% 50%; height: 100px; width: 100px;" src="../../../pub/images/${product.imageUrl}"  alt=""></td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.category}</td>
            <td>${product.description}</td>
            <sec:authorize access="isAuthenticated()">
                <td>
                    <a href="/AddCart/${product.id}">
                        <button class="button" style="font-size: 20px">Add to Cart</button>
                    </a>
                </td>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../include/footer.jsp" />
