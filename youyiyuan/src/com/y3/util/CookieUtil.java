package com.y3.util;

import javax.servlet.http.Cookie;

/**
 * �鿴���ʼ�¼�Ĺ�����
 * @author Entity-G
 *
 */
public class CookieUtil {

	public static Cookie getCookieByName(String name,Cookie[] cookies) {
		//�������飬�������cookie�򷵻أ����򷵻�null
		for(Cookie cookie:cookies) {
			return cookie;
		}
		return null;
	}
	
}
