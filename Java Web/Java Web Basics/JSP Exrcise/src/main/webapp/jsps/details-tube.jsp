<%@ page import="metube.domain.models.view.TubeViewModel" %>
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
    <% TubeViewModel model = (TubeViewModel) request.getAttribute("viewModel");%>
    <% if(model==null){%>
        <h3>Tube with such name doesn't exists <a href="/tubes/create">Would you like to create it!</a></h3>
    <%}else{%>
            <h1><%= model.getName()%></h1>
    <hr/>
    <h3><%=model.getDescription()%></h3>
    <hr/>
    <div class="buttonContainer">
        <a href="<%=model.getYouTubeLink()%>">Link To Video</a>
    </div>
    <div class="buttonContainer">
        <%=model.getUploader()%>
    </div>
    <hr/>
    <%}%>

    <a href="/">Back to Home page</a>
</div>
<footer>
    <c:import url="../templates/footer.jsp"/>
</footer>
</body>
</html>
