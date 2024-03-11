import { showCreatePage } from "./create.js";
import { showHomePage } from "./home.js";
import { showLoginPage } from "./login.js";
import { showRegisterPage } from "./register.js";
import { getUserData } from "./userHelper.js";

document.querySelectorAll("section").forEach(section => section.style.display = "none");
document.getElementById("navigation").addEventListener("click", onNavigation);

const userNav = document.querySelectorAll("li.user");
const guestNav = document.querySelectorAll("li.guest");
const userMsg = document.getElementById("userMsg");

const routes = {
    "/home": showHomePage,
    "/login": showLoginPage,
    "/register": showRegisterPage,
    "/create": showCreatePage
};

function onNavigation(event) {
    event.preventDefault();

    const url = new URL(event.target.href);
    const path = url.pathname;
    routes[path]();
}

function updateNav() {
    const userData = getUserData();

    if (!userData) {
        userNav.forEach(li => li.style.display = "none");
        guestNav.forEach(li => li.style.display = "block");
        userMsg.textContent = "";
    }
    else{
        userNav.forEach(li => li.style.display = "block");
        guestNav.forEach(li => li.style.display = "none");
        userMsg.textContent = `Welcome, ${userData.firstName}`;
    }
}

updateNav();