package com.g11n.model.encoding;

import java.io.*;
import java.util.Locale;

public class Byte2String {

	public static void byte2String(byte[] bytes){
		String str = new String(bytes);
		System.out.println(str);
	}

	public static void byte2String(byte[] bytes, String charset) throws UnsupportedEncodingException {
		String str = new String(bytes,charset);
		System.out.println(str);
	}
	
	public static void main(String[] args) throws IOException {
		// normal Ascii characters
		byte[] bytesAscii = new byte[]{104,101,108,108,111};
		byte2String(bytesAscii);
		byte2String(bytesAscii,"UTF-8");
		// characters fall outside Ascii table
		byte[] bytesExtended = new byte[]{104,101,108,108,111,32,126,127,(byte)128,(byte)164};
		byte2String(bytesExtended);
		byte2String(bytesExtended,"ISO8859-15");
		byte2String(bytesExtended,"ISO8859-1");
		byte2String(bytesExtended,"UTF-8");
	}
}
