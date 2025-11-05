const app = document.getElementById("app")
const SERVER_URL = 'http://localhost:8080/api/v1/';

createPage()
function createPage() {
    const container = document.createElement("div");

    const label = document.createElement("label");
    label.textContent = "Topic: ";
    label.setAttribute("for", "the-topic");

    const topicInput = document.createElement("input");
    topicInput.id = "the-topic";
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

    const inputValue = document.getElementById('the-topic').value;
    const url = `${SERVER_URL}fact?about=${encodeURIComponent(inputValue)}`;


    const resultDiv = document.createElement("p");
    resultDiv.textContent = `Her ville jeg hente falsk fakta om: ${inputValue}`;
    app.appendChild(resultDiv)

    const response = await fetch(url);
    const data = await response.json();
    console.log(data)
}