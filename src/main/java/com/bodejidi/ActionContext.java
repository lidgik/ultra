package com.bodejidi;

import java.io.PrintWriter;
import java.io.IOException;

public interface ActionContext {
    public PrintWriter getOut() throws IOException;
}
