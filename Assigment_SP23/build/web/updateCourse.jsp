<%-- 
    Document   : updateCourse
    Created on : Apr 24, 2023, 8:15:39 AM
    Author     : LENOVO
--%>
<%@page import="hang.course.CourseDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <h1>Update Course</h1>
        <form action="MainController" method="post" >
            <input type="text" name="txtsearch" value=""/>
            <select name="searchby">
                <option value="byname">By Name</option>   
                <option value="bycate">By Category</option> 
            </select>
            <input type="submit" value="SearchUpdate" name="option" />
        </form>
        <h2></h2>
        <%
            String searchValue = request.getParameter("txtsearch");
            String searchBy = request.getParameter("searchby");
            if (searchValue != null) {
                List<CourseDTO> result = (List<CourseDTO>) request.getAttribute("SEARCHUPDATERESULT");
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
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (CourseDTO dto : result) {
                %>
            <form action="MainController">
                <tr>
                    <td><%= ++count%></td>
                    <td>
                        <%= dto.getId()%>
                        <input type="hidden" name="txtID" value="<%= dto.getId()%>"/>
                    </td>
                    <td>
                        <input type="text" name="txtName" pattern="\w{3,50}" required value="<%= dto.getName()%>" />
                    </td>
                    <td><%= dto.getCateName()%></td>
                    <td>
                       <input type="number" name="txtFee" required min="1000000" value="<%= dto.getFee()%>" />
                    </td>
                    <td>
                        <input type="text" name="txtDescription" value="<%= dto.getDescription()%>" />
                    </td>
                    <td>
                        <input type="text" name="txtImg" value="<%= dto.getImg()%>" />
                    </td>
                    <td>
                        <input type="date" name="txtStartDate" required pattern="\d{4}-\d{2}-\d{2}" value="<%= dto.getStartDate()%>" />
                    </td>
                    <td>
                        <input type="date" name="txtEndDate" required pattern="\d{4}-\d{2}-\d{2}" value="<%= dto.getEndDate()%>" />
                    </td>
                    <td>
                        <input type="text" name="txtStatus" required pattern="[01]" value="<%= dto.getStatus()%>"/>
                    </td>
                    <td>
                        <input type="hidden" name="txtsearch" value="<%= searchValue%>" />
                        <input type="hidden" name="searchby" value="<%= searchBy%>" />
                        <input type="submit" value="Update" name="option"/>
                    </td>
                </tr>    
            </form>
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

