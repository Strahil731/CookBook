import {getUserId} from "../helper/userHelper.js";

const editSection = document.getElementById("createView");
let ctx = null;

export async function showEdit(context, data) {
    ctx = context;
    ctx.render(editSection);

    const id = data[0];
    const response = await fetch(`http://localhost:8080/api/recipe/${id}`, {
        method: "GET"
    });
    const dataDetails = await response.json();
    editSection.innerHTML = createEdit(dataDetails);

    const submitBtn = document.querySelector("input[type='submit']");
    submitBtn.addEventListener("click", async (event) => {
        event.preventDefault();

        const imageUrl = document.getElementById("imgURL").value;
        const title = document.getElementById("createTitle").value;
        const ingredients = document.getElementById("createProduction").value;
        const preparation = document.getElementById("createDescription").value;
        const userId = getUserId();

        if (!imageUrl || !title || !ingredients || !preparation) {
            return alert("Error input");
        }

        const item = {userId, title, imageUrl, ingredients, preparation}
        await fetch(`http://localhost:8080/api/recipe/${id}`, {
            methods: "PATH",
            body: JSON.stringify(item)
        });
        ctx.goTo("/details", id);
    });
}

function createEdit(dataDetails) {
    let ingredients = '';

    for (let product of dataDetails.ingredients) {
        ingredients += `${product.name}-${product.quantity}\n`;
    }

    return `<h2>Edit recipe</h2>
            <form class="editForm" id="editForm">
                <label>Image URL</label>
                <input type="url" id="imgURL" value="${dataDetails.imageUrl}" />
                <label>Recipe Title</label>
                <input type="text" id="createTitle" value="${dataDetails.title}" />
                <label>Products -> <b>one per line</b> / Example: <b>Eggs-2br</b></label>
                <textarea type="text" id="createProduction">${ingredients}</textarea>
                <label>Method of preparation:</label>
                <textarea type="text" id="createDescription">${dataDetails.preparation}</textarea>
                <input type="submit" id="createBtn" value="Update" />
            </form>`;
}