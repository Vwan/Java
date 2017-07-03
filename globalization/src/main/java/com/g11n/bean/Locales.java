package com.g11n.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 16-5-2.
 */
public class Locales {
    private List<String> lang = new ArrayList<String>();

    public List<String> getLang() {
        Locale[] locale=Locale.getAvailableLocales();
        for (int i=1; i<=locale.length-1;i++){
            System.out.println(locale[i]);
            if(!lang.contains(locale[i])) {
                lang.add(locale[i].toString());
            }
        }
        Collections.sort(lang);
        return lang;
    }

    public void setLang(List<String> lang) {
        this.lang = lang;
    }

    public static void main(String[] args){
        List<String> list = new Locales().getLang();
        Collections.sort(list);
        for (String s: list){
            System.out.println(s);
        }

    }

}
