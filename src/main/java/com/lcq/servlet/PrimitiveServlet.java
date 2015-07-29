package com.lcq.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimitiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrimitiveServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
