<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navBar.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../../pub/css/cart.css">

<table class="table">
    <tr class="text">
        <th>Image</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
    </tr>
    <c:forEach
            items="${ordersKey}" var="order">
        <tr scope="row" class="text">
            <td><img src="../../../pub/images/${order.productId.imageUrl}" style="height: 100px; width: 100px;" alt=""></td>
            <td>${order.productId.name}</td>
            <td>${order.productId.price}</td>
            <td>${order.quantity}</td>
            <td><a href="/product/edit/${product.id}">Edit</a></td>
            <td><a href="/product/delete/${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>


<jsp:include page="../include/footer.jsp" />
