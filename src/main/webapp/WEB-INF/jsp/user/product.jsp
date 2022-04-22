<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navBar.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="../../../pub/css/product.css">

<sec:authorize access="isAuthenticated()">
    <div class="content">
        <div class="form-area">
            <c:if test="${empty form.id}">
                <h1>Create Product</h1>
            </c:if>

            <c:if test="${not empty form.id}">
                <h1>Edit Product</h1>
            </c:if>
            <form id="productForm" action="/product/productSubmit" method="post">
                <input type="hidden" name="id" value="${form.id}">
                <div class="form-group">
                    <div class="input-icon">
                        <i class="fa-solid fa-signature fa-bounce"></i>
                    </div>
                    <label id="nameLabel" for="name">Name: </label>
                    <input type="text" name="name" id="name" placeholder="Sizzurp" value="${form.name}"><br>
                    <c:forEach items='${bindingResult.getFieldErrors("name")}' var="error">
                        <div style="color:red;">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </div>
                <div class="form-group">
                    <div class="input-icon">
                        <i class="fa-solid fa-signature fa-bounce"></i>
                    </div>
                    <label id="descriptionLabel" for="description">Description: </label>
                    <input type="text" name="description" id="description" placeholder="Purple Bubbly Drink" value="${form.description}"><br>
                    <c:forEach items='${bindingResult.getFieldErrors("description")}' var="error">
                        <div style="color:red;">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </div>
                <div class="form-group">
                    <div class="input-icon">
                        <i class="fa-solid fa-sack-dollar fa-bounce"></i>
                    </div>
                    <label id="priceLabel" for="price">Price: </label>
                    <input type="text" name="price" id="price" placeholder="$0.00" value="${form.price}"><br>
                    <c:forEach items='${bindingResult.getFieldErrors("price")}' var="error">
                        <div style="color:red;">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </div>
                <div class="form-group">
                    <div class="input-icon">
                        <i class="fa-solid fa-image fa-bounce"></i>
                    </div>
                    <label id="imageUrlLabel" for="imageUrl">Image URL: </label>
                    <input type="text" name="imageUrl" id="imageUrl" placeholder="ex: .jpg file" value="${form.imageUrl}"><br>
                    <c:forEach items='${bindingResult.getFieldErrors("imageUrl")}' var="error">
                        <div style="color:red;">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </div>
                <div class="form-group">
                    <div class="input-icon">
                        <i class="fa-solid fa-cat fa-bounce"></i>
                    </div>
                    <label id="categoryLabel" for="category">Category: </label>
                    <input type="text" name="category" id="category" placeholder="ex: Blenders/Mixers" value="${form.category}"><br>
                    <c:forEach items='${bindingResult.getFieldErrors("category")}' var="error">
                        <div style="color:red;">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </div>
                <button type="submit" class="btn btn-login">Submit</button>
            </form>
        </div>
    </div>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <div class="content">
        <div class="form-area">
            <h2 >Job Opportunities</h2>

            <form id="productForm" action="/product/productSubmit" method="post">
                <label id="firstNameLabel" for="firstName">First Name: </label>
                <input type="text" name="email" id="firstName" placeholder="Donkey"><br>
                <label id="lastNameLabel" for="lastName">Last Name: </label>
                <input type="text" name="email" id="lastName" placeholder="Kong"><br>
                <label id="phoneLabel" for="phone">Phone: </label>
                <input type="text" name="phone" id="phone" placeholder="Kong"><br>
                <label id="emailLabel" for="email">Email: </label>
                <input type="text" name="email" id="email" placeholder="email@domain.com"><br>
                <br>
                I am over 18 years old. <input type="checkbox" name="checkbox">
                I agree to be contacted for employment. <input type="checkbox" name="checkbox">
                <br>
                <button type="submit" class="btn btn-login">Submit</button>
            </form>
        </div>
    </div>
</sec:authorize>
<jsp:include page="../include/footer.jsp" />


