<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/navBar.jsp" />

<div [ngClass]="{'card-highlight': product.listItemHovered}" class="card card-equal-height"
     (mouseenter)="hoverListItem(product)"
     (mouseleave)="hoverListItem(product)"
     (click)="test(product)">
    <div class="card-image">
        <figure class="image is-square">
            <img src="product.imageURL" alt="{{product.title}}">
        </figure>
    </div>
    <div class="card-content">
        <p class="title has-text-centered"> {{product.title}}</p>
        <p class="subtitle">{{product.price | currency: "USD"}}</p>
    </div>
    <div class="card-footer">
        <p class="card-footer-item">
            <button (click)="removeFromCart(product); showRemoved()"
                    class="button is-danger is-outlined is-pulled-left is-small"> Remove
            </button>
        </p>
        <p class="card-footer-item">
            <button (click)="addToCart(product);showAdded()"
                    class="button is-outlined is-primary is-pulled-right is-small"> Add to Cart
            </button>
        </p>
    </div>
</div>

<jsp:include page="../include/footer.jsp" />