// JavaScript
let userInfoDiv = document.getElementById('user-info');
let user = localStorage.getItem('user');
if (user) {
  userInfoDiv.textContent = `Zalogowany jako: ${user}`;
} else {
  userInfoDiv.textContent = 'Nie jesteś zalogowany.';
}

let loginLink = document.querySelector('.header a[href="login.html"]');
let registerLink = document.querySelector('.header a[href="registration.html"]');

if (user) {
  loginLink.textContent = 'Wyloguj się';
  loginLink.href = '#';
  loginLink.addEventListener('click', function(event) {
    event.preventDefault();
    localStorage.removeItem('user');
    localStorage.removeItem('userRole');
    location.reload();
  });
  registerLink.remove();
}

let userRole = localStorage.getItem('userRole');
if (userRole == 1) {
  let navigationDiv = document.querySelector('.header');
  let manageLink = document.createElement('a');
  manageLink.href = "manage.html";
  manageLink.textContent = "Zarządzaj";
  navigationDiv.appendChild(manageLink);
}


const coursesSection = document.getElementById('courses-section');
const newCoursesSection = document.getElementById('new-courses-section');


const ongoingCourses = [
  {
    title: 'Kurs języka angielskiego',
    description: 'Kontynuuj  rozwiązywanie zadań z kursu języka angielskiego.',
    link: 'kurs-angielski.html'
  },
];


const newCourses = [
  {
    title: 'Kurs języka hiszpańskiego',
    description: 'Rozpocznij naukę języka hiszpańskiego i rozwiązuj nowe zadania.',
    link: 'kurs-hiszpanski.html'
  },
  {
    title: 'Kurs języka francuskiego',
    description: 'Rozpocznij naukę języka francuskiego i rozwiązuj nowe zadania.',
    link: 'kurs-francuski.html'
  }
];

ongoingCourses.forEach(course => {
  const courseDiv = document.createElement('div');
  courseDiv.className = 'course';

  const title = document.createElement('h3');
  title.textContent = course.title;

  const description = document.createElement('p');
  description.textContent = course.description;

  const continueButton = document.createElement('button');
  continueButton.className = 'continue-btn';
  continueButton.textContent = 'Kontynuuj';

  continueButton.addEventListener('click', () => {
    window.location.href = course.link;
  });

  courseDiv.appendChild(title);
  courseDiv.appendChild(description);
  courseDiv.appendChild(continueButton);
  coursesSection.appendChild(courseDiv);
});


newCourses.forEach(course => {
  const courseDiv = document.createElement('div');
  courseDiv.className = 'new-course';

  const title = document.createElement('h3');
  title.textContent = course.title;

  const description = document.createElement('p');
  description.textContent = course.description;

  const startButton = document.createElement('button');
  startButton.className = 'start-btn';
  startButton.textContent = 'Rozpocznij';

  startButton.addEventListener('click', () => {
    window.location.href = course.link;
  });

  courseDiv.appendChild(title);
  courseDiv.appendChild(description);
  courseDiv.appendChild(startButton);
  newCoursesSection.appendChild(courseDiv);
});



