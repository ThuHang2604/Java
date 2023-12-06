/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hang.servlet;

import hang.registration.RegistrationDAO;
import hang.registration.RegistrationInsertError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class CreateAccountController extends HttpServlet {
    private final String LOGINPAGE = "index.html";
    private final String ERROR = "createNewAccount.jsp";

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
        RegistrationInsertError errors = new RegistrationInsertError();
        boolean chkError = false;
        String url = ERROR;
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");
        try {
            if (username.trim().length() < 6 || username.trim().length() > 20) {
                errors.setUsernameLengthErr("Username requires 6 - 20 chars");
                chkError = true;
            }
            if (password.trim().length() < 6 || password.trim().length() > 20) {
                errors.setPasswordLengthErr("Password requires 6 - 20 chars");
                chkError = true;
            } else if (!confirm.equals(password)) {
                errors.setConfirmNotMatch("Confirm and passowrd not the same");
                chkError = true;
            }
            if (fullname.trim().length() < 2 || fullname.trim().length() > 50) {
                errors.setFullNameLengthErr("Name requires 2 - 50 chars");
                chkError = true;
            }
            if (chkError) {
                request.setAttribute("INSERTERR", errors);
            } else {
                RegistrationDAO dao = new RegistrationDAO();
                boolean result = dao.insert(username, password, fullname, true);
                if (result) {
                    url = LOGINPAGE;
                }
            }           
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            log("CreateAccountServlet _ SQL :" + ex.getMessage());
            errors.setUsernameIsExisted("This username has existed");
            request.setAttribute("INSERTERR", errors);
//            ex.printStackTrace();
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
