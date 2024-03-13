// Създаване на началната секция
export function showHomePage() {
    document.querySelectorAll("section").forEach(section => section.style.display = "none");
    const homeView = document.getElementById("homeView").style.display = "block";
}

const ul = document.createElement("ul");
ul.className = "cards";

// Взимане на данни от сървъра и показване в homePage
async function showRecepi() {

    // Взимане на данните
    const response = await fetch("http://localhost:8080/api/recipe/all", {
        method: "GET"
    });
    const recipe = await response.json();



    // Обхождане на резултата
    for (let el of recipe) {
        let ingredients = '';
        for (let product of el.ingredients) {
            ingredients += `<li>${product.name} - ${product.quantity}</li>`
        }

        ul.innerHTML += `

                <li class="cards_item">
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
                    </div>
                </li>
        `
        homeView.appendChild(ul);
    };
}

showRecepi();