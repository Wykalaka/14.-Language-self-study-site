document.getElementById('loginForm').addEventListener('submit', loginUser);

function loginUser(event) {
    event.preventDefault();

    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;

    fetch('http://localhost:8765/user/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({email: email, password: password}),
    })
        .then(response => {
            if(response.ok) {
                return response.json();
            } else {
                throw new Error('Invalid login credentials');
            }
        })
        .then(data => {
            localStorage.setItem('user', data.email);
            window.location.href = 'index.html';
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('Proszę wprowadzić poprawne dane logowania.');
        });
}
