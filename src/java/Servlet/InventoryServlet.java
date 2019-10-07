/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.HomeItem;

/**
 *
 * @author 797494
 */
public class InventoryServlet extends HttpServlet {

 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String itemname = request.getParameter("item");
        String price = request.getParameter("price");
        String category = request.getParameter("Category"); 
        String name = (String) session.getAttribute("userinv");
        
        String path = getServletContext().getRealPath("/WEB-INF/homeitems.txt");
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        double totalValue = 0;
        String read = br.readLine();
        while (read != null) {

            String[] list = read.split(",");
            if (list[0].equalsIgnoreCase(name)) {
                totalValue += Double.valueOf(list[3]);
            }
            read = br.readLine();
        }
        
        
      if(itemname == null || itemname.equals("") || price == null || price.equals("")){
            String a="Invaild: null input";
            request.setAttribute("message", a);
            getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
        }
      else {
           if(Double.valueOf(price.toString())>0 && Double.valueOf(price.toString())<10000){
           String line = name+","+category+","+itemname + ","+price+"\n";
           PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            pw.append(line);
            pw.close();
        request.setAttribute("message", "The item was succussfully added to your inventory.<br>");
        request.setAttribute("total", totalValue);
        getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp")
                .forward(request, response);
           
           }
           else {
               request.setAttribute("message", "Invaild: Price Invaild");
               getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
           }
      }
    }


}
