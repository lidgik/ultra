package com.bodejidi;

import com.bodejidi.DispatchServlet;
import com.bodejidi.unit.TestCase;

public class DispatchServletTest extends TestCase {

    DispatchServlet dispatchServlet = new DispatchServlet();

    public void test_getActionClassNameFromUri() {
        assertEquals("com.bodejidi.ContactAction", dispatchServlet.getActionClassNameFromUri("/contact/list"));
    }

    public void test_getMethodNameFromUri() {
        assertEquals("list", dispatchServlet.getMethodNameFromUri("/contact/list"));
    }

    public void test_getMethodNameFromUri_default_index() {
        assertEquals("index", dispatchServlet.getMethodNameFromUri("/contact"));
    }

    public void test_getViewPage() {
        assertEquals("/WEB-INF/jsp/contact/show.jsp", dispatchServlet.getViewPage("/contact/show"));
    }
}
