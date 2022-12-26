<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<head>
    <%--FIXME не находит фоновое изображение--%>
    <meta charset="UTF-8">
    <title>Result Table</title>
    <link href = "css/stylesheets/result.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="container">
        <table>
            <caption>Result Table</caption>
            <tr>
                <th>x</th>
                <th>y</th>
                <th>r</th>
                <th>curtime</th>
                <th>exectime</th>
                <th>hitres</th>
            </tr>
            <tr>
                <th><%= session.getAttribute("x").toString() %></th>
                <th><%= session.getAttribute("y").toString() %></th>
                <th><%= session.getAttribute("r").toString() %></th>
                <th><%= session.getAttribute("curtime").toString() %></th>
                <th><%= session.getAttribute("exectime").toString() %></th>
            </tr>
        </table>
    </div>
</body>

