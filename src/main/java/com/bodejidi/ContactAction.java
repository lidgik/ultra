package com.bodejidi;

import java.util.Map;
import java.util.HashMap;

public class ContactAction extends Action {

    public ContactAction(ActionContext actionContext) {
        super(actionContext);
    }

    public Map<String, Object> show() {
        return new HashMap<String, Object>();
    }

    public void index() {
        println("index");
    }
}
