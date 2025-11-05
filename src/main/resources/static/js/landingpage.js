const app = document.getElementById("app")
const SERVER_URL = 'http://localhost:8080/api/v1/';


function createPage() {
    const topicInput = document.createElement("about")
    topicInput.textContent = "Topic";
    topicInput.type = "input";

    app.appendChild(topicInput)
}

async function getFalseFact(event){
    event.preventDefault()

    const url = `${SERVER_URL}fact?about=${document.getElementById('the-question').value}`
}