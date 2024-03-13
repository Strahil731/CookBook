import { updateNavigate } from "../app.js";
import { showHomePage } from "./homePage.js";
import { setUserData } from "./userHelper.js";

// Създаване на login секцията
export function showLoginPage() {
    document.querySelectorAll("section").forEach(section => section.style.display = "none");
    document.getElementById("loginView").style.display = "block";
}

// Взимане на login форма и прикачване на събитие
const loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", onLogin);

// Създаване на функция onLogin, взимаща данните
async function onLogin(event) {
    event.preventDefault();

    // Взимане на стойността от полетата
    const email = document.getElementById("loginEmail").value;
    const password = document.getElementById("loginPassword").value;

    // Проверка дали са попълнени полетата
    if (!email || !password) {
        return alert("Invalid email or password!");
    }

    // Създаване на POST заявка с данните
    const response = await fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ email, password })
    });
    if (response.status === 401) {
        return alert("Invalid email or password");
    }
    const data = await response.json();
    setUserData(data);
    updateNavigate();
    showHomePage();
}