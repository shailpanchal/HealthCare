/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pack;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author Dell
 */
@WebServlet(name = "addregistrationdetail", urlPatterns = {"/addregistrationdetail"})
public class addregistrationdetail extends HttpServlet {

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
        
      String fname="";
       int cid=0;
      String lname="";
      String hname="";
      String add="";
      String ph="";
      String email="";
      String web="";
        int did=0;
      String lid="";
      String pass="";
      String pic="";
       
      Sysdate obj=new Sysdate();
      String date=obj.getCurrDate();
       PrintWriter pw=response.getWriter();
     
        String dp = "Photo";
    String realPath,dpath="";
    int ind,ind1 ;
    
        realPath = getServletContext().getRealPath(dp);
        
        System.out.println("Real path : " + realPath);
       ind=realPath.indexOf("build");
         ind1=realPath.indexOf("web");
       realPath  = realPath.substring(0,ind)+realPath.substring(ind1);
        System.out.println("Real path : " + realPath);
    File destinationDir;
        
        destinationDir = new File(realPath);
        
          DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
         ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
      
          try
          {
            List items = upload.parseRequest(request);
            Iterator itr = items.iterator();
            while(itr.hasNext())
            {
                  FileItem item = (FileItem) itr.next();
             
                  if (item.isFormField())
                  {
                    if(item.getFieldName().equals("t1"))
                            {
                                fname=item.getString();
                            }
                    else if(item.getFieldName().equals("t2"))
                    {
                         lname=item.getString();
                    }
                    else if(item.getFieldName().equals("t3"))
                    {
                        add=item.getString();
                    }
                    else if(item.getFieldName().equals("t4"))
                    {
                        cid=Integer.parseInt(item.getString());
                    }
                     else if(item.getFieldName().equals("t5"))
                    {
                        web=item.getString();
                    }
                     else if(item.getFieldName().equals("t6"))
                    {
                        lid=item.getString();
                    }
                     else if(item.getFieldName().equals("t7"))
                    {
                       pass=item.getString();
                    }
                    
                    else if(item.getFieldName().equals("t8"))
                    {
                        email=item.getString();
                    }
                    
                    else if(item.getFieldName().equals("t9"))
                    {
                        ph=item.getString();
                    }
                    
                   
                    else if(item.getFieldName().equals("t10"))
                    {
                        pic=item.getString();
                    }
                    else if(item.getFieldName().equals("t11"))
                    {
                       hname=item.getString();
                    }
                    else if(item.getFieldName().equals("t12"))
                    {
                      did=Integer.parseInt(item.getString());
                    }
                    
                   } 
                  else
                  {
                 
                    File file = new File(destinationDir, item.getName());
                    item.write(file);
                    dpath="Photo/"+item.getName();
                }
                
            }
          }
          catch(Exception ex)
          {
              System.out.println(ex.toString());
          }
    

        dbconnection cobj=new dbconnection();
     
      
       
        cobj.modify("insert into doctor(First_Name,Last_Name,Address,City_id,Phone,Email,Web,Login_id,Password,R_date,Profile_pic,Hospital_name,Category_id) values('"+ fname +"','"+ lname +"','"+ add +"','"+ cid +"','"+ ph +"','"+ email +"','"+ web +"','"+ lid +"','"+ pass +"','"+ date +"','"+ dpath +"','"+ hname +"','"+ did +"')");
        response.sendRedirect("Registration.jsp");
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
