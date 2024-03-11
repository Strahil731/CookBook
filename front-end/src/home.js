export function showHomePage() {
    document.querySelectorAll("section").forEach(section => section.style.display = "none");
    document.querySelector("section.receptions").style.display = "block";
}