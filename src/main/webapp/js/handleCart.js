$(document).ready(function () {
	console.log("OK from handleCart.js");
  let ready = false;
  let productsAddedToCart = [];
  console.log("ready", ready);
    console.log("productsAddedToCart", productsAddedToCart);
          selectBtns(productsAddedToCart);
});

function selectBtns(productsAddedToCart) {
  var btns_addToCart = document.querySelectorAll(".btn_add-to-cart");
  console.log("btns_addToCart", btns_addToCart);
  btns_addToCart.forEach((element) => {
    console.log(element.id);
    element.addEventListener("click", function () {
      console.log("clicked element", element.parentNode);
      console.log("clicked element.firstChild.nextElementSibling.href", element.parentNode.firstChild.nextElementSibling.href);
      addProductToCart(productsAddedToCart, element.parentNode.firstChild.nextElementSibling.href);
      productsAddedToCart.push(element.parentNode.firstChild.nextElementSibling.href);
    });
  });
}

function addProductToCart(productsAddedToCart, productURI) {
    reinitiateDisplayCart();
  console.log("productsAddedToCart within addProductToCart ", productsAddedToCart);
  console.log("productURI within addProductToCart ", productURI);
}

function displayCart(productsAddedToCart) {
  console.log("productsAddedToCart within displayCart", productsAddedToCart);
  reinitiateDisplayCart();

  let style = "";
  for (var i = 0; i < productsAddedToCart.length; i++) {
    var product_title = productsAddedToCart[i][0];
    var product_price = productsAddedToCart[i][1];
    style += "<div class='container_cart-designation-btn_supprimer-price'>";
    style += "<div class='container_cart-designation-btn_supprimer'>";
    style += style += "<h6>Désignation:</h6>";
    style += "<p>" + product_title + "</p>";
    style += "</div>";
    style += "<a href='#' class='btn btn-danger btn_supprimer'>Supprimer</a>";

    // console.log("card_img_url", card_img_url);

    // style += "<div class='container_card col-lg-3 col-md-6'>";
    // style = style += " <div class='card' style='width: 18rem'>";

    // style +=
    //   "<img src='" +
    //   card_img_url +
    //   "' class='card-img-top card_img' alt='...'>";
    // // style += "<li>";
    // style += "<div class='card-body'>";
    // style += "<h5 class='card-title'>" + card_title + "</h5>";

    // style +=
    //   "<p class='card-text'>'Some quick example text to build on the card title and make up the bulk of the card' + 's content.'</p>";
    // style += "<h5>Prix: " + card_price + "€</h5>";
    // style +=
    //   "<a href='#' class='btn btn-primary btn_add-to-cart'>Ajouter au panier</a>";
    // style += "</div>";
    // style += "</div>";

    style += "</div>";
  }

  $(".container_details-cart").html(style);
}

function reinitiateDisplayCart() {
  let style = "";
  $(".container_details-cart").html(style);
}

function isPresent(array, element) {
  let isPresent = false;
  for (let i = 0; i < array.length; i++) {
    if (array[i][0] == element[0]) {
      isPresent = true;
    }
  }
  return isPresent;
}

function filterArray(array) {
  for (let i = 0; i < array.length; i++) {
    if (array[i][0] == element[0]) {
      isPresent = true;
    }
  }
  return isPresent;
}

{
  /* <div class="card" style="width: 18rem;">
                    <img src="" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of
                            the card's content.</p>
                        <h5>Prix: €</h5>
                        <a href="#" class="btn btn-primary">Ajouter au panier</a>
                    </div>
                </div> */
}