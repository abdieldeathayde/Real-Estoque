const form = document.getElementById("loginForm");
const mensagem = document.getElementById("mensagem");

form.addEventListener("submit", async (e) => {
    e.preventDefault();

<<<<<<< HEAD
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    try {

=======
    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();

    if (!username || !password) {
        mensagem.innerText = "Preencha usuário e senha";
        mensagem.style.color = "red";
        return;
    }

    try {

        // ✅ URL do endpoint do Spring Boot
>>>>>>> 0dc24ae (hash de senha)
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

<<<<<<< HEAD
        if (!response.ok) {
            mensagem.innerText = "Usuário ou senha inválidos";
=======
        let data = null;

        // tenta converter resposta em JSON
        const text = await response.text();
        if (text) {
            data = JSON.parse(text);
        }

        if (!response.ok) {
            mensagem.innerText =
                data?.error || "Usuário ou senha inválidos";
>>>>>>> 0dc24ae (hash de senha)
            mensagem.style.color = "red";
            return;
        }

<<<<<<< HEAD
        const data = await response.json();
=======
        if (!data?.token) {
            mensagem.innerText = "Token não recebido do servidor";
            mensagem.style.color = "red";
            return;
        }
>>>>>>> 0dc24ae (hash de senha)

        // ✅ salva JWT
        localStorage.setItem("token", data.token);

<<<<<<< HEAD
        mensagem.innerText = "Login realizado!";
        mensagem.style.color = "green";

        // redireciona
        setTimeout(() => {
            window.location.href = "dashboard.html";
        }, 1000);

    } catch (error) {
        mensagem.innerText = "Erro ao conectar com servidor";
        mensagem.style.color = "red";
        console.error(error);
    }
});
=======
        mensagem.innerText = "Login realizado com sucesso!";
        mensagem.style.color = "green";

        setTimeout(() => {
            window.location.href = "index.html";
        }, 1000);

    } catch (error) {
        console.error("Erro login:", error);
        mensagem.innerText = "Erro ao conectar com servidor";
        mensagem.style.color = "red";
    }
});
>>>>>>> 0dc24ae (hash de senha)
