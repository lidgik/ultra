package com.bodejidi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import java.util.Map;
import java.util.HashMap;

public class DispatchServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) 
        throws IOException, ServletException {

        try{
            String uri = getUri(request);
            response.getWriter().println(uri);
            ActionContext actionContext = new ActionContextImpl(getServletContext(), request, response);
            Class actionClass = Class.forName(getActionClassNameFromUri(uri));
            @SuppressWarnings("unchecked")
            Constructor actionConstructor = actionClass.getDeclaredConstructor(ActionContext.class);
            Action actionInstance = (Action) actionConstructor.newInstance(actionContext);
            @SuppressWarnings("unchecked")
            Method method = actionClass.getDeclaredMethod(getMethodNameFromUri(uri));
            Object returnValue = method.invoke(actionInstance);
            
            if(null != returnValue) {
                TemplateEngine templateEngine = new JspTemplateEngine(getServletContext(), request, response);
                templateEngine.merge(getViewPage(uri), returnValue);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    final String packageName = "com.bodejidi";

    public String getUri(HttpServletRequest request) {
        return request.getRequestURI().replace(request.getContextPath(), "");
    }

    public String getActionClassNameFromUri(String uri) {
        String[] uriParts = uri.split("/");
        String actionClassName = capitalize(uriParts[1]);
        return packageName + "." + actionClassName + "Action";
    }

    public String getMethodNameFromUri(String uri) {
        String[] uriParts = uri.split("/");
        if(uriParts.length <= 2)
            return "index";
        return uriParts[2];
    }

    public String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public String getViewPage(String uri) {
        return "/WEB-INF/jsp" + uri + ".jsp";
    }
}
