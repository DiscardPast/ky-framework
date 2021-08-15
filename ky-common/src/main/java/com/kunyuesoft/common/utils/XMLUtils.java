package com.kunyuesoft.common.utils;

import java.util.Iterator;
import java.util.SortedMap;

public class XMLUtils {
    /**
     * map转xml格式
     * @param sortedMap
     * @return
     */
    public static String mapToXml(SortedMap<Object, Object> sortedMap) {
        StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?><request>");
        Iterator iterator = sortedMap.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = (String) iterator.next();
            Object value = sortedMap.get(key);
            sb.append("<" + key + ">");
            sb.append(value);
            sb.append("</" + key + ">");
        }
        sb.append("</request>");
        return sb.toString();
    }
    /**
     * map转xml格式  不加请求头
     * @param sortedMap
     * str   xml属性名
     * @return
     */
    public static String mapToXml(SortedMap<Object, Object> sortedMap,String str) {
    	StringBuffer sb = new StringBuffer("<"+str+">");
    	Iterator iterator = sortedMap.keySet().iterator();
    	while (iterator.hasNext()) {
    		Object key = (String) iterator.next();
    		Object value = sortedMap.get(key);
    		sb.append("<" + key + ">");
    		sb.append(value);
    		sb.append("</" + key + ">");
    	}
    	sb.append("</"+str+">");
    	return sb.toString();
    }
}
