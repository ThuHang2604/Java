/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class MainController extends HttpServlet {
    private static final String ERROR = "error.html";
    private final static String LOGIN = "loginServlet";
    private final static String LOGOUT = "logoutServlet";
    private final static String SEARCH = "searchServlet";
    private final static String SEARCHUPDATE = "searchUpdateServlet";
    private final static String UPDATE = "updateServlet";
    private final static String CREATE = "createServlet";
    private final static String BOOKING = "bookingServlet"; //add to cart


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = ERROR;
            String op = request.getParameter("option");
            try {
                switch (op) {
                    case "Login": 
                        url = LOGIN;
                        break;
                    case "Logout": 
                        url = LOGOUT;
                        break;
                    case "Search": 
                        url = SEARCH;
                        break;
                    case "SearchUpdate": 
                        url = SEARCHUPDATE;
                        break;
                    case "Update": 
                        url = UPDATE;
                        break;
                    case "Create": 
                        url = CREATE;
                        break;  
                    case "Booking":
                        url = BOOKING;
                        break;
                }
            } catch (Exception e) {
                log("Error at MainController: " + e.toString());
            } finally {
                request.getRequestDispatcher(url).forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
