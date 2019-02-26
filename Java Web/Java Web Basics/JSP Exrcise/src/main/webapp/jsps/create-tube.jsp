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

        label,input, textarea, select, button {
            display: block;
            position: center;
            margin:10px auto 0 auto
        }
        input, textarea, select{
            width: 250px;
            height: 30px;
        }
        textarea{
            height: 100px;
        }
        button{
            color: navy;
            text-decoration: none;
            padding: 5px;
            border-radius: 5px;
            background-color:lightblue;
        }

        button:hover{
            background-color:beige;
        }
        hr{
            margin: 30px;
        }
        a{
            text-decoration: none;
        }
        footer{
            text-align:center;
        }
    </style>
</head>
<body>
    <div class="mainContainer">
        <h1>Create Tube!</h1>
        <hr/>
        <form action="/tubes/create" method="post">
            <label for="name">Name:
                <input type="text" name="name" id="name"/>
            </label>
            <hr/>
            <label for="description">Description:
                <textarea name="description" id="description" cols="30" rows="10">
            </textarea>
            </label>
            <hr/>
            <label for="link">YouTube Link:
                <input type="text" name="youTubeLink" id="link"/>
            </label>
            <hr/>
            <label for="uploader">Uploader:
                <input type="text" name="uploader" id="uploader"/>
            </label>
            <hr/>
            <button type="submit">Create Tube</button>
        </form>
        <hr/>
        <a href="/">Back to Home page</a>
    </div>
    <footer>
        <c:import url="../templates/footer.jsp"/>
    </footer>
</body>
</html>
