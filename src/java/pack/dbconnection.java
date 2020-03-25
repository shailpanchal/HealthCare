/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pack;
import java.sql.*;
/**
 *
 * @author Dell
 */
public class dbconnection {
    
   public void modify(String q)
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/health_care","root","root");
       Statement st=con.createStatement();
       st.execute(q);
       st.close();
       con.close();
        }
        catch(Exception ex)
        {
            
        }
     }
    
   public ResultSet selectdata(String q)
    {
        ResultSet rs=null;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/health_care","root","root");
       Statement st=con.createStatement();
      rs= st.executeQuery(q);
        }
        catch(Exception ex)
        {
            
        }
       return rs;
        
     }
    
    
    
}
