package com.qh.sms.uewang.interfacej;

public class SmsTools {

	public static String url = "http://www.uehyt.com/sms.aspx";
	public static String userid = "1573";
	public static String account = "18681552664";
	public static String password = "123456";
	public static String mobile = "18620351338";
	public static String content = "验证码：888888 【优易网】";
	
	public static boolean send(String mobile,String content) {
		String send = SmsClientSend.sendSms(url, userid, account, password, mobile, content);
		if(send.contains("<message>ok</message>")) {
			return true;
		}else return false;
		
	}

	/**
	 * <?xml version="1.0" encoding="utf-8" ?><returnsms>
 <returnstatus>Success</returnstatus>
 <message>ok</message>
 <remainpoint>999</remainpoint>
 <taskID>6197487</taskID>
 <successCounts>1</successCounts></returnsms>
	 */
	public static void send() {
		String send = SmsClientSend.sendSms(url, userid, account, password, mobile, content);
		System.out.println(send);
	}
	
	public static void overage() {
		String overage = SmsClientOverage.queryOverage(url, userid, account,
				password);
		System.out.println(overage);
	}
	
	
	public static void main(String[] args) {
		boolean b=send(mobile,content);
		System.out.println(b);
	}
}
