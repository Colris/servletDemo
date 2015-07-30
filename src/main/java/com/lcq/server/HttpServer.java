package com.lcq.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

import com.lcq.http.Request;
import com.lcq.http.Response;

public class HttpServer {
	private static final String SHUTDOWN_COMMAND="/SHUTDOWN";
	private boolean shutdown=false;
	
	public static void main(String[] args) {
		HttpServer server=new HttpServer();
		server.await();
	}
	
	public void await(){
		ServerSocket serverSocket=null;
		int port=8080;
		String host="localhost";
		try {
			serverSocket=new ServerSocket(port);
			Inet4Address.getByName(host);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		while(!shutdown){
			Socket socket=null;
			InputStream input=null;
			OutputStream out=null;
			try {
				socket=serverSocket.accept();
				input=socket.getInputStream();
				out=socket.getOutputStream();
				Request request=new Request(input);
				request.parse();
				
				Response response=new Response(out);
				response.setRequest(request);
				
				if(request.getUri().startsWith("/servlet")){
					ServletProccessor proccesor=new ServletProccessor();
					proccesor.proccess(request,response);
				}else{
					StaticResourceProccessor proccessor=new StaticResourceProccessor();
					proccessor.proccess(request,response);
				}
				socket.close();
				shutdown=request.getUri().equals(SHUTDOWN_COMMAND);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
