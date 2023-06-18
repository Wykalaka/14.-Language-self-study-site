document.getElementById("registrationForm").addEventListener("submit", function(event) {
  event.preventDefault(); // Prevent form submission

  // Get form values
  var firstName = document.getElementById("firstName").value;
  var lastName = document.getElementById("lastName").value;
  var dob = document.getElementById("dob").value;
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;

  // Validate form data (you can add more validation if needed)
  if (firstName === "" || lastName === "" || dob === "" || email === "" || password === "") {
    alert("Please fill in all fields");
    return;
  }

  // Prepare the data
  let data = {
    first_Name: firstName,
    last_Name: lastName,
    date_of_birth: dob,
    e_mail: email,
    password: password,
    role_id: 4,
    started_course_ids: []
  };

  // Create a request variable and assign a new XMLHttpRequest object to it.
  var request = new XMLHttpRequest();

  // Open a new connection, using the POST request on the URL endpoint
  request.open('POST', 'http://localhost:8765/user/', true);
  request.setRequestHeader('Content-Type', 'application/json');

  // Send request
  request.send(JSON.stringify(data));

  // Clear form fields
  document.getElementById("firstName").value = "";
  document.getElementById("lastName").value = "";
  document.getElementById("dob").value = "";
  document.getElementById("email").value = "";
  document.getElementById("password").value = "";

  alert('User added successfully!');
});

function redirectToHome() {
  // Redirect to the home page
  window.location.href = "index.html";
}
