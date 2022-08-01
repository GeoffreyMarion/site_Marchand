$(document).ready(function () {
	console.log("OK from handleCart.js");
  let ready = false;
  $.ajax({
    url: "products2.json",
    dataType: "json",
    success: function (data) {
      console.log(data);

      var style = "";
      for (var i = 0; i < data.produits.length; i++) {
        var card_title = data.produits[i].nom;
        var card_text = data.produits[i].description;
        var card_img_url = data.produits[i].image;
        var card_price = data.produits[i].prix;

        console.log("card_img_url", card_img_url);

        style += "<div class='container_card col-lg-3 col-md-6'>";
        style = style += " <div class='card' style='width: 18rem'>";

        style +=
          "<img src='" +
          card_img_url +
          "' class='card-img-top card_img' alt='...'>";
        // style += "<li>";
        style += "<div class='card-body'>";
        style += "<h5 class='card-title'>" + card_title + "</h5>";

        style +=
          "<p class='card-text'>'Some quick example text to build on the card title and make up the bulk of the card' + 's content.'</p>";
        style += "<div class='container_card-price'>";
        style += "<h5>Prix:</h5>";
        style += "<h5 id='card_price'>" + card_price + "</h5>";
        style += "<h5>€</h5>";
        style += "</div>";
        style +=
          "<a href='#' class='btn btn-primary btn_add-to-cart'>Ajouter au panier</a>";
        style += "</div>";
        style += "</div>";
        style += "</div>";
      }

      $(".row").html(style);
      ready = true;
      console.log("ready", ready);
      // var btns_addToCart = document.querySelectorAll("btn_add-to-cart");
      // console.log("btns_addToCart", btns_addToCart);
      let productsAddedToCart = [];
      selectBtns(productsAddedToCart);
    },
    error: function (xhr) {
      console.log(xhr.status);
    },
  });
  console.log("ready", ready);
});

function selectBtns(productsAddedToCart) {
  var btns_addToCart = document.querySelectorAll(".btn_add-to-cart");
  console.log("btns_addToCart", btns_addToCart);
  btns_addToCart.forEach((element) => {
    console.log(element.id);
    element.addEventListener("click", function () {
      console.log("clicked element", element.parentNode);
      addProductToCart(productsAddedToCart, element.parentNode);
    });
  });
}

function addProductToCart(productsAddedToCart, product) {
    reinitiateDisplayCart();

  console.log("product within addProductToCart ", product);
  // productsAddedToCart.push(product);
  // console.log("productsAddedToCart", productsAddedToCart);

  console.log("product.firstChild.innerHTML", product.firstChild.innerHTML);
  // console.log(
  //   "product.firstChild.nextSibling.nextSibling.innerHTML",
  //   product.firstChild.nextSibling.nextSibling.innerHTML
  // );
  // console.log(
  //   "product.firstChild.nextSibling.nextSibling.textContent",
  //   product.firstChild.nextSibling.nextSibling.textContent
  // );
  let textPrice = product.firstChild.nextSibling.nextSibling;
  // console.log(textPrice);
  console.log(textPrice.firstChild.nextSibling.textContent);

  let formattedProduct = [
    product.firstChild.innerHTML,
    textPrice.firstChild.nextSibling.textContent,
  ];
  console.log("formattedProduct", formattedProduct);

  console.log("productsAddedToCart before check", productsAddedToCart);

  if (!isPresent(productsAddedToCart, formattedProduct)) {
    productsAddedToCart.push(formattedProduct);
  }
  console.log("productsAddedToCart after check and push", productsAddedToCart);

  displayCart(productsAddedToCart);
  // let style = "";
  // for (var i = 0; i < productsAddedToCart.length; i++) {
  //   var product_title = productsAddedToCart[i][0];
  //   var product_price = productsAddedToCart[i][1];
  //   style += "<div class='container_cart-designation-btn_supprimer-price'>";
  //   style += "<div class='container_cart-designation-btn_supprimer'>";
  //   style += style += "<h6>Désignation:</h6>";
  //   style += "<p>" + product_title + "</p>";
  //   style += "</div>";
  //   style += "<a href='#' class='btn btn-danger btn_supprimer'>Supprimer</a>";

  //   // console.log("card_img_url", card_img_url);

  //   // style += "<div class='container_card col-lg-3 col-md-6'>";
  //   // style = style += " <div class='card' style='width: 18rem'>";

  //   // style +=
  //   //   "<img src='" +
  //   //   card_img_url +
  //   //   "' class='card-img-top card_img' alt='...'>";
  //   // // style += "<li>";
  //   // style += "<div class='card-body'>";
  //   // style += "<h5 class='card-title'>" + card_title + "</h5>";

  //   // style +=
  //   //   "<p class='card-text'>'Some quick example text to build on the card title and make up the bulk of the card' + 's content.'</p>";
  //   // style += "<h5>Prix: " + card_price + "€</h5>";
  //   // style +=
  //   //   "<a href='#' class='btn btn-primary btn_add-to-cart'>Ajouter au panier</a>";
  //   // style += "</div>";
  //   // style += "</div>";

  //   style += "</div>";
  // }

  // $(".container_details-cart").html(style);
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