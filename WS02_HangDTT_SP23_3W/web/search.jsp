<%-- 
    Document   : search
    Created on : Apr 19, 2023, 7:45:29 AM
    Author     : LENOVO
--%>

<%@page import="java.util.List"%>
<%@page import="hang.registration.RegistrationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <font color="red">
        <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                String username = "";
                for (Cookie cookie : cookies) {
                    String temp = cookie.getName();
                    if (!temp.equals("JSESSIONID")) {
                        username = temp;
                    }
                }
        %>
        Welcome, <%= username%>
        <%
            }
        %>
        </font>
        <h1>Search Page</h1>
        <form action="MainController" >
            Search Value: <input type="text" name="txtSearchValue" value="" />
            <input type="submit" value="Search" name="btAction" />
            <input type="reset" value="Reset" /><br/>           
        </form>
        <br/>
        <%
            String searchValue = request.getParameter("txtSearchValue");
            if (searchValue != null) {
                List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");
                if (result != null) {
                    %>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Lastname</th>
                                <th>Role</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int count = 0;
                                for (RegistrationDTO dto : result) {
                                    String urlRewrtring = "MainController?txtUsername=" + dto.getUsername() + "&txtSearchValue=" + searchValue + "&btAction=Delete";
                                    %>
                        <form action="MainController">
                            <tr>
                                <td><%= ++count %></td>
                                <td><%= dto.getUsername() %>
                                    <input type="hidden" name="txtUsername" value="<%= dto.getUsername()  %>" />
                                </td>
                                <td><input type="text" name="txtPassword" value="<%= dto.getPassword()  %>" /></td>
                                <td><input type="text" name="txtLastname" value="<%= dto.getLastname()  %>" /></td>                            
                                <%
                                    if (dto.isRole()) {
                                        %>
                                <td><input type="checkbox" name="isAdmin" value="ON" checked="checked"/></td>
                                        <%
                                    }/*if isRole*/ 
                                    else {
                                        %>
                                <td><input type="checkbox" name="isAdmin" value="ON"/></td>
                                        <%
                                    }//else
                                %>
                                <td>
                                    <input type="hidden" name="txtSearchValue" value="<%= searchValue %>" />
                                    <input type="submit" value="Update" name="btAction"/>
                                </td>
                                <td><a href="<%= urlRewrtring %>">Delete</a></td>
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
