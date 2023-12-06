/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class MainController extends HttpServlet {
    private final String LOGINPAGE = "login.html";
    private final String LOGINCONTROLLER = "LoginController";
    private final String SEARCHCONTROLLER = "SearchController";
    private final String DELETECONTROLLER = "DeleteController";
    private final String UPDATECONTROLLER = "UpdateController";
    private final String ADDITEMCONTROLLER = "AddItemController";
    private final String VIEWYOURCART = "viewCart.jsp";
    private final String REMOVEITEMCONTROLLER = "RemoveItemController";
    private final String NULLCONTROLLER = "NullController";
    private final String CREATENEWACCOUNT = "CreateAccountController";

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
        PrintWriter out = response.getWriter();
        String button = request.getParameter("btAction");
        String url = LOGINPAGE;
        try {
            /* TODO output your page here. You may use following sample code. */
            if (button == null) {
                url = NULLCONTROLLER;
            } else if (button.equals("Login")) {
                url = LOGINCONTROLLER;
            } else if (button.equals("Search")) {
                url = SEARCHCONTROLLER;
            } else if (button.equals("Delete")) {
                url = DELETECONTROLLER;
            } else if (button.equals("Update")) {
                url = UPDATECONTROLLER;
            } else if (button.equals("Add Book To Your Cart")) {
                url = ADDITEMCONTROLLER;
            } else if (button.equals("View Your Cart")) {
                url = VIEWYOURCART;
            } else if (button.equals("Remove Select Item")) {
                url = REMOVEITEMCONTROLLER;
            } else if (button.equals("Register")) {
                url = CREATENEWACCOUNT;
            }           
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
