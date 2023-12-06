<%-- 
    Document   : welcome
    Created on : Apr 10, 2023, 9:50:33 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <h1>Welcome ${userId}</h1>
        
        <a href="search.html">Search Course</a>
        
        <c:if test="${isUser}">
            <a href="booking.html">Booking</a>
        </c:if>
        
        <c:if test="${isAdmin}">
            <a href="updateCourse.jsp">Update Course</a>
            <a href="createNewCourse.html">Create Course</a>
        </c:if>

        <h2><a href="MainController?option=Logout">Logout</a></h2>
    </body>
</html>
