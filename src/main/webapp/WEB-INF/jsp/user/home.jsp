<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navBar.jsp" />
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="../../../pub/css/homeFinal.css">

<!-- Image Slider -->
<div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="../../../pub/images/pexels-sesinando-2410300.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption imageCaption d-none d-md-block">
                <h5 class="text-danger">Boba Bomb</h5>
                <p class="text-light">Home to Boba with Explosive Flavor</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="../../../pub/images/pexels-ethan-brooke-2122406.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption imageCaption d-none d-md-block">
                <h5 class="text-danger">Asian Infused</h5>
                <p class="text-light">Our Drinks Come From Roots Laid in Taiwan, but with a touch of Modernity</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="../../../pub/images/pexels-ethan-brooke-3142002.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption imageCaption d-none d-md-block">
                <h5 class="text-danger">Personally Custom</h5>
                <p class="text-light">Flavors are endless, No Need to Limit Yourself Here </p>
            </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<!-- Product Carousel -->
<div id="productSlider" class="carousel slide carousel-fade mt-2" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <div class="row">
                <div class="col-3">
                    <img src="../../../pub/images/tiger_milk_tea.jpg" class="w-100 product">
                    <div class="carousel-caption cc1 d-none d-md-inline">
                        <h5 class="text-danger fw-bolder">Tiger Boba</h5>
                        <p class="text-dark fw-bold">Brown sugar bubble tea with a unique tiger stripe.</p>
                    </div>
                </div>
                <div class="col-3">
                    <img src="../../../pub/images/Matcha.jpg" class="w-100 product">]
                    <div class="carousel-caption cc2 d-none d-md-inline">
                        <h5 class="text-danger fw-bolder">Matcha Silk</h5>
                        <p class="text-light fw-bold">Boba with fresh Japanese matcha and cream top</p>
                    </div>
                </div>
                <div class="col-3">
                    <img src="../../../pub/images/koreanStrawberryMilk.jpg" class="w-100 product">
                    <div class="carousel-caption cc3 d-none d-md-inline">
                        <h5 class="text-danger fw-bolder">Strawberry Touch</h5>
                        <p class="text-light fw-bold">Korean inspired strawberry milk with boba</p>
                    </div>
                </div>
                <div class="col-3">
                    <img src="../../../pub/images/Capture.JPG" class="w-100 product">
                    <div class="carousel-caption cc4 d-none d-md-inline">
                        <h5 class="text-danger fw-bolder">Thai Cloud</h5>
                        <p class="text-dark fw-bold">Oriental style thai tea with foam resembling a cat</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="carousel-item">
            <div class="row">
                <div class="col-3">
                    <img src="../../../pub/images/signatureMilkTea.jpg" class="w-100 product">
                    <div class="carousel-caption cc1 d-none d-md-inline">
                        <h5 class="text-danger fw-bolder">Signature Comfort</h5>
                        <p class="text-light fw-bold">Fresh brewed black tea chilled over ice and boba</p>
                    </div>
                </div>
                <div class="col-3">
                    <img src="../../../pub/images/cosmicMojito.jpg" class="w-100 product">
                    <div class="carousel-caption cc2 d-none d-md-inline">
                        <h5 class="text-danger fw-bolder">Cosmic Breeze</h5>
                        <p class="text-light fw-bold">Chilled Mojito mixed with butterfly pea flowers</p>
                    </div>
                </div>
                <div class="col-3">
                    <img src="../../../pub/images/dragonfruit.JPG" class="w-100 product">
                    <div class="carousel-caption cc3 d-none d-md-inline">
                        <h5 class="text-danger fw-bolder"> Dragon's Kick</h5>
                        <p class="text-light fw-bold">Refreshing Mojito with infused Dragonfruit tea</p>
                    </div>
                </div>
                <div class="col-3">
                    <img src="../../../pub/images/naabVaam.jpg" class="w-100 product">
                    <div class="carousel-caption cc4 d-none d-md-inline">
                        <h5 class="text-danger fw-bolder">Naab Vaam</h5>
                        <p class="text-dark fw-bold">Desert drink from South East Asia</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#productSlider" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#productSlider" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<jsp:include page="../include/footer.jsp" />