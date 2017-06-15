package com.ljo.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by jb.liang on 2017/6/15.
 */
public class UMDateProject extends TagSupport {

    private String id;

    private String name;

    private String format;

    @Override
    public int doStartTag() throws JspException {
        StringBuilder content = new StringBuilder();
        content.append("<div class=\"input-append date\" id=\""+id+"\" data-date=\"\" data-date-format=\""+format+"\">");
        content.append("<input class=\"span2\" size=\"16\" type=\"text\">");
        content.append("<span class=\"add-on\"><i class=\"icon-calendar\"></i></span>");
        content.append("</div>");
        try {
            this.pageContext.getOut().print(content.toString());
            this.pageContext.getOut().print("<script>$('#"+id+"').datepicker();</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
