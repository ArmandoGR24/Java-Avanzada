package com.codigomaestro.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class UpperCaseTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_INCLUDE;
    }
    @Override
    public int doEndTag() throws JspException {
        try {
            String bodyContent = pageContext.getOut().toString();
            pageContext.getOut().clear();
            pageContext.getOut().print(bodyContent.toUpperCase());
        } catch (IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }
        return EVAL_PAGE;
    }
}