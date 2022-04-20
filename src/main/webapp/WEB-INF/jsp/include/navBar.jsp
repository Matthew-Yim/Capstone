<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- Nav Bar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top" style="background-color: #3F3F3F; opacity: 0.85">
    <div class="container-fluid">
        <a class="navbar-brand" href="/home">
            <img id="boba-logo" src="../../../pub/images/bobaGif.jpg" alt="" width="50" height="50"
                 class="d-inline-block align-text-top">
            Boba Bomb</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/home">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Menu
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <li>
                            <a class="dropdown-item" href="../drinks/tranquilTeas">Tranquil Teas</a>
                            <div class="dropdown-divider"></div>
                        </li>
                        <li>
                            <a class="dropdown-item" href="../drinks/icySnows">Icy Snows</a>
                            <div class="dropdown-divider"></div>
                        </li>
                        <li>
                            <a class="dropdown-item" href="../drinks/freshBlenders">Fresh Blenders</a>
                            <div class="dropdown-divider"></div>
                        </li>
                        <li>
                            <a class="dropdown-item" href="../drinks/hypnoticMixers">Hypnotic Mixers</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <sec:authorize access="!isAuthenticated()">
                        <a class="nav-link" href="/user/cart">Cart</a>
                    </sec:authorize>
                </li>
                <li class="nav-item">
                    <sec:authorize access="!isAuthenticated()">
                    <a class="nav-link" href="/product">Create/Edit Product</a>
                    </sec:authorize>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/showAll">All Products</a>
                </li>
                <li class="nav-item">
                    <p style="color: white; ">Welcome Back, <sec:authentication property="name"/></p>
                </li>

            </ul>
        </div>
        <sec:authorize access="!isAuthenticated()">
            <a id="login" href="../user/login">Login</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a id="login" href="../user/login">Logout</a>
        </sec:authorize>
        <span>/</span>
        <a id="signUp" href="../user/register">Sign up</a>
    </div>
</nav>
