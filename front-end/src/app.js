import { showHomePage } from "./home.js";

document.querySelectorAll("div").forEach(div => div.style.display = "none");
const navigator = document.querySelector("nav");
navigator.addEventListener("submit", onNavigation);

const routes = {
    "/home": showHomePage
};

function onNavigation(event) {
    event.preventDefault();

    const url = new URL(event.target.href);
    const path = url.pathname;
    routes[path]();
}