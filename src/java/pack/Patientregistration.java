/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Dell
 */
@WebServlet(name = "Patientregistration", urlPatterns = {"/Patientregistration"})
public class Patientregistration extends HttpServlet {

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
        Sysdate obj1=new Sysdate();
      String date=obj1.getCurrDate();
        String fname=request.getParameter("p1");
        String add=request.getParameter("p2");
        int c=Integer.parseInt(request.getParameter("p3"));
        String ph=request.getParameter("p4");
        String e=request.getParameter("p5");
        String l=request.getParameter("p6");
        String pass=request.getParameter("p7");
        String gen=request.getParameter("p8");
        String dob=request.getParameter("p9");
        
        
        dbconnection obj=new dbconnection();
        obj.modify("insert into patient(Name,Address,City_id,Phone,Email,Login_id,Password,Gender,DOB,R_date) values('"+ fname +"','"+ add +"','"+ c +"','"+ ph +"','"+ e +"','"+ l +"','"+ pass +"','"+ gen +"','"+ dob +"','"+ date +"')");
        response.sendRedirect("Registration_patient.jsp");
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
