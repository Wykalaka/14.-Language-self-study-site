let currentQuestion = 1;
let correctAnswers = 0;
let incorrectAnswers = 0;
let incorrectQuestions = [];

function fetchQuestion(id) {
    return fetch('http://localhost:8765/question/' + id)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        });
}

function fetchAnswer(id) {
    return fetch('http://localhost:8765/answer/' + id)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        });
}

function loadQuestionAndAnswers() {
    fetchQuestion(currentQuestion)
        .then(question => {
            console.log("Fetched question: ", question);
            document.getElementById('question').innerText = question.content;

            // Load each answer
            for (let i = 0; i < question.answers.length; i++) {
                fetchAnswer(question.answers[i].a_id)
                    .then(answer => {
                        console.log("Fetched answer: ", answer);
                        document.getElementById('answer' + (i + 1)).nextElementSibling.innerText = answer.text;
                        document.getElementById('answer' + (i + 1)).value = answer.correct;
                        document.getElementById('answer' + (i + 1)).disabled = false; // Włącz możliwość wyboru odpowiedzi
                    })
                    .catch(error => console.error('Error fetching answer:', error));
            }
        })
        .catch(error => console.error('Error fetching question:', error));
}

function handleAnswerSelection() {
    const answerElements = document.getElementsByName('answer');
    for (let i = 0; i < answerElements.length; i++) {
        if (answerElements[i].checked) {
            answerElements[i].disabled = true; // Wyłącz możliwość zmiany odpowiedzi po zaznaczeniu
            if (answerElements[i].value === 'true') {
                correctAnswers++;
                alert('Poprawna odpowiedź!');
            } else {
                incorrectAnswers++;
                if (!incorrectQuestions.includes(currentQuestion)) {
                    incorrectQuestions.push(currentQuestion);
                }
                alert('Niepoprawna odpowiedź! Spróbuj ponownie.');
            }
            break;
        }
    }
    nextQuestion();
}

function removeQuestion(questionId) {
    incorrectQuestions = incorrectQuestions.filter(id => id !== questionId);
}

function nextQuestion() {
    if (correctAnswers === 4) {
        if (incorrectAnswers === 0) {
            alert('Gratulacje! Odpowiedziałeś poprawnie na wszystkie pytania!');
        } else if (incorrectAnswers <= 3) {
            alert('Brawo! Odpowiedziałeś poprawnie na wszystkie pytania, ale zrobiłeś kilka błędów. Następnym razem będzie lepiej!');
        } else {
            alert('Dobrze próbujesz, ale zrobiłeś zbyt wiele błędów. Spróbuj bardziej się przyłożyć!');
        }
        return;
    }

    if (incorrectQuestions.length > 0) {
        currentQuestion = incorrectQuestions[0];
        incorrectQuestions.shift(); // Usuń pierwsze pytanie z listy
    } else {
        currentQuestion++;
    }

    loadQuestionAndAnswers();
}

loadQuestionAndAnswers();
