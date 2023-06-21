//Nie radzi sobie z polskimi znakami
document.getElementById("registrationForm").addEventListener("submit", function(event) {
  event.preventDefault(); // Prevent form submission

  var firstName = document.getElementById("firstName").value;
  var lastName = document.getElementById("lastName").value;
  var dob = document.getElementById("dob").value;
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;

  if (firstName === "" || lastName === "" || dob === "" || email === "" || password === "") {
    alert("Please fill in all fields");
    return;
  }

  // Żeby tworzyło tylko zwykłych userów id=4
  let data = {
    first_Name: firstName,
    last_Name: lastName,
    date_of_birth: dob,
    email: email,
    password: password,
    role_id: 4,
    started_course_ids: []
  };

  var request = new XMLHttpRequest();

  request.open('POST', 'http://localhost:8765/user/', true);
  request.setRequestHeader('Content-Type', 'application/json');

  request.send(JSON.stringify(data));


  document.getElementById("firstName").value = "";
  document.getElementById("lastName").value = "";
  document.getElementById("dob").value = "";
  document.getElementById("email").value = "";
  document.getElementById("password").value = "";

  alert('User added successfully!');
});

function redirectToHome() {
  window.location.href = "index.html";
}
