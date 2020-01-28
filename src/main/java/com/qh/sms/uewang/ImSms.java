package com.qh.sms.uewang;

import com.qh.sms.uewang.interfacej.SmsTools;

public class ImSms {
	private static final String template_register="注册验证码：#code 【趣聊】";
	public static boolean sendRegister(String mobile,String code) {
		String content= template_register.replace("#code", code);
		return SmsTools.send(mobile, content);
	}
}
