/**
 * Created by Administrator on 16-5-11.
 */
package com.g11n.xml;
public class XmlHandler {
    public static String getText(InputStream is){
        def xml = new XmlSlurper().parse(is)
        return xml.'string'
    }
}
