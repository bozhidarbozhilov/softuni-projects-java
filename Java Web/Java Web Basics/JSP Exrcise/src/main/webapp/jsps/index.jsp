<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Me Tube v1</title>
    <style>
        .mainContainer{
            padding: 3% 5%;
            width: 70%;
            margin: 0 auto;
            background-color: lightgray;
            text-align: center;
        }
        a{
            color: navy;
            text-decoration: none;
            padding: 5px;
            border-radius: 5px;
            background-color:lightblue;
        }

        .buttonContainer{
            display: inline-block;
            width: 40%;
            justify-content: center;
        }

        a:hover{
            background-color:beige;
        }
        hr{
            margin: 30px;
        }

        footer{
            text-align:center;
        }
    </style>
</head>
<body>
    <div class="mainContainer">
        <h1>Welcome to MeTube</h1>
        <hr/>
        <h3>Cool app beta version</h3>
        <hr/>
        <div class="buttonContainer">
            <a href="tubes/create">Create Tube</a>
        </div>
        <div class="buttonContainer">
            <a href="/tubes/all">All Tubes</a>
        </div>
    </div>
    <footer>
        <c:import url="../templates/footer.jsp"/>
    </footer>
</body>
</html>
