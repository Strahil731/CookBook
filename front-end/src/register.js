export function showRegisterPage() {
    document.querySelectorAll("section").forEach(section => section.style.display = "none");
    document.querySelector("section.register").style.display = "block";
}

document.getElementById("registerForm").addEventListener("submit", onRegister);
const baseURL = "http://localhost:8080/"

async function onRegister(event) {
    event.preventDefault();

    const email = document.getElementById("registerEmail").value;
    const firstName = document.getElementById("firstName").value;
    const lastName = document.getElementById("lastName").value;
    const password = document.getElementById("registerPassword").value;
    const registerCheck = document.getElementById("registerCheck");

    if (!email || !firstName || !lastName || !password || !registerCheck.checked) {
        return alert("Invalid inputs!");
    }

    const response = await fetch(baseURL + "api/auth/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ email, firstName, lastName, password })
    });
    const data = await registerCheck.json();

    console.log(data);
}