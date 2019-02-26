<%@ page import="metube.domain.models.view.AllTubesViewModel" %>
<%@ page import="java.util.List" %>
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

        .buttonContainer{
            display: inline-block;
            width: 40%;
            justify-content: center;
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
    <% List<AllTubesViewModel> allTubes = (List<AllTubesViewModel>) request.getAttribute("allTubes");%>
    <h1>All Tubes</h1>
    <hr/>
    <h3>Check out tubes below</h3>
    <hr/>

        <% if(allTubes.size()>0){%>
    <ul>
        <% for (AllTubesViewModel allTube : allTubes) {%>
            <li><a href="/tubes/details?name=<%=allTube.getName()%>"><%=allTube.getName()%></a></li>
             <%}%>
    </ul>
        <%}else{%>
        <p>No tubes – <a href="/tubes/create">Create some!</a></p>
        <%}%>

    <hr/>
    <a href="/">Back to Home page</a>
</div>
<footer>
    <c:import url="../templates/footer.jsp"/>
</footer>
</body>
</html>
