<html>
<head>
    <style>
        *{
    padding: 0px;
    margin: 0px;
    overflow: hidden;
}
#backGround{
    width: 100%;
    height: 100vh;
    background-color:snow;
    position: absolute;
}
.circle{
    width: 150px;
    height: 150px;
    /* background-color: red; */
    /* border: 5px solid black; */
    border-radius: 100%;
    background-size: 1500px;
    background-position: 1500px;
    animation: circle 5s infinite both;
    filter: blur(40px);
}
@keyframes circle {
    0%{
        transform: translate(0px,0px) scale(1);
        background-size: 1500px;
    }
    20%{
        transform: translate(700px,300px) scale(1.4);
    }
    40%{
        transform: translate(0px,400px) scale(1.4);
    }
    60%{
        transform: translate(200px,300px) scale(1.8);

    }
    80%{
        transform: translate(450px,100px) scale(2);
    }
    100%{
        transform: translate(300px,200px) scale(1);
        background-size: 0px;

    }
    
}
#red{
    animation-direction: reverse;
    animation-delay: 0s;
    animation-timing-function: ease-in;
    background-image: linear-gradient(75deg,red,orange,blue,green,orange,blue,red);
}
#green{
    animation-direction: alternate;
    animation-delay: 0.5s;
    animation-timing-function: ease-in-out;
    background-image: linear-gradient(65deg,green,red,darkgreen,red,blue,orange,lime,lightgreen);
}
#blue{
    animation-direction: alternate-reverse;
    animation-delay: 1s;
    animation-timing-function: ease-out;
    background-image: linear-gradient(75deg,blue,white,skyblue,red,blue,green,blue,orange);
}
#formDivContainer{
    width: 100%;
    height: 100vh;
    /* background-color: black; */
    position: absolute;
    display: flex;
}
#form{
    width: 40%;
    height: 100vh;
    /* background-color: white; */
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
}
.loginContainer{
    margin-left: 10px;
    width: 7vw;
    /* width: 40vw; */
    border: 2px solid black;
    height: 7vw;
    /* background-color: white; */
    border-radius: 100%;
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    box-shadow: 2px 2px 2px black;
    cursor: pointer;
    transition: all 0.5s;
}
.loginContainer:hover{
    width: 40vw;
    border-radius: 100vh 0px 0px 100vh;
}
.loginContainer:hover input{
    display: block;

}
input{
    width: 80%;
    height: 80%;
    background-color:transparent;
    border: none;
    outline: none;
    text-align: center;
    font-size: 24px;
    letter-spacing: 5px;
}
i{
    font-size: 4vw;
}
#button{
    background-color:black;
    border-radius: 10px;
    box-shadow: 5px 5px 5px black;
    color: white;
    font-weight: bold;
}
input{
    display: none;
}
#heading{
    width: 60%;
    height: 70%;
    /* background-color: lawngreen; */
    position: absolute;
    top: 0px;
    right: 0px;
    display: flex;
    justify-content: space-evenly;
    align-items: end;
    font-size: 3vw;
    overflow: hidden;
}
#accountCreate{
    width: 60%;
    height:30%;
    /* background-color: yellow; */
    position: absolute;
    border-top: 1px solid black;
    bottom: 0px;
    right: 0px;
}
.headingLetters{
font-family: 'Courier New', Courier, monospace;
text-shadow: 5px 5px 5px black;
font-weight: bolder;
animation: textanimation 2s infinite alternate both;
}
#L{
    animation-delay: 0s;
    color: darkblue;
}
#O{
    animation-delay: 0.3s;
    color: rgb(232, 1, 47);
}
#G{
    animation-delay: 0.5s;
    color: rgb(191, 5, 191);
}
#I{
    animation-delay: 1s;
    color: rgb(211, 5, 5);
}
#N{
    animation-delay: 0.9s;
    color: rgb(2, 47, 2);
}
#P{
    animation-delay: 1.5s;
    color: rgb(1, 12, 42);
}
#E{
    animation-delay: 1s;
    color: rgb(12, 111, 197);
}
@keyframes textanimation {
    0%{
        transform: translate(0px,-800px) scale(0.2);
   }
   25%{
    transform: translate(0px,0px) rotate(360deg);
  }
  40%{
    transform: translate(0px,0px) rotate(0deg);
 }
 50%{
    transform: translate(0px,-80px) rotateY(-45deg) rotate(75deg) scale(1.5);
 }
 75%{
    transform: translate(0px,0px) scale(1) rotate(0deg) rotateY(0deg) scale(1);

 }
 95%{
    transform: translate(0px,-30px) scale(1.3) rotate(-75deg) rotateY(45deg);

 }
 100%{
    transform: translate(0px,0px) scale(1);

 }
    
}
a{
    /* background-color: orange; */
    text-align: center;
    display: inline-block;
    width: 100%;
    font-size: 28px;
    padding-top: 10px;
    letter-spacing: 5px;
    font-weight: bold;
    text-decoration: none;
    color:blue;
    text-shadow: 0.5px 1px 2px black;
    transition: all 0.2s;
}
h2{
position: absolute;
bottom: 50px;
right: 38%;
letter-spacing: 5px;
color: red;
font-size: 2rem;
}
a:hover{
    color: green;
    letter-spacing: 8px;
}
    </style>
</head>
<body>

	<div id="backGround">
        <div class="circle" id="red"></div>
        <div class="circle" id="green"></div>
        <div class="circle" id="blue"></div>
    </div>
    <div id="formDivContainer">
        <form action="Login" method="post" id="form">
            <div class="loginContainer">
            <i class="fa-solid fa-user fa-shake"></i>
            <input  placeholder="Enter the EmailId or MobileNumber" name="emailid">
        	</div>

        	<div class="loginContainer">
            <i class="fa-solid fa-key fa-shake"></i>
            <input id="button" type = "password" placeholder="Enter the Password" name="password">
        	</div>
        	<div class="loginContainer">
            <i class="fa-solid fa-thumbs-up fa-shake"></i>
            <input type="submit" id="button" value="Login">

        	</div>
      	</form>
        <div id="heading">
            <h1 class="headingLetters" id="L">L</h1>
            <h1 class="headingLetters" id="O">O</h1>
            <h1 class="headingLetters" id="G">G</h1>
            <h1 class="headingLetters" id="I">I</h1>
            <h1 class="headingLetters" id="N">N</h1>
            <h1 class="headingLetters" id="P">P</h1>
            <h1 class="headingLetters" id="A">A</h1>
            <h1 class="headingLetters" id="G">G</h1>
            <h1 class="headingLetters" id="E">E</h1>
        </div>
        <div id="accountCreate">
            <a href="Registration.jsp">Create an Account!!!</a>

        </div>
        

    </div>
</body>
</html>
