package com.qaitdevlab.ptpat.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class commonUtil {
	public static String getExceptionDescriptionString(Exception e) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		e.printStackTrace(printWriter);
		return stringWriter.toString();
	}

}
