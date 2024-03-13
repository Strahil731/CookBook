// Създаване на началната секция
export function showHomePage() {
    document.querySelectorAll("section").forEach(section => section.style.display = "none");
    document.getElementById("homeView").style.display = "block";
}