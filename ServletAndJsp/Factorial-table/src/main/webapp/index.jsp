<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Calculate Factorials</title>
</head>
<body>
        <form action="FactorialServlet" method="get">
            <button type="submit" id="calculateBtn">Calculate Factorial</button>
        </form>

        <table border="1" cellpadding="5">
            <tr>
                <th>Number</th>
                <th>Factorial</th>

            </tr>
            <c:forEach var="number" items="${Numbers}">
                <tr>
                    <td><c:out value="${number}" /></td>
                    <td><c:out value="${Factorials[number]}" /></td>

                </tr>
            </c:forEach>
        </table>
</body>
</html>
