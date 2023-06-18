// JavaScript
const coursesSection = document.getElementById('courses-section');
const newCoursesSection = document.getElementById('new-courses-section');

// Dane kursów językowych rozpoczętych przez użytkownika
const ongoingCourses = [
  {
    title: 'Kurs języka angielskiego',
    description: 'Zacząłeś rozwiązywać zadania z kursu języka angielskiego. Kontynuuj, aby kontynuować naukę.',
    link: 'kurs-angielski.html' // Dodajemy link do strony docelowego kursu
  },
  {
    title: 'Kurs języka niemieckiego',
    description: 'Zacząłeś rozwiązywać zadania z kursu języka niemieckiego. Kontynuuj, aby kontynuować naukę.',
    link: 'kurs-niemiecki.html' // Dodajemy link do strony docelowego kursu
  }
];

// Dane nowych kursów
const newCourses = [
  {
    title: 'Kurs języka hiszpańskiego',
    description: 'Rozpocznij naukę języka hiszpańskiego i rozwiązuj nowe zadania.',
    link: 'kurs-hiszpanski.html' // Dodajemy link do strony docelowego kursu
  },
  {
    title: 'Kurs języka francuskiego',
    description: 'Rozpocznij naukę języka francuskiego i rozwiązuj nowe zadania.',
    link: 'kurs-francuski.html' // Dodajemy link do strony docelowego kursu
  }
];

// Wyświetlanie kursów językowych rozpoczętych
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

  // Dodajemy obsługę kliknięcia przycisku "Kontynuuj"
  continueButton.addEventListener('click', () => {
    window.location.href = course.link;
  });

  courseDiv.appendChild(title);
  courseDiv.appendChild(description);
  courseDiv.appendChild(continueButton);
  coursesSection.appendChild(courseDiv);
});

// Wyświetlanie nowych kursów
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

  // Dodajemy obsługę kliknięcia przycisku "Rozpocznij"
  startButton.addEventListener('click', () => {
    window.location.href = course.link;
  });

  courseDiv.appendChild(title);
  courseDiv.appendChild(description);
  courseDiv.appendChild(startButton);
  newCoursesSection.appendChild(courseDiv);
});
