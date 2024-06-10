document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    try {
        let response = await fetch('http://localhost:8080/login/user', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ login: username, senha: password })
        });

        if (response.ok) {
            let data = await response.json();
            localStorage.setItem('tokenJWT', data.token);
            window.location.href = 'listagemmanutencao.html'; // Redirect to dashboard upon successful login
        } else {
            document.getElementById('message').innerText = 'Login failed. Please check your credentials.';
        }
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('message').innerText = 'An error occurred while processing your request.';
    }
});
