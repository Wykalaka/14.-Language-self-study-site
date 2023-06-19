function formatDate(dateString) {
    let date = new Date(dateString);
    return date.getDate() + "." + (date.getMonth() + 1) + "." + date.getFullYear();
}

function getUsers() {
    var request = new XMLHttpRequest();

    request.open('GET', 'http://localhost:8765/user/', true);

    request.onload = function () {
        if (request.status >= 200 && request.status < 400) {
            var users = JSON.parse(request.responseText);

            var coursesRequest = new XMLHttpRequest();
            coursesRequest.open('GET', 'http://localhost:8765/started_course/', true);
            coursesRequest.onload = function () {
                if (coursesRequest.status >= 200 && coursesRequest.status < 400) {
                    var courses = JSON.parse(coursesRequest.responseText);

                    users.forEach(user => {
                        let userCourses = courses.filter(course => course.user.u_id === user.u_id);
                        user.started_courses = userCourses.map(course => course.course.language);
                        user.sc_ids = userCourses.map(course => course.sc_id);
                    });

                    displayUsers(users);
                } else {
                    console.log("Błąd serwera");
                }
            };

            coursesRequest.send();
        } else {
            console.log("Błąd serwera");
        }
    };

    request.send();
}

function deleteCoursesAndUser(u_id, sc_ids) {
    sc_ids.forEach(sc_id => {
        var deleteCourseRequest = new XMLHttpRequest();
        deleteCourseRequest.open('DELETE', 'http://localhost:8765/started_course/' + sc_id, true);
        deleteCourseRequest.send();
    });

    var request = new XMLHttpRequest();
    request.open('DELETE', 'http://localhost:8765/user/' + u_id, true);
    request.onload = function () {
        if (request.status >= 200 && request.status < 400) {
            location.reload();
        } else {
            console.log("Błąd serwera");
        }
    };
    request.send();
}

function displayUsers(users) {
    var table = document.getElementById('usersTable');

    users.forEach(user => {
        var started_courses = user.started_courses || [];
        var row = document.createElement('tr');
        row.innerHTML = `
            <td>${user.first_Name}</td>
            <td>${user.last_Name}</td>
            <td>${user.email}</td>
            <td>${formatDate(user.date_of_birth)}</td>
            <td>${started_courses.length > 0 ? started_courses.join(', ') : 'Brak kursu'}</td>
            <td><button onclick="deleteCoursesAndUser(${user.u_id}, [${user.sc_ids}])">Usuń użytkownika i jego kursy</button></td>
        `;
        table.appendChild(row);
    });
}

document.addEventListener('DOMContentLoaded', getUsers);
