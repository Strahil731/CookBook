// Импортиране на необходимите функции
import { showLoginPage } from "./loginPage.js";
import { setUserData } from "./userHelper.js";

// Взимане на регистрационната форма и прикачване на събитие
const registerForm = document.getElementById("registerForm");
registerForm.addEventListener("submit", onRegister);

// Създаване на регистрационната секция
export function showRegisterPage() {
    document.querySelectorAll("section").forEach(section => section.style.display = "none");
    document.getElementById("registerView").style.display = "block";
}

// Създаване на функция onRegister, взимаща данните
async function onRegister(event) {
    event.preventDefault();

    // Взимане на стойностите на полетата
    const email = document.getElementById("registerEmail").value;
    const firstName = document.getElementById("firstName").value;
    const lastName = document.getElementById("lastName").value;
    const password = document.getElementById("registerPassword").value;
    const isCheckedBtn = document.getElementById("registerCheck");

    // Проверка дали полетата са попълнени
    if (!email || !password || !firstName || !lastName || !isCheckedBtn.checked) {
        return alert("Invalid input!");
    }

    // Създаване на POST заявка с данните
    const response = await fetch("http://localhost:8080/api/auth/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ email, firstName, lastName, password })
    });
    const data = await response.json();

    // Извикване на необходимите функции
    setUserData(data);
    showLoginPage();
}