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
        <th>Quantity</th>
    </tr>
    <c:forEach
            items="${ordersKey}" var="order">
        <tr scope="row" class="text">
            <td><img src="../../../pub/images/${order.product.imageUrl}" style="border-radius: 0 50% 50% 50%; height: 100px; width: 100px;" alt=""></td>
            <td>${order.product.name}</td>
            <td>${order.product.price}</td>
            <td>${order.product.description}</td>
            <td>${order.quantity}</td>
            <td><a href="/cart/plus/${order.id}">One More?</a></td>
            <td><a href="/cart/subtract/${order.id}">One Less?</a></td>
        </tr>
    </c:forEach>
</table>


<jsp:include page="../include/footer.jsp" />
