// JavaScript
document.getElementById('loginForm').addEventListener('submit', loginUser);

function loginUser(event) {
    event.preventDefault();

    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;

    if(email && password){
        localStorage.setItem('user', email);
        window.location.href = 'index.html';
    } else {
        alert('Proszę wprowadzić poprawne dane logowania.');
    }
}
