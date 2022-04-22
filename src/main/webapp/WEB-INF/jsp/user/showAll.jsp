<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navBar.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../../pub/css/showAll.css">

<%--<form name="ShoppingList">--%>
<%--    <fieldset>--%>
<%--        <legend>All Products</legend>--%>
<%--        <img src="../../../pub/images/oldasianman.jpg" style="height: 100px; width: 100px;" alt="">--%>
<%--        &lt;%&ndash;       after /images/ put this -> ${}&ndash;%&gt;--%>
<%--        <label>Item: <input type="text" name="name"></label>--%>
<%--        <label>Price: <input type="text" name="data"></label>--%>
<%--        <label>Quantity: <input type="text" name="data"></label>--%>
<%--&lt;%&ndash;        This add should update the cart with both the item and quantity, price can be pulled from db&ndash;%&gt;--%>
<%--        <input type="button" value="Add"   onclick="">--%>
<%--    </fieldset>--%>
<%--    <div id="items_table">--%>
<%--        <h2>Shopping List</h2>--%>
<%--        <table id="list"></table>--%>
<%--        <label><input type="button" value="Clear" onclick="ClearAll()">--%>
<%--            * Delete all items</label>--%>
<%--    </div>--%>
<%--</form>--%>

<table class="table">
    <tr class="tableText">
        <th>Image</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
    </tr>
    <c:forEach
            items="${productsKey}" var="product">
        <tr scope="row" class="tableText">
            <td><img style="border-radius: 0 50% 50% 50%; height: 100px; width: 100px;" src="../../../pub/images/${product.imageUrl}"  alt=""></td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td><a href="./AddCart/${product.id}">Add to Cart</a></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../include/footer.jsp" />