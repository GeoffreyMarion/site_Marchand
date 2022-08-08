function openSideDrawer() {
  // document.getElementById("side-drawer").style.left = "0";
  console.log("within openSideDrawer");
  document.getElementById("side-drawer").style.right = "0";
  document.getElementById("side-drawer-void").classList.add("d-block");
  document.getElementById("side-drawer-void").classList.remove("d-none");
}

function closeSideDrawer() {
  // document.getElementById("side-drawer").style.left = "-336px";
  document.getElementById("side-drawer").style.right = "-336px";
  document.getElementById("side-drawer-void").classList.add("d-none");
  document.getElementById("side-drawer-void").classList.remove("d-block");
}

window.openSideDrawer = openSideDrawer;
window.closeSideDrawer = closeSideDrawer;