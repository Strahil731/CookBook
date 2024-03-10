export function showHomePage() {
    document.querySelectorAll("div").forEach(div => div.style.display = "none");
    document.getElementById("reception").style.display = "block";
}