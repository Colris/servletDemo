package com.lcq.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;

import com.lcq.constant.Constants;

public class HttpResponse implements ServletResponse {

	private static final int BUFFER_SIZE=1024;
	HttpRequest request;
	OutputStream out;
	PrintWriter writer;
	
	public HttpResponse(OutputStream out) {
		super();
		this.out = out;
	}

	public void setRequest(HttpRequest request){
		this.request=request;
	}
	public void sendStaticResource() throws IOException{
		byte[]bytes=new byte[BUFFER_SIZE];
		FileInputStream fis=null;
		
		try {
			File file=new File(Constants.WEB_ROOT,request.getUri());
			fis=new FileInputStream(file);
			int ch=fis.read(bytes);
			while(ch!=-1){
				out.write(bytes,0,ch);
				ch=fis.read(bytes,0, BUFFER_SIZE);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			String errorMessage="HTTP:1.1 404 File Not Found\r\n"+"Content-Type:text/html\r\n"
					+"Content-Length:23\r\n\r\n"+"<h1>File Not Found</h1>";
			out.write(errorMessage.getBytes());
		}finally{
			if(fis!=null)
				fis.close();
		}
		
	}
	public String getCharacterEncoding() {
		return null;
	}

	public String getContentType() {
		return null;
	}

	public ServletOutputStream getOutputStream() throws IOException {
		return null;
	}

	public PrintWriter getWriter() throws IOException {
		writer=new PrintWriter(out,true);
		return writer;
	}

	public void setCharacterEncoding(String charset) {

	}

	public void setContentLength(int len) {

	}

	public void setContentType(String type) {

	}

	public void setBufferSize(int size) {

	}

	public int getBufferSize() {
		return 0;
	}

	public void flushBuffer() throws IOException {

	}

	public void resetBuffer() {

	}

	public boolean isCommitted() {
		return false;
	}

	public void reset() {

	}

	public void setLocale(Locale loc) {

	}

	public Locale getLocale() {
		return null;
	}

	public void addCookie(Cookie cookie) {

	}

	public boolean containsHeader(String name) {
		return false;
	}

	public String encodeURL(String url) {
		return null;
	}

	public String encodeRedirectURL(String url) {
		return null;
	}

	public String encodeUrl(String url) {
		return null;
	}

	public String encodeRedirectUrl(String url) {
		return null;
	}

	public void sendError(int sc, String msg) throws IOException {

	}

	public void sendError(int sc) throws IOException {

	}

	public void sendRedirect(String location) throws IOException {

	}

	public void setDateHeader(String name, long date) {

	}

	public void addDateHeader(String name, long date) {

	}

	public void setHeader(String name, String value) {

	}

	public void addHeader(String name, String value) {

	}

	public void setIntHeader(String name, int value) {

	}

	public void addIntHeader(String name, int value) {

	}

	public void setStatus(int sc) {

	}

	public void setStatus(int sc, String sm) {

	}

}
