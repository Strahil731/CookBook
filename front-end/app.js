// Импортиране на експортирани функции от съответните файлове
import { showCreatePage } from "./src/createPage.js";
import { showHomePage } from "./src/homePage.js";
import { showLoginPage } from "./src/loginPage.js";
import { showRegisterPage } from "./src/registerPage.js";
import { getUserData } from "./src/userHelper.js";

// Взима на всичи секции и тяхното премахване чрез style
document.querySelectorAll("section").forEach(section => section.style.display = "none");

// Взимане на навигационното меню и слушане на някакво събития, което изпълнява ф-я onNavigation
const navigation = document.getElementById("navigation");
navigation.addEventListener("click", onNavigation);

// Взимане на всички бутони от навигационното меню, с цел разделяне между user и guest
// User - welcome user, logout, create, home
// Guest - login, register, home
const userNav = document.querySelectorAll("li.user");
const guestNav = document.querySelectorAll("li.guest");
const userMSG = document.getElementById("userMsg");

// Обект, който съдържа в себе си href и препращаш към дадената секция
const routes = {
    "/home": showHomePage,
    "/login": showLoginPage,
    "/register": showRegisterPage,
    "/create": showCreatePage,
    "/logout": async () => {
        await sessionStorage.removeItem("userData");
        updateNavigate();
        showHomePage();
    },
    "*": () => console.error("404 Page not found!")
};

// Създаване на функцията onNavigate
function onNavigation(event) {
    // Не позволява страницата да се обнови
    event.preventDefault();

    // Създаване на ново URL и показване на неговото местоположение чрез свойството pathname
    const url = new URL(event.target.href);
    const path = url.pathname;
    routes[path]();
}

// Функция, която ъпдейства навигационното меню
export function updateNavigate() {
    const userData = getUserData();

    //Проверка дали има userData, за да се определи дали е guest или user
    if (userData) {
        userNav.forEach(li => li.style.display = "block");
        guestNav.forEach(li => li.style.display = "none");
        userMSG.textContent = `Welcome, ${userData.firstName} ${userData.lastName}!`;
    }
    else {
        userNav.forEach(li => li.style.display = "none");
        guestNav.forEach(li => li.style.display = "block");
        userMSG.textContent = "";
    }
}

// Извикване на функцията за ъпдейтване на менюто и началната страница
updateNavigate();
showHomePage();