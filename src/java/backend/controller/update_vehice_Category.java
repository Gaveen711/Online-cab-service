/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.controller;

import dao.vehicleCategory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "update_vehice_Category", urlPatterns = {"/update_vehice_Category"})
public class update_vehice_Category extends HttpServlet {

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
             String id =  request.getParameter("id");
             String categoryName =  request.getParameter("categoryName");
             String imageURl =  request.getParameter("imageURl");
             String InitialPayment =  request.getParameter("InitialPayment");
             String InitialPrice =  request.getParameter("InitialPrice");
             String ExtraPrice =  request.getParameter("ExtraPrice");
             
             if(updateVehicleCategory(categoryName,imageURl,id,InitialPayment,InitialPrice,ExtraPrice)){
                out.println(1);
        
             }else{
                out.println(0); 
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

    private boolean updateVehicleCategory(String categoryName, String imageURl, String id, String InitialPayment, String InitialPrice, String ExtraPrice) {
         ArrayList<Object> list=new ArrayList<>();
         list.add(categoryName);
         list.add(imageURl);
         list.add(InitialPayment);
         list.add(InitialPrice);
         list.add(ExtraPrice);
         list.add(id);
         boolean isAdded = new vehicleCategory().updateVehicleCategory(list);
         return isAdded;
    }

}
