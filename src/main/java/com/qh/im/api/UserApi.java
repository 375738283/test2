package com.qh.im.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.qh.ad.domain.ProductDO;
import com.qh.ad.domain.ProductDownloadDO;
import com.qh.ad.service.ProductDownloadService;
import com.qh.common.utils.IPUtils;
import com.qh.common.utils.ParamUtil;
import com.qh.common.utils.R;
import com.qh.common.utils.RequestUtils;
import com.qh.im.api.vo.UserVo;
import com.qh.im.constenum.MessageType;
import com.qh.im.service.AppUserService;
import com.qh.im.yunxing.UserUtil;
import com.qh.redis.service.RedisUtil;

/**
 * 产品对外api
 * @author my
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserApi {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserApi.class);
	
	@Autowired
	AppUserService  appUserService;
	
    @PostMapping("/register")
    public Object register(HttpServletRequest request){
    	R r=	commDataCheck(request);
    	if(R.ifSucc(r)){
    		try {
    			String mobile=r.get("mobile").toString();
    			String password=r.get("password").toString();
    			R reg=appUserService.register(mobile, password);
    			return reg;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return R.error("注册失败"); 
			}
    		
    		
    	}else{
    		return r;
    	}
    }
    
    
    @PostMapping("/login")
    public Object login(HttpServletRequest request){
    	R r=	commLoginCheck(request);
    	if(R.ifSucc(r)){
    		try {
    			String mobile=r.get("mobile").toString();
    			String password=r.get("password").toString();
    		
    			R reg=appUserService.login(mobile, password);
    			return reg;
    			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return R.error("登陆异常"); 
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
      	String password = jsonObject.getString("password");
       	if(ParamUtil.isEmpty(password)){
       		logger.error("password不能为空！");
       		return R.error("password不能为空！");
       	}
       	String code = jsonObject.getString("code");
       	if(ParamUtil.isEmpty(code)){
       		logger.error("code不能为空！");
       		return R.error("code不能为空！");
       	}
       String code2=	RedisUtil.getMessage(MessageType.register.id(), mobile);
       if(!code.equals(code2)) {
    	   return R.error("手机验证码错误！");
       }
       return R.ok().put("mobile", mobile).put("password", password);
      //String ip =IPUtils.getIpAddr(request);
   	}
   	
   	
 	private R commLoginCheck(HttpServletRequest request) {
   		
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
      	String password = jsonObject.getString("password");
       	if(ParamUtil.isEmpty(password)){
       		logger.error("password不能为空！");
       		return R.error("password不能为空！");
       	}
       	return R.ok().put("mobile", mobile).put("password", password);
      // 	String ip =IPUtils.getIpAddr(request);
   	}
	
}
