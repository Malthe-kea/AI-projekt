const app = document.getElementById("app")
const SERVER_URL = 'http://localhost:8080/api/v1/';

createPage()
function createPage() {
    const container = document.createElement("div");

    const label = document.createElement("label");
    label.textContent = "Topic: ";
    label.setAttribute("for", "the-question");

    const topicInput = document.createElement("input");
    topicInput.id = "the-question";
    topicInput.type = "text";
    topicInput.placeholder = "Skriv et emne...";

    const button = document.createElement("button");
    button.textContent = "Hent falsk fakta";
    button.addEventListener("click", getFalseFact);

    container.appendChild(label);
    container.appendChild(topicInput);
    container.appendChild(button);
    app.appendChild(container);
}

async function getFalseFact(event){
    event.preventDefault()

    const url = `${SERVER_URL}fact?about=${document.getElementById('the-question').value}`
}