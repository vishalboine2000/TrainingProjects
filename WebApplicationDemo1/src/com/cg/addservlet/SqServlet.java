package com.cg.addservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SqServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		//int i=Integer.parseInt(request.getParameter("k"));
		
		HttpSession session =request.getSession();
		 int x=(int) session.getAttribute("k");
		PrintWriter out = response.getWriter();
	     out.println("this is a square servlet "+x );
	}

}
