package com.g11n.model.encoding;

import java.util.Iterator;
import java.util.Locale;
import java.util.stream.IntStream;
import java.lang.*;

public class StringHandler {

    public static String upper2lower(String source, Locale locale){
        String target=source.toLowerCase(locale);
        return target;
    }


    public static void main(String[] args){
        String lang="tr-tr"; //"tr-tr"；
        Locale locale=new Locale(lang);
        String s="İ";//"İ";//"i̇";
        String upper="A  B  C  Ç  D  E  F  G  Ğ  H  J  K  L  M  N  O  Ö  P  R  S  Ş  T  U  Ü  V  Y  Z  Iİ1";
        String lower="a  b  c  ç  d  e  f  g  ğ  h  j  k  l  m  n  o  ö  p  r  s  ş  t  u  ü  v  y  z  ıi1";
        String ss=s.toLowerCase(locale);
        System.out.println(ss);
       System.out.println(ss.length());
        System.out.println(lower);
        System.out.println(lower.length());
        System.out.println(System.getProperty("file.encoding"));
        char offset='İ';
        int i1=offset>>5;
        int i2=(offset>>1)&0xF;
        int i3=offset&0x1;
        System.out.println("i1 is:"+i1);
        int i = test.getProperties (304);//A[Y[X[offset>>5]|((offset>>1)&0xF)]|(offset&0x1)];
        char x = test.X[offset>>5];
        char y=test.Y[test.X[offset>>5]|((offset>>1)&0xF)];
        int a = test.A[test.Y[test.X[offset>>5]|((offset>>1)&0xF)]|(offset&0x1)];
        int st=a & 0x07FC0000;
        System.out.println((char) st);
        System.out.println(st);
        System.out.format("%x", st);
        //char c=A[Y[X[offset>>5]|((offset>>1)&0xF)]|(offset&0x1)];

    }
}

