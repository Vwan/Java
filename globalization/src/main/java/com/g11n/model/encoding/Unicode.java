package com.g11n.model.encoding;

import java.io.*;
import java.util.Locale;

/**
 * Created by Administrator on 16-5-2.
 */
public class Unicode {
    /* static void main(String[] args) throws IOException {
        char c = '汉';
        System.out.println((int)c);
        System.out.format("%x",(int)c);
        System.out.format(new Locale("tr-tr"),"%x",(int)c); // why ok?


        char h=0x6c49;
        System.out.println(h);

        String filename="d:\\temp\\han.txt";
        if(!new File(filename).exists()){
            new File(filename).createNewFile();
        }

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream(filename),"utf-8"));
        pw.write(h);
        pw.close();

        //high surrogate: d87e, low surrogate: dc1a
        String s = String.valueOf(Character.toChars(0x2f81a));
        char[] cc = s.toCharArray();
        for(char c1: cc) {
            System.out.format("%x",(short)c1);
        }

        String encoding = System.getProperty("file.encoding");
        System.out.println(encoding); // expecting GBK, but why not GBK on my chinese machine?
    }
    */
}
