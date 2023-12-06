<%-- 
    Document   : search
    Created on : Apr 10, 2023, 12:22:28 PM
    Author     : LENOVO
--%>

<%@page import="hang.course.CourseDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result Page</title>
    </head>
    <body>
        <h1>Search Course Result</h1>
        <form action="MainController" method="post" >
            <input type="text" name="txtsearch" value=""/>
            <select name="searchby">
                <option value="byname">By Name</option>   
                <option value="bycate">By Category</option> 
            </select>
            <input type="submit" value="Search" name="option" />
        </form>
        <h2></h2>
        <%
            String searchValue = request.getParameter("txtsearch");
            if (searchValue != null) {
                List<CourseDTO> result = (List<CourseDTO>) request.getAttribute("SEARCHRESULT");
                if (result != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Course ID</th>
                    <th>Course Name</th>
                    <th>Category Name</th>
                    <th>Tuition Fee</th>
                    <th>Description</th>
                    <th>Image</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (CourseDTO dto : result) {
                %>
                <tr>
                    <td><%= ++count%></td>
                    <td><%= dto.getId()%></td>
                    <td><%= dto.getName()%></td>
                    <td><%= dto.getCateName()%></td>
                    <td><%= dto.getFee()%></td>
                    <td><%= dto.getDescription()%></td>
                    <td><img src="<%= dto.getImg()%>"</td>
                    <td><%= dto.getStartDate()%></td>
                    <td><%= dto.getEndDate()%></td>
                    <td><%= dto.getStatus()%></td>
                </tr>    
            <%
                }//for
            %>   
            </tbody>
        </table>
        <%
        }//if result
        else {
        %>
        <h2>No record is matched.</h2>
        <%
                }//else
            }//if searchValue
        %>
    </body>
</html>
