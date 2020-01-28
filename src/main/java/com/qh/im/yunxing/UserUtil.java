package com.qh.im.yunxing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.qh.common.utils.BeanMapperUtil;
import com.qh.common.utils.R;
import com.qh.im.api.vo.UserVo;

public class UserUtil {
	
	private static final  String appKey = "2852d1592987b52b253b4819ecf76cee";
	private static final  String appSecret = "094601a7f8f9";
	private static final  String nonce =  "12345";


	/**
	 * 注册
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
    public static R register(String mobile) throws Exception{
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "https://api.netease.im/nimserver/user/create.action";
        HttpPost httpPost = new HttpPost(url);

        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", mobile));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        // 打印执行结果
        String s=EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(s);
        JSONObject obj=JSONObject.parseObject(s);
        if(obj.getInteger("code")==200) {
        	UserVo userVo=BeanMapperUtil.map(obj.getJSONObject("info"), UserVo.class);
        	return R.okData(userVo);
        }else {
        	return R.error("注册失败!"+s);
        }
    }
    
    
    


	/**
	 * 刷新token
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
    public static R refreshToken(String mobile) throws Exception{
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "https://api.netease.im/nimserver/user/refreshToken.action";
        HttpPost httpPost = new HttpPost(url);

        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", mobile));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        // 打印执行结果
        String s=EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(s);
        JSONObject obj=JSONObject.parseObject(s);
        if(obj.getInteger("code")==200) {
        	UserVo userVo=BeanMapperUtil.map(obj.getJSONObject("info"), UserVo.class);
        	return R.okData(userVo);
        }else {
        	return R.error("刷新token失败!"+s);
        }
    }
    
    
    public static void main(String[] args) {
    	try {
			refreshToken("135376352311");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
    
    
    
}
