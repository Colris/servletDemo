package com.lcq.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;

/**
 * Created by changqing.liu on 2015/7/30.
 */
public class RequestFade implements ServletRequest{
    private ServletRequest request=null;

    public RequestFade(Request request) {
        this.request = request;
    }

    public Object getAttribute(String name) {
        return request.getAttribute(name);
    }

    @SuppressWarnings("rawtypes")
	public Enumeration getAttributeNames() {
        return request.getAttributeNames();
    }

    public String getCharacterEncoding() {
        return null;
    }

    
    public void setCharacterEncoding(String env) throws UnsupportedEncodingException {

    }

    
    public int getContentLength() {
        return 0;
    }

    
    public String getContentType() {
        return null;
    }

    
    public ServletInputStream getInputStream() throws IOException {
        return null;
    }

    
    public String getParameter(String name) {
        return null;
    }

    
    @SuppressWarnings("rawtypes")
	public Enumeration getParameterNames() {
        return null;
    }

    
    public String[] getParameterValues(String name) {
        return new String[0];
    }

    
    @SuppressWarnings("rawtypes")
	public Map getParameterMap() {
        return null;
    }

    
    public String getProtocol() {
        return null;
    }

    
    public String getScheme() {
        return null;
    }

    
    public String getServerName() {
        return null;
    }

    
    public int getServerPort() {
        return 0;
    }

    
    public BufferedReader getReader() throws IOException {
        return null;
    }

    
    public String getRemoteAddr() {
        return null;
    }

    
    public String getRemoteHost() {
        return null;
    }

    
    public void setAttribute(String name, Object o) {

    }

    
    public void removeAttribute(String name) {

    }

    
    public Locale getLocale() {
        return null;
    }

    
    @SuppressWarnings("rawtypes")
	public Enumeration getLocales() {
        return null;
    }

    
    public boolean isSecure() {
        return false;
    }

    
    public RequestDispatcher getRequestDispatcher(String path) {
        return null;
    }

    
    public String getRealPath(String path) {
        return null;
    }

    
    public int getRemotePort() {
        return 0;
    }

    
    public String getLocalName() {
        return null;
    }

    
    public String getLocalAddr() {
        return null;
    }

    
    public int getLocalPort() {
        return 0;
    }
}
