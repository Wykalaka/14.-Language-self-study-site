const questions = [
  {
    question: "What is the capital of England?",
    answers: ["London", "Paris", "Berlin", "Madrid"],
    correctAnswer: 0
  },
  {
    question: "Who wrote Romeo and Juliet?",
    answers: ["William Shakespeare", "Jane Austen", "Charles Dickens", "Mark Twain"],
    correctAnswer: 0
  },
  {
    question: "What is the largest ocean in the world?",
    answers: ["Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean"],
    correctAnswer: 0
  }
];

let remainingQuestions = questions.slice(); // Kopia pytań
let currentQuestionIndex = 0;

const questionContainer = document.getElementById("question-container");
const questionElement = document.getElementById("question");
const answersElement = document.getElementById("answers");
const resultElement = document.getElementById("result");

function showQuestion() {
  const question = remainingQuestions[currentQuestionIndex];

  questionElement.textContent = question.question;

  answersElement.innerHTML = "";

  question.answers.forEach((answer, index) => {
    const button = document.createElement("button");
    button.className = "answer";
    button.textContent = answer;
    button.addEventListener("click", () => {
      checkAnswer(index);
    });
    answersElement.appendChild(button);
  });
}

function checkAnswer(selectedIndex) {
  const question = remainingQuestions[currentQuestionIndex];

  if (selectedIndex === question.correctAnswer) {
    resultElement.textContent = "Odpowiedź poprawna!";
    resultElement.classList.remove("incorrect");
    resultElement.classList.add("correct");
  } else {
    resultElement.textContent = "Odpowiedź błędna!";
    resultElement.classList.remove("correct");
    resultElement.classList.add("incorrect");
    remainingQuestions.push(question); // Dodanie pytania z błędną odpowiedzią z powrotem do puli
  }

  currentQuestionIndex++;

  if (currentQuestionIndex < remainingQuestions.length) {
    showQuestion();
  } else {
    questionContainer.style.display = "none";
    showFinalResult();
  }
}

function showFinalResult() {
  const finalResultElement = document.createElement("div");
  finalResultElement.textContent = `Zakończyłeś rozwiązywanie pytań.`;

  const returnButton = document.createElement("button");
  returnButton.textContent = "Wróć do strony głównej";
  returnButton.addEventListener("click", () => {
    window.location.href = "index.html"; // Przekierowanie do strony głównej
  });

  finalResultElement.appendChild(returnButton);
  document.body.appendChild(finalResultElement);
}

showQuestion();
