package com.y3.util;

import javax.servlet.http.Cookie;

/**
 * 查看访问记录的工具类
 * @author Entity-G
 *
 */
public class CookieUtil {

	public static Cookie getCookieByName(String name,Cookie[] cookies) {
		//遍历数组，如果存在cookie则返回，否则返回null
		for(Cookie cookie:cookies) {
			return cookie;
		}
		return null;
	}
	
}
