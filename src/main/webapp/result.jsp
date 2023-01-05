<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.grxuau.weblab2.utils.TableRow" %>

<% ArrayList<TableRow> table;
    Object attribute = request.getSession().getServletContext().getAttribute("table");
    if(attribute != null){
        table = (ArrayList<TableRow>) attribute;
    } else {table = new ArrayList<>();}
%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Result Table</title>
    <link href = "css/stylesheets/result.css" rel="stylesheet" type="text/css">
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
        <table class="result-table">
            <caption>Result Table</caption>
            <thead>
                <tr>
                    <th>x</th>
                    <th>y</th>
                    <th>r</th>
                    <th>hitres</th>
                    <th>curtime</th>
                    <th>exectime</th>
                </tr>
            </thead>
            <tbody>
            <c:if test="${table!=null}">
                <c:forEach items="${table}" var="tableRow">
                <tr>
                    <td>${tableRow.getX()}</td>
                    <td>${tableRow.getY()}</td>
                    <td>${tableRow.getR()}</td>
                    <td>${tableRow.getHitResult()}</td>
                    <td>${tableRow.getClientDate()}</td>
                    <td>${tableRow.getScriptWorkingTime()}</td>
                </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
        <div class="link-to-main-page"><a href="index.jsp"> Wuld Nah Kest! </a></div>
</body>
