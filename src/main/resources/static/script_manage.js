// Zdefiniowanie funkcji, która konwertuje datę do formatu 'dd.mm.rrrr'
function formatDate(dateString) {
    let date = new Date(dateString);
    return date.getDate() + "." + (date.getMonth() + 1) + "." + date.getFullYear();
}

// Zdefiniowanie funkcji, która pobiera informacje o użytkownikach z backendu
function getUsers() {
    // Utworzenie nowego obiektu XMLHttpRequest
    var request = new XMLHttpRequest();

    // Konfiguracja żądania
    request.open('GET', 'http://localhost:8765/user/', true);

    // Definiowanie co ma się wydarzyć po otrzymaniu odpowiedzi
    request.onload = function () {
        if (request.status >= 200 && request.status < 400) {
            // Sukces! Odebrano dane.
            var users = JSON.parse(request.responseText);

            // Wysyłamy drugie żądanie do API, które zwraca informacje o kursach
            var coursesRequest = new XMLHttpRequest();
            coursesRequest.open('GET', 'http://localhost:8765/started_course/', true);
            coursesRequest.onload = function () {
                if (coursesRequest.status >= 200 && coursesRequest.status < 400) {
                    var courses = JSON.parse(coursesRequest.responseText);

                    // Przyłączamy informacje o kursach do użytkowników
                    users.forEach(user => {
                        user.started_courses = courses.filter(course => course.u_id === user.u_id);
                    });

                    displayUsers(users);
                } else {
                    // Serwer zwrócił kod błędu
                    console.log("Błąd serwera");
                }
            };

            coursesRequest.send();
        } else {
            // Serwer zwrócił kod błędu
            console.log("Błąd serwera");
        }
    };

    // Wysłanie żądania
    request.send();
}


// Zdefiniowanie funkcji, która wyświetla informacje o użytkownikach w tabeli
function displayUsers(users) {
    var table = document.getElementById('usersTable');

    users.forEach(user => {
        var courses = user.started_course_ids || []; // Jeśli user.started_course_ids jest niezdefiniowane, używamy pustej tablicy
        var row = document.createElement('tr');
        row.innerHTML = `
      <td>${user.first_Name}</td>
      <td>${user.last_Name}</td>
      <td>${user.email}</td>
      <td>${formatDate(user.date_of_birth)}</td>
      <td>${courses.length > 0 ? courses.join(', ') : 'Brak kursu'}</td>
    `;
        table.appendChild(row);
    });
}

// Wywołanie funkcji getUsers() po załadowaniu struktury strony
document.addEventListener('DOMContentLoaded', getUsers);
