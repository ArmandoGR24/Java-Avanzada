package com.codigomaestro.act6armandogr3069543;

import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import java.io.IOException;

public class MyTag extends SimpleTagSupport {
    private String message;
    private String name;

    public void setMessage(String msg) {
        this.message = msg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("<h1>" + message + " " + name + "</h1>");
    }
}
