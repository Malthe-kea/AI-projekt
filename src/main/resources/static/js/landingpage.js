
const app = document.getElementById("app")
const SERVER_URL = 'http://localhost:8080/api/v1/';
const requestAndResponseDiv = document.createElement("div")
const factCheckDiv = document.createElement("div")
createPage()

function createPage() {


    const container = document.createElement("div");
    requestAndResponseDiv.id = "request-and-response-div";
    requestAndResponseDiv.className = "main-div"

    const footer = document.createElement("footer")

    const label = document.createElement("label");
    label.textContent = "Topic: ";
    label.setAttribute("for", "the-topic");

    const topicInput = document.createElement("input");
    topicInput.id = "the-topic";
    topicInput.type = "text";
    topicInput.placeholder = "Skriv et emne...";

    const button = document.createElement("button");
    button.textContent = "Hent falsk fakta";
    button.addEventListener("click", async (event) => {
        const falseFact = await getFalseFact(event);
        if (falseFact) {
            await factChecker(falseFact, document.getElementById("the-topic").value);
        }
    });



    const img = document.createElement("img")
    img.className = "img-car"
    img.src = "pictures/berlingo.png"
    img.height = 300;
    img.addEventListener("click", () => {
        window.open("https://restaurantgorilla.dk/", "_blank");
    });

    footer.appendChild(img)
    container.appendChild(label);
    container.appendChild(topicInput);
    container.appendChild(button);
    container.appendChild(footer)
    requestAndResponseDiv.appendChild(container)
    app.appendChild(requestAndResponseDiv);
}

export async function getFalseFact(event) {
    event.preventDefault();

    const inputValue = document.getElementById('the-topic').value;
    const url = `${SERVER_URL}funfact?about=${encodeURIComponent(inputValue)}`;

    try {
        const data = await fetch(url).then(handleHttpErrors);
        const answer = data?.choices?.[0]?.message?.content || "Ingen svar fundet";

        const resultDiv = document.createElement("p");
        resultDiv.textContent = answer;
        requestAndResponseDiv.appendChild(resultDiv);

        // 👇 Returner falsk fakta
        return answer;

    } catch (e) {
        const errorMsg = document.createElement("p");
        errorMsg.style.color = "red";
        errorMsg.innerText = e.message;
        app.appendChild(errorMsg);
    }
}

async function factChecker(falseFact, topic) {
    const factCheckUrl = `${SERVER_URL}factchecker`;

    const factCheckResponse = await fetch(factCheckUrl, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ statement: falseFact, topic }),
    }).then(handleHttpErrors);

    const factCheckData = factCheckResponse;
    const factCheckResult = factCheckData?.choices?.[0]?.message?.content || "Ingen respons fra factchecker";

    const resultDiv = document.createElement("div");
    resultDiv.className = "fact-check-result";
    resultDiv.innerHTML = `
        <h4>Factchecker siger:</h4>
        <p>${factCheckResult}</p>
    `;

    factCheckDiv.innerHTML = "";
    factCheckDiv.className = "main-div"
    factCheckDiv.appendChild(resultDiv);
    app.appendChild(factCheckDiv);
}



async function handleHttpErrors(res) {
    if (!res.ok) {
        const errorResponse = await res.json();
        const msg = errorResponse.message ? errorResponse.message : "No error details provided"
        throw new Error(msg)
    }
    return res.json()
}