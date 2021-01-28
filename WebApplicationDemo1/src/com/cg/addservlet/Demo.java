package com.cg.addservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo extends HttpServlet{
	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException
    {
        PrintWriter out = res.getWriter();
        out.println("Hi<br/>");
        
      //Tomcat gives the object of servletcontext 
       ServletContext ctx = getServletContext();
        
       ctx.getInitParameter("Phone");
        
        
        String str= ctx.getInitParameter("Phone");
        out.println(str);

        
    }

}


