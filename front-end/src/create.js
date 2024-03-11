export function showCreatePage() {
    document.querySelectorAll("section").forEach(section => section.style.display = "none");
    document.querySelector("section.create").style.display = "block";
}