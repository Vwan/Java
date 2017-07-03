package com.tks;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONReader;
import org.apache.struts2.json.JSONUtil;

/**
 * Created by wanjia on 16/10/22.
 */
public class Test {
    public static void main(String[] args) throws JSONException {
          String json="{\"entity\":{\"name\":\"test\",\"password\":\"ytd\"}";
        //  String json="{\"entity\":{\"name\":\"test\",\"password\":\"test\"}}";
       // Object obj = JSONUtil.deserialize(json);
        JSONReader reader = new JSONReader();
         reader.read(json);
    }
}
