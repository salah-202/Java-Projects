<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Date Age Calculator</title>
    <style>
        #result {
            font-weight: bold;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>Date Age Calculator</h1>
    <form action = "CalcAgeServlet">
        <p>Date of Birth</p>
        <input type="date" name="birthdate" required>
        <p>age at the date of</p>
        <input type="date" name="currentdate" required>
        <br><br>
        <button type="submit" id="calculateBtn">Calculate</button>
    </form>

    <h2 id="result">Result</h2>

    <h3>age</h3>

    <br>${years} years,</br>
    <br>${months} months,</br>
    <br>${days} days and</br>
    <br>${hours} hours</br>
</body>
</html>
