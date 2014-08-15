package com.bodejidi;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionContextImpl implements ActionContext {

    final ServletContext servletContext;
    final HttpServletRequest request;
    final HttpServletResponse response;

    public ActionContextImpl() {
        this(null, null, null);
    }

    public ActionContextImpl(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) {
        this.servletContext = servletContext;
        this.request = request;
        this.response = response;
    }

    public PrintWriter getOut() throws IOException {
        return response.getWriter();
    }
}
