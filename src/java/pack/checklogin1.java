/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pack;

import java.sql.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
@WebServlet(name = "checklogin1", urlPatterns = {"/checklogin1"})
public class checklogin1 extends HttpServlet {

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
        HttpSession s=request.getSession();
        
        String l=request.getParameter("text1");
          String p=request.getParameter("text2");
          if(l.equals("admin") && p.equals("admin"))
          {
              response.sendRedirect("Welcomeadmin.jsp");
          }
          else
          {
              dbconnection obj=new dbconnection();
              try
              {
              ResultSet rs=obj.selectdata("select *from doctor where Login_id='"+ l +"' and Password='"+ p +"'");
               if(rs.next())
               {
                   s.setAttribute("id", rs.getString("Doctor_id"));
                   response.sendRedirect("doctorwelcome.jsp");
               }
               else
               {
                  ResultSet rs1=obj.selectdata("select *from patient where Login_id='"+ l +"' and Password='"+ p +"'");
                   if(rs1.next())
                   {
                     s.setAttribute("p", rs1.getString("P_id"));   
                    response.sendRedirect("patientwelcome.jsp");
                   }
                   else
                   {
                  response.sendRedirect("Logout.jsp");
                   }
               }
              }
              catch(Exception ex)
              {
                  
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
