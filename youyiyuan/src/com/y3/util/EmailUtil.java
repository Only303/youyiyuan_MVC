package com.y3.util;

import java.util.Random;

import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {
	public int sendEmail(String emailaddress) {
		try {
			Random random = new Random();
			int code = random.nextInt(9000) + 1000;
			HtmlEmail email = new HtmlEmail();// ���ø���
			email.setHostName("smtp.qq.com");// ��Ҫ�޸ģ�126����Ϊsmtp.126.com,163����Ϊ163.smtp.com��QQΪsmtp.qq.com
			email.setCharset("UTF-8");
			email.addTo(emailaddress);// �ռ���ַ

			email.setFrom("1690014753@qq.com", "MageShop����Ա");// �˴��������ַ���û���,�û�������������д

			email.setAuthentication("1690014753@qq.com", "bzqaboqcccmyfdeb");// �˴���д�����ַ�Ϳͻ�����Ȩ��

			email.setSubject("MegaShop");// �˴���д�ʼ������ʼ�����������д
			email.setMsg("�𾴵��û�����,������ע�����֤����:" + code);// �˴���д�ʼ�����

			email.send();
			return code;
		} catch (Exception e) {
			return 0;
		}
	}
}
