package com.tcm.encoding;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;

/**
 * Created by Administrator on 16-5-1.
 */
public class xmlEncoding {
    public static void main(String[] args) throws IOException {
        //Create a xml file "àèìòù€"
        String xmlSample = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<specialchars>àèìòù€</specialchars>";

        FileOutputStream fos = new FileOutputStream("test.xml");
        //write the file with a wrong encoding
        fos.write(xmlSample.getBytes("ISO8859-15"));

        FileInputStream fis = new FileInputStream("test.xml");
        //read the file with the encoding declared in the xml header
        InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");

        char[] cbuf = new char[xmlSample.length()];
        inputStreamReader.read(cbuf);
        System.out.println("file read with UTF-8=" + new String(cbuf));
        //prints
        //file read with UTF-8=<?xml version="1.0" encoding="UTF-8"?>
        //<specialchars>������</specialchars>

        File xmlFile = new File("test.xml");
        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            //throws  com.sun.org.apache.xerces.internal.impl.io.MalformedByteSequenceException: Invalid byte 2 of 3-byte UTF-8 sequence
            //The exception occurs because you are reading a three bytes char of a UTF-8 sequence and the second byte has an invalid value (because of the UTF-8 way of encoding chars).
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }



}
