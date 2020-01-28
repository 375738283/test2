package com.qh.im.api;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.qh.common.utils.ParamUtil;
import com.qh.common.utils.R;
import com.qh.common.utils.RandomTool;
import com.qh.common.utils.RequestUtils;
import com.qh.im.api.vo.UserVo;
import com.qh.im.yunxing.UserUtil;
import com.qh.redis.service.RedisUtil;
import com.qh.sms.uewang.ImSms;

@RestController
@RequestMapping("/api/message")
public class MessageApi {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MessageApi.class);
	
    @PostMapping("/send")
    public Object send(HttpServletRequest request){
    	R r=	commDataCheck(request);
    	if(R.ifSucc(r)){
    		try {
    			String mobile=r.get("mobile").toString();
    			Integer type=Integer.parseInt(r.get("type").toString());
    			String code=RedisUtil.getMessage(type, mobile);
    			if(StringUtils.isEmpty(code)) {
    				code=RandomTool.random(4);
    			}else
    				return R.error("请10分钟后在获取");
    			boolean b=false;
    			switch (type) {
				case 1:
						b=ImSms.sendRegister(mobile, code);//1为注册验证码
					break;
				default:
					break;
				}
    			
    			if(b) {
    				RedisUtil.setMessage(type, mobile, code);
    				return R.error("短信发送成功");
    			}else
    				return R.error("短信发送失败");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return R.error("短信发送失败"); 
			}
    		
    		
    	}else{
    		return r;
    	}
    }
    
    
    /**
   	 * @Description 通用检查方法
   	 * @param request
   	 * @return
   	 */
   	private R commDataCheck(HttpServletRequest request) {
   		
   		JSONObject jsonObject =  RequestUtils.getJsonResultStream(request);
       	if(jsonObject == null){
       		logger.error("请检查请求参数！");
       		return R.error("请检查请求参数！");
       	}
       	logger.debug("请求数据：{}",jsonObject.toString());
       	String mobile = jsonObject.getString("mobile");
       	if(ParamUtil.isEmpty(mobile)){
       		logger.error("mobile不能为空！");
       		return R.error("mobile不能为空！");
       	}
    	String type = jsonObject.getString("type");
       	if(ParamUtil.isEmpty(type)){
       		logger.error("type不能为空！");
       		return R.error("type不能为空！");
       	}
       	return R.ok().put("mobile", mobile).put("type", type);
      // 	String ip =IPUtils.getIpAddr(request);
   	}
   	
}
