import {showHomePage} from "./homePage.js";
import {getUserId} from "./userHelper.js";

// Създаване на функцията за create секцията
export function showCreatePage() {
    document.querySelectorAll("section").forEach(section => section.style.display = "none");
    document.getElementById("createView").style.display = "block";
}

// Взимане на create форма и прикачване на събитие
const createForm = document.getElementById("createForm");
createForm.addEventListener("submit", onCreate);

// Създаване на функция onCreate, взимаща данните
async function onCreate(event) {
    event.preventDefault();

    // Взимане на стойността на полетата
    const imageUrl = document.getElementById("imgURL").value;
    const title = document.getElementById("createTitle").value;
    const ingredients = document.getElementById("createProduction").value;
    const preparation = document.getElementById("createDescription").value;
    const userId = getUserId();

    // Проверка дали полетата са празни
    if (!imageUrl || !title || !ingredients || !preparation) {
        return alert("Error input");
    }

    // Създаване на POST заявка с данните
    const response = await fetch("http://localhost:8080/api/recipe/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({userId, imageUrl, title, ingredients, preparation})
    });
    const data = await response.json();
    console.log(data);
    showHomePage();
    createForm.reset();
}