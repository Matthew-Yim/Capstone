<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navBar.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../../pub/css/cart.css">

<%--<form name="ShoppingList">--%>
<%--    <fieldset>--%>
<%--        <legend>Shopping cart</legend>--%>
<%--        <img src="../../../pub/images/" style="height: 100px; width: 100px;" alt="">--%>
<%--&lt;%&ndash;       after /images/ put this -> ${}&ndash;%&gt;--%>
<%--        <label>Item: <input type="text" name="name"></label>--%>
<%--        <label>Price: <input type="text" name="data"></label>--%>
<%--        <label>Quantity: <input type="text" name="data"></label>--%>

<%--        <input type="button" value="Save"   onclick="">--%>
<%--        <input type="button" value="Update" onclick="">--%>
<%--        <input type="button" value="Delete" onclick="">--%>
<%--    </fieldset>--%>
<%--    <div id="items_table">--%>
<%--        <h2>Shopping List</h2>--%>
<%--        <table id="list"></table>--%>
<%--        <label><input type="button" value="Clear" onclick="ClearAll()">--%>
<%--            * Delete all items</label>--%>
<%--    </div>--%>
<%--</form>--%>

<table class="table">
    <tr>
        <th>Image</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
    </tr>
    <c:forEach
            items="${ordersKey}" var="order">
        <tr scope="row">
            <td><img src="../../../pub/images/${order.productId.imageUrl}" style="height: 100px; width: 100px;" alt=""></td>
            <td>${order.productId.name}</td>
            <td>${order.productId.price}</td>
            <td>${order.quantity}</td>
<%--            <td><button type="submit" class="btn btn-login">Add</button></td>--%>
        </tr>
    </c:forEach>
</table>


<jsp:include page="../include/footer.jsp" />
