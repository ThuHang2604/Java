<%-- 
    Document   : viewCart
    Created on : Apr 19, 2023, 7:26:02 AM
    Author     : LENOVO
--%>

<%@page import="java.util.Map"%>
<%@page import="hang.registration.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>   
        <h1>Your Cart</h1>
        <%
            if( session != null) {
               CartObj cart = (CartObj) session.getAttribute("CART");
               if (cart != null) {
                   if (cart.getItems() != null) {
                       %>
                       <table border="1">
                           <thead>
                               <tr>
                                   <th>No.</th>
                                   <th>Title</th>
                                   <th>Quantity</th>
                                   <th>Action</th>
                               </tr>
                           </thead>
                           <tbody>
                           <form action="MainController">
                               <%
                                   Map<String, Integer> items = cart.getItems();
                                   int count = 0;
                                   for (Map.Entry item : items.entrySet()) {
                                       %>
                                       <tr>
                                           <td><%= ++count %></td>
                                           <td><%= item.getKey() %></td>
                                           <td><%= item.getValue() %></td>
                                           <td><input type="checkbox" name="chkItem" value="<%= item.getKey()%>" /></td>
                                       </tr>
                                       <%
                                   }//for
                               %>
                               <tr>
                                   <td colspan="3"><a href="bookStore.html">Add more Item to Your Cart</a></td>
                                   <td><input type="submit" name="btAction" value="Remove Select Item" /></td>
                               </tr>
                           </form>                               
                           </tbody>
                       </table>                     
                        <%
                            return;
                   }//if 3                    
               }//if 2
            }//if 1
        %>
        <h2>No cart is existed.</h2>
    </body>
</html>

