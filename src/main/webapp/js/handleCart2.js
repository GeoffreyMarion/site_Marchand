function addProductToCart(productsAddedToCart, product) {
    reinitiateDisplayCart();
//  console.log("productsAddedToCart within addProductToCart ", productsAddedToCart);
  console.log("product within addProductToCart ", product);
//    console.log("product.firstChild.nextElementSibling.firstChild.nextElementSibling.innerHTML within addProductToCart ", product.firstChild.nextElementSibling.firstChild.nextElementSibling.innerHTML);
    let productTitle = product.firstChild.nextElementSibling.firstChild.nextElementSibling.innerHTML;
//      console.log("productTitle:  ", productTitle);
//            console.log("///////////////////////////////////////////");
//          console.log("product.firstChild.nextElementSibling.nextElementSibling.firstChild.nextElementSibling.currentSrc within addProductToCart ", product.firstChild.nextElementSibling.nextElementSibling.firstChild.nextElementSibling.currentSrc);
let productImg = product.firstChild.nextElementSibling.nextElementSibling.firstChild.nextElementSibling.currentSrc;
//      console.log("productImg:  ", productImg);
//                  console.log("///////////////////////////////////////////");
//          console.log("product.firstChild.nextElementSibling.nextElementSibling.nextElementSibling.firstChild.nextElementSibling.nextElementSibling.innerHTML within addProductToCart ", product.firstChild.nextElementSibling.nextElementSibling.nextElementSibling.firstChild.nextElementSibling.nextElementSibling.innerHTML);
let productPrice = product.firstChild.nextElementSibling.nextElementSibling.nextElementSibling.firstChild.nextElementSibling.nextElementSibling.innerHTML;
//      console.log("productPrice:  ", productPrice);
let productFormatted = {};
productFormatted.title = productTitle;
productFormatted.img = productImg;
productFormatted.price = productPrice;

if(!isPresent(productsAddedToCart, productFormatted)) {
	productsAddedToCart.push(productFormatted);
}
//      console.log("productsAddedToCart:  ", productsAddedToCart);//      
      displayCart(productsAddedToCart);
}

function addPrincipalProductToCart(productsAddedToCart, product) {
    reinitiateDisplayCart();
      console.log("product within addPrincipalProductToCart ", product);
    console.log("product.firstChild.nextElementSibling ", product.firstChild.nextElementSibling);
let productTitle = product.firstChild.nextElementSibling.firstChild.nextElementSibling.innerHTML;
      console.log("productTitle: ", productTitle);
let productImg= product.parentNode.firstChild.nextElementSibling.firstChild.nextElementSibling.src;
      console.log("productImg: ", productImg);
let productPrice =product.firstChild.nextElementSibling.nextElementSibling.firstChild.nextElementSibling.firstChild.nextElementSibling.nextElementSibling.innerHTML;
      console.log("productPrice: ", productPrice);
      let productFormatted = {};
productFormatted.title = productTitle;
productFormatted.img = productImg;
productFormatted.price = productPrice;
if(!isPresent(productsAddedToCart, productFormatted)) {
	productsAddedToCart.push(productFormatted);
}
      displayCart(productsAddedToCart);

}

function displayCart(productsAddedToCart) {
  console.log("productsAddedToCart within displayCart", productsAddedToCart);
  reinitiateDisplayCart();
  
  let style = "";
  for (var i = 0; i < productsAddedToCart.length; i++) {
    var product_title = productsAddedToCart[i].title;
        var product_img = productsAddedToCart[i].img;
    var product_price = productsAddedToCart[i].price;
    style += "<div class='container_cart-designation-btn_supprimer-price'>";
    style += "<div class='container_cart-designation-btn_supprimer'>";
    style += style += "<h6>Désignation:</h6>";
    style += "<p>" + product_title + "</p>";
      style += style += "<img src=" +  product_img + " class='sidebar_img'>";
//            style += style += "<h5>" + product_price + "</h5>";
//    style += "</div>";
    style += "<a href='#' class='btn btn-danger btn_supprimer'>Supprimer</a>";
    style += "</div>";
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
    if (array[i].title == element.title) {
      isPresent = true;
    }
  }
  console.log("isPresent", isPresent);
  return isPresent;
}


function changeQte() {
console.log("within changeQte ", productsAddedToCart);

}