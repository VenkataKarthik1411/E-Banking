<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
       body {
    background-color: #f0f8ff; /* Lighter background color */
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    overflow: hidden; /* Prevents scrollbars on animated background */
}

.container {
    max-width: 600px;
    margin: 50px auto;
    padding: 40px;
    background-color: #ffffff;
    border-radius: 15px;
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.15);
    position: relative;
    z-index: 2; /* Ensures the form is above the animated background */
}

h1 {
    text-align: center;
    color: #007bff;
    margin-bottom: 30px;
    font-size: 2.5rem;
    text-transform: uppercase; /* Makes the title stand out */
    letter-spacing: 1px; /* Adds spacing between letters for a refined look */
    animation: titlePulse 1.5s infinite alternate; /* Animated title */
}

@keyframes titlePulse {
    from {
        transform: scale(1);
        text-shadow: 0 0 10px #007bff;
    }
    to {
        transform: scale(1.05);
        text-shadow: 0 0 20px #007bff, 0 0 30px #007bff;
    }
}

form {
    display: flex;
    flex-direction: column;
    gap: 15px;
}

input {
    padding: 15px;
    margin: 10px 0;
    border: 2px solid transparent;
    border-radius: 8px;
    transition: all 0.3s ease;
    background-color: #f8f9fa; /* Light background for inputs */
}

input:focus {
    border-color: #007bff;
    outline: none;
    box-shadow: 0 0 0 2px rgba(0, 123, 255, 0.25);
}

input[type="submit"] {
    background-color: #007bff;
    color: #fff;
    font-weight: bold;
    cursor: pointer;
    transition: background-color 0.3s ease;
    border: none; /* Removes the border for a cleaner look */
}

input[type="submit"]:hover {
    background-color: #0056b3;
}

/* Enhanced animated background */
body::before {
    content: "";
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 1;
    background: linear-gradient(60deg, #ff758c, #8446cc, #3a1c71, #ff758c); /* More vibrant colors */
    background-size: 300% 300%;
    animation: gradientAnimation 15s ease infinite;
}

@keyframes gradientAnimation {
    0%, 100% {
        background-position: 0% 50%;
    }
    50% {
        background-position: 100% 50%;
    }
}

/* Input field animations */
input:not([type="submit"]) {
    animation: inputAnimation 0.5s ease-out forwards;
}

@keyframes inputAnimation {
    from {
        opacity: 0;
        transform: translateY(-20px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}

/* Staggered animation delay for input fields */
input[type="text"] {
    animation-delay: 0.2s;
}

input[type="email"] {
    animation-delay: 0.4s;
}

input[type="tel"] {
    animation-delay: 0.6s;
}

input[type="password"] {
    animation-delay: 0.8s;
}

input[type="text"][name="address"] {
    animation-delay: 1s;
}
       
    </style>
</head>
<body>
    <div class="container">
        <h1>Registration</h1>
        <form action="registration" method="post">
            <input type="text" placeholder="Enter Your Name" name="username">
            <input type="email" placeholder="Enter Your EmailId" name="useremailid">
            <input type="tel" placeholder="Enter Your Mobile Number" name="mobilenumber">
            <input type="password" placeholder="Enter Your Password" name="password">
            <input type="text" placeholder="Enter Your Address" name="address">
            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>
