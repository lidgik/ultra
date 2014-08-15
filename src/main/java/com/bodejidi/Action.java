package com.bodejidi;

import java.io.PrintWriter;
import java.io.IOException;

public abstract class Action {

    final ActionContext actionContext;

    public Action(ActionContext actionContext) {
        this.actionContext = actionContext;
    }

    public void println(String str) {
        try {
            actionContext.getOut().println(str);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
