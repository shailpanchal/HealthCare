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
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Dell
 */
@WebServlet(name = "AddPhoto", urlPatterns = {"/AddPhoto"})
public class AddPhoto extends HttpServlet {

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
        
        
        String pic="";
        String dp = "Gallery";
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
                      if(item.getFieldName().equals("f1"))
                    {
                        pic=item.getString();
                    }
                  }
                   else   
                  {
                    File file = new File(destinationDir, item.getName());
                    item.write(file);
                    dpath="Gallery/"+item.getName();
                }
                
            }
          }
          catch(Exception ex)
          {
              System.out.println(ex.toString());
          }
    

        dbconnection cobj=new dbconnection();
     
      
       HttpSession h=request.getSession();
       String Docid =h.getAttribute("id").toString();
       
        cobj.modify("insert into gallery(Doctor_id,Photo) values('"+ Docid +"','"+ dpath +"')");
        response.sendRedirect("Gallery.jsp");
    
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
