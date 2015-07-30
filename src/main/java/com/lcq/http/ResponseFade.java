package com.lcq.http;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * Created by changqing.liu on 2015/7/30.
 */
public class ResponseFade implements ServletResponse {
	private ServletResponse response = null;

	public ResponseFade(Response response) {
		this.response = response;
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
		return null;
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
}
