/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Import Database Connection Class File

import code.DatabaseConnection;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
@WebServlet(urlPatterns = {"/InsertData"})
public class InsertData extends HttpServlet {

    
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            Connection con = DatabaseConnection.initializeDatabase();
            
            PreparedStatement st = con.prepareStatement("insert into demo values(?,?)");
            
            st.setInt(1, Integer.valueOf(request.getParameter("id")));
            st.setString(2, request.getParameter("string"));
            
            st.executeUpdate();
            st.close();
            con.close();
            
            PrintWriter out = response.getWriter();
            
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<html><body><b>Successfully Inserted" + "</b></body></html>");
            
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
             System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
             System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}