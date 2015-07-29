package com.lcq.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class PrimitiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(PrimitiveServlet.class);

	public PrimitiveServlet() {
		super();
		logger.info(this.getServletName() + "初始化");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("----------call init method----------");
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
