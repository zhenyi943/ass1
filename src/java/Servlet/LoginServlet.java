/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 797494
 */
public class LoginServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String logout = request.getParameter("logout");

        if (logout == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        } else {
 
            request.setAttribute("message", "You have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String user=request.getParameter("username");
        String password=request.getParameter("password");
        //read user.txt
        String path = getServletContext().getRealPath("/WEB-INF/users.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String[] firstLine;
        //Users from txt
        String cur_user= "";
        String n1ine = br.readLine();
        boolean error=false;
        while(n1ine !=null){
        firstLine = n1ine.trim().split(",");
        if(firstLine[0].equals(user) && firstLine[1].equals(password)){
            cur_user=firstLine[0];
            error=true;
        }
        n1ine=br.readLine();
        }
        br.close();
        if (error==false){
            request.setAttribute("message", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
        if (user.equals("admin")){
            String path2 = getServletContext().getRealPath("/WEB-INF/homeitems.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(new File(path2)));
            String line2 = br2.readLine();
            double adminTotal=0;
            double b=0;
            String who = "";
            String what = "";
            double how_much = 0;
            String[] ArayyLine;
            while (line2!=null){
                ArayyLine=line2.trim().split(",");
                adminTotal=Double.valueOf(ArayyLine[3].toString());
                adminTotal=adminTotal+b;
                b = adminTotal;
                 if (Double.valueOf(ArayyLine[3]) > how_much) {
                    how_much = Double.valueOf(ArayyLine[3]);
                    who = ArayyLine[0];
                    what = ArayyLine[2];
                }
                line2 = br2.readLine();
            }
            br2.close();
                  HttpSession session = request.getSession();
                  session.setAttribute("AdminMessage", adminTotal);
                  session.setAttribute("who", what+" at $"+how_much+" owned by "+who);
                  getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
            }
        else {
            String path2 = getServletContext().getRealPath("/WEB-INF/homeitems.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(new File(path)));
            String line2 = br2.readLine();
            double adminTotal = 0;
            double b=0;
            String[] ArayyLine;
            while ( line2!=null){
                 ArayyLine=line2.trim().split(",");
             if(ArayyLine[0].equals(cur_user)){
                 adminTotal=Double.valueOf(ArayyLine[3].toString());
                 adminTotal=adminTotal+b;
                 b=adminTotal;
                  }
            line2=br2.readLine();
             br2.close();
            HttpSession session = request.getSession();
            session.setAttribute("userinv", cur_user);
            session.setAttribute("total", adminTotal);
            getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
                
            }
        }    
        }
       
    }


}
