<%-- 
    Document   : createNewAccount
    Created on : Apr 20, 2023, 7:30:33 AM
    Author     : LENOVO
--%>

<%@page import="hang.registration.RegistrationInsertError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="MainController" method="post">
            Username* <input type="text" name="txtUsername" value="<%= request.getParameter("txtUsername")%>" />(6 - 20 chars)<br/>
            <font color="red">
            <%
                RegistrationInsertError errors = (RegistrationInsertError) request.getAttribute("INSERTERR");
                if (errors != null) {
                    if (errors.getUsernameLengthErr() != null) {
                        %>
                        <%= errors.getUsernameLengthErr()%><br/>
                        <%
                    }
                }
            %>
            </font>
            Password* <input type="password" name="txtPassword" value="" />(6 - 30 chars)<br/>
            <font color="red">
            <%
                if (errors != null) {
                    if (errors.getPasswordLengthErr() != null) {
                        %>
                        <%= errors.getPasswordLengthErr() %><br/>
                        <%
                    }
                }
            %>
            </font>
            Confirm* <input type="password" name="txtConfirm" value="" /><br/>
            <font color="red">
            <%
                if (errors != null) {
                    if (errors.getConfirmNotMatch() != null) {
                        %>
                        <%= errors.getConfirmNotMatch()%><br/>
                        <%
                    }
                }
            %>
            </font>
            Full name <input type="text" name="txtFullname" value="<%= request.getParameter("txtFullname")%>" />(2 - 50 chars)<br/>
            <font color="red">
            <%
                if (errors != null) {
                    if (errors.getFullNameLengthErr() != null) {
                        %>
                        <%= errors.getFullNameLengthErr() %><br/>
                        <%
                    }
                }
            %>
            </font>
            <input type="submit" value="Register" name="btAction" />
            <input type="reset" value="Reset" />
        </form><br/>
        <font color="red">
            <%
                if (errors != null) {
                    if (errors.getUsernameIsExisted() != null) {
                        %>
                        <%= errors.getUsernameIsExisted() %><br/>
                        <%
                    }
                }
            %>
        </font>
    </body>
</html>
