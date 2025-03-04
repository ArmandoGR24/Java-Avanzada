package com.codigomaestro.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class MyFirstTag extends TagSupport {
    private static int visitCount = 0;

    @Override
    public int doStartTag() throws JspException {
        visitCount++;
        try {
            pageContext.getOut().print("Welcome! You are visitor number: " + visitCount);
        } catch (IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }
}