package com.dxc.custom;
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CustomAddress extends TagSupport {

	public CustomAddress() {
		// TODO Auto-generated constructor stub
	}
	
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		

		try {
			out.println("<h1>DXC Technology");
			out.println("DGS-Campus Phase-1, <br>\r\n" + 
						"HP Avenue 39/40, <br>\r\n" +
						"Hosur Road,");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}

}
