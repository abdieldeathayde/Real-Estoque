const form = document.getElementById("loginForm");
const mensagem = document.getElementById("mensagem");

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    try {

        const response = await fetch("http://localhost:8080/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username,
                password
            })
        });

        // ✅ declara UMA vez só
        let data = null;

        const text = await response.text();

        if (text) {
            data = JSON.parse(text);
        }

        if (response.ok) {

            mensagem.innerText = "Login realizado com sucesso!";
            mensagem.style.color = "green";

            // salva token se existir
            if (data?.token) {
                localStorage.setItem("token", data.token);
            }

        } else {
            mensagem.innerText = data?.message || "Usuário ou senha inválidos";
            mensagem.style.color = "red";
        }

    } catch (error) {
        mensagem.innerText = "Erro ao conectar com servidor";
        mensagem.style.color = "red";
        console.error(error);
    }
});