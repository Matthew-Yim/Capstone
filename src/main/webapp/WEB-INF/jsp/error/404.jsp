<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navBar.jsp" />
<link rel="stylesheet" href="../../../pub/css/success.css">
<style>
    body{
        color: white;
    }
</style>
<h1>404 Error Page</h1>
<div class="video-mask-register">
    <video id="videoLogin" autoplay loop>
        <source src="https://c.tenor.com/B1pr6_svEpcAAAPo/bee-club-bee-club-gc.mp4" type="video/mp4">
    </video>
</div><br>

<c:if test="${not empty requestUrl}">
    <p>${requestUrl}</p>
</c:if>
<h3>Stack Trace</h3>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
<c:if test="${not empty stackTrace}">
    <p>${stackTrace}</p>
</c:if>
<h3>Root Cause</h3>
<c:if test="${not empty rootcause}">
    <p>${rootcause}</p>
</c:if>
<c:if test="${not empty rootTrace}">
    <p>${roottrace}</p>
</c:if>

<jsp:include page="../include/footer.jsp" />
