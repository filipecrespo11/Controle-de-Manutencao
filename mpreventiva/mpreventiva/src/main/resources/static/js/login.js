document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    // Obtém os valores dos campos de entrada
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    // Verifica se os campos estão preenchidos
    if (!username || !password) {
        document.getElementById('message').innerText = 'Por favor, preencha todos os campos.';
        return;
    }

    try {
        const BASE_URL = 'http://localhost:8080'; // URL base do backend
        let response = await fetch(`${BASE_URL}/login/user`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ login: username, senha: password }) // Corpo da requisição
        });

        if (response.ok) {
            let data = await response.json();
            localStorage.setItem('tokenJWT', data.token); // Armazena o token JWT
            window.location.href = 'listagemmanutencao.html'; // Redireciona para a página principal
        } else if (response.status === 401) {
            document.getElementById('message').innerText = 'Credenciais inválidas.';
        } else if (response.status >= 500) {
            document.getElementById('message').innerText = 'Erro no servidor. Tente novamente mais tarde.';
        } else {
            document.getElementById('message').innerText = 'Login falhou. Verifique suas credenciais.';
        }
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('message').innerText = 'Ocorreu um erro ao processar sua solicitação.';
    }
});