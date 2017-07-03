package com.g11n.model.encoding;

import java.io.UnsupportedEncodingException;

public class String2Bytes {

	public static void string2Byte(String str){
		byte[] bytes = str.getBytes();
		System.out.println("length is "+bytes.length);
		for(byte b:bytes){
			System.out.println(b);
		}
	}

	public static void string2Byte(String str, String charset) throws UnsupportedEncodingException {
		byte[] bytes = str.getBytes(charset);
		System.out.println("length is "+bytes.length);
		for(byte b:bytes){
			System.out.println(b);
		}
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		// normal Ascii characters
		String str="hello";
		string2Byte(str);
		System.out.println("-------------1-------------");

		// characters fall outside Ascii table
		str="€";
		string2Byte(str);
		System.out.println("-------------2-------------");
		string2Byte(str,"ISO8859-15");
		System.out.println("-------------3------------");
		string2Byte(str,"ISO8859-1");
		System.out.println("-------------4------------");
		string2Byte(str,"UTF-8");

		// unicode / GBK
		str="a中文";
		string2Byte(str);
		System.out.println("-------------5-------------");
		string2Byte(str,"GBK");
		System.out.println("-------------6------------");
		string2Byte(str,"ISO8859-1");
		System.out.println("-------------7------------");
		string2Byte(str,"UTF-8");
	}
}
