<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<head>
    <%--FIXME не находит фоновое изображение--%>
    <meta charset="UTF-8">
    <title>Result Table</title>
    <link href = "result.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div>
        <table class="result-table">
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
                <th><%= session.getAttribute("x")           .toString() %></th>
                <th><%= session.getAttribute("y")           .toString() %></th>
                <th><%= session.getAttribute("r")           .toString() %></th>
                <th><%= session.getAttribute("curtime")     .toString() %></th>
                <th><%= session.getAttribute("exectime")    .toString() %></th>
                <th><%= session.getAttribute("hitres")      .toString() %></th>
            </tr>
        </table>
    </div>
    <a href="index.jsp"> Wuld Nah Kest! </a>

</body>

