package com.lcq.server;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.lcq.constant.Constants;
import com.lcq.http.Request;
import com.lcq.http.RequestFade;
import com.lcq.http.Response;
import com.lcq.http.ResponseFade;

public class ServletProccessor {
	@SuppressWarnings("rawtypes")
	public void proccess(Request request, Response response) {
		String uri = request.getUri();
		String servletName = uri.substring(uri.lastIndexOf("/") + 1);
		URLClassLoader ucloader = null;
		URL[] urls = new URL[1];
		URLStreamHandler streamHandler = null;
		File classPath = new File(Constants.WEB_ROOT);
		try {
			String repository = (new URL("file", null,
					classPath.getCanonicalPath() + File.separator)).toString();
			urls[0] = new URL(null, repository, streamHandler);
			ucloader = new URLClassLoader(urls);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		Class myClass = null;
		try {
			myClass = ucloader.loadClass(servletName);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		Servlet servlet = null;
		RequestFade requestFade=new RequestFade(request);
		ResponseFade responseFade=new ResponseFade(response);
		try {
			servlet = (Servlet) myClass.newInstance();
			servlet.service((ServletRequest) requestFade,
					(ServletResponse) responseFade);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
