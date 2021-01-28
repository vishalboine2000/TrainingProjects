package com.cg.addservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		HttpSession session =req.getSession();
		int k;
		k=i+j;
		System.out.println(k);
		
        session.setAttribute("k", k);
		
		//RequestDispatcher rd = req.getRequestDispatcher("square");
		//rd.forward(req, res);
		
		PrintWriter out = res.getWriter();
        
        out.println("the result is " +k  );
        
        //res.sendRedirect("square?k="+k);
        res.sendRedirect("square");
	}

}
