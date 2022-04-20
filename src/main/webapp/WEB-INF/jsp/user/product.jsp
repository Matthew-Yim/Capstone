<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navBar.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../../pub/css/product.css">

<div class="content">
    <div class="form-area">
        <c:if test="${empty formBean.id}">
            <h1>Create Product</h1>
        </c:if>

        <c:if test="${not empty formBean.id}">
            <h1>Edit Product</h1>
        </c:if>
        <form id="registrationForm" action="/product/productSubmit" method="post">
            <div class="form-group">
                <div class="input-icon">
                    <i class="fa-solid fa-signature fa-bounce"></i>
                </div>
                <label id="nameLabel" for="name">Name: </label>
                <input type="text" name="name" id="name" placeholder="Sizzurp"><br>
                <c:forEach items='${bindingResult.getFieldErrors("name")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>
            <div class="form-group">
                <div class="input-icon">
                    <i class="fa-solid fa-signature fa-bounce"></i>
                </div>
                <label id="descriptionLabel" for="description">Description: </label>
                <input type="text" name="description" id="description" placeholder="Purple Bubbly Drink"><br>
                <c:forEach items='${bindingResult.getFieldErrors("description")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>
            <div class="form-group">
                <div class="input-icon">
                    <i class="fa-solid fa-sack-dollar fa-bounce"></i>
                </div>
                <label id="priceLabel" for="price">Price: </label>
                <input type="text" name="price" id="price" placeholder="$0.00"><br>
                <c:forEach items='${bindingResult.getFieldErrors("price")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>
            <div class="form-group">
                <div class="input-icon">
                    <i class="fa-solid fa-image fa-bounce"></i>
                </div>
                <label id="imageUrlLabel" for="imageUrl">Image URL: </label>
                <input type="text" name="imageUrl" id="imageUrl" placeholder="ex: .jpg file"><br>
                <c:forEach items='${bindingResult.getFieldErrors("imageUrl")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>
            <div class="form-group">
                <div class="input-icon">
                    <i class="fa-solid fa-cat fa-bounce"></i>
                </div>
                <label id="categoryLabel" for="category">Category: </label>
                <input type="text" name="category" id="category" placeholder="ex: Blenders/Mixers"><br>
                <c:forEach items='${bindingResult.getFieldErrors("category")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>
            <button type="submit" class="btn btn-login">Submit</button>
        </form>
    </div>
</div>


<jsp:include page="../include/footer.jsp" />