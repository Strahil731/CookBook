// Създаване на началната секция
export function showHomePage() {
    document.querySelectorAll("section").forEach(section => section.style.display = "none");
    const homeView = document.getElementById("homeView").style.display = "block";
}

// Взимане на parent от HTML
const ul = document.getElementById("cards");

// Взимане на данни от сървъра и показване в homePage
async function showRecepi() {
    ul.innerHTML = "";

    // Взимане на данните
    const response = await fetch("http://localhost:8080/api/recipe/all", {
        method: "GET"
    });
    const recipe = await response.json();

    //Създаване на дете
    const li = document.createElement("li");
    li.className = "cards_item";

    // Обхождане на резултата
    for (let el of recipe) {
        let ingredients = '';
        for(let product of el.ingredients){
            ingredients+=`<li>${product.name} - ${product.quantity}</li>`
        }

        li.innerHTML = `
        <div class="card">
            <div class="card_image">
                <img src="${el.imageUrl}" alt="" />
            </div>
            <div class="card_content">
                <h2 class="card_title">${el.title}</h2>
                    <div class="card_text">
                        <p>Product:
                            <ul>
                                ${ingredients}
                            </ul>
                        </p>
                        <p>${el.preparation}</p>
                    </div>
                </div>
            </div>
        `

    };

    ul.appendChild(li);
    homeView.appendChild(ul);
}

showRecepi();