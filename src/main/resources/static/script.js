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

  // Process the registration (you can add your own logic here)
  // For demonstration purposes, let's display the submitted data in an alert message
  var message = "Registration successful!\n\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Date of Birth: " + dob + "\n" +
                "Email: " + email;
  alert(message);

  // Clear form fields
  document.getElementById("firstName").value = "";
  document.getElementById("lastName").value = "";
  document.getElementById("dob").value = "";
  document.getElementById("email").value = "";
  document.getElementById("password").value = "";
  

  function redirectToHome() {
    // Redirect to the home page
    window.location.href = "index.html";
  }
});
