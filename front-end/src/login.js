export function showLoginPage() {
    document.querySelectorAll("section").forEach(section => section.style.display = "none");
    document.querySelector("section.login").style.display = "block";
}