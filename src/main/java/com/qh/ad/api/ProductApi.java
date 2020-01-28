package com.qh.ad.api;

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
import com.qh.redis.service.RedisUtil;

/**
 * 产品对外api
 * @author my
 *
 */
@RestController
@RequestMapping("/api/app")
public class ProductApi {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductApi.class);
	@Autowired
	private ProductDownloadService productDownloadService;
    @PostMapping("/download")
    public Object download(HttpServletRequest request){
    	R r=	commDataCheck(request);
    	if(R.ifSucc(r)){
    		ProductDownloadDO productDownloadDO= (ProductDownloadDO)r.getData();
    		 productDownloadService.save(productDownloadDO);
    		 R.ok();
    	}else{
    		return r;
    	}
    	return R.ok();
    }
    
    
    /**
   	 * @Description 通用检查方法
   	 * @param request
   	 * @return
   	 */
   	private R commDataCheck(HttpServletRequest request) {
   		ProductDownloadDO productDownloadDO=new ProductDownloadDO();
   		JSONObject jsonObject =  RequestUtils.getJsonResultStream(request);
       	if(jsonObject == null){
       		logger.error("请检查请求参数！");
       		return R.error("请检查请求参数！");
       	}
       	logger.debug("请求数据：{}",jsonObject.toString());
       	String productId = jsonObject.getString("productId");
       	if(ParamUtil.isEmpty(productId)){
       		logger.error("productId不能为空！");
       		return R.error("productId不能为空！");
       	}
    	Long proId=null;
       	try {
       		 proId=Long.parseLong(productId);
		} catch (NumberFormatException e) {
			logger.error("productId信息异常！");
      		return R.error("productId信息异常！");
		}
        if(RedisUtil.getaProduct(proId)==null) {
        	logger.error("productId信息异常！");
      		return R.error("productId信息异常！");
        }
        productDownloadDO.setProductId(proId);
       	String marketId = jsonObject.getString("marketId");
    	if(ParamUtil.isNotEmpty(marketId)){
    		Long mktId=null;
       		try {
       			mktId=Long.parseLong(marketId);
			} catch (NumberFormatException e) {
			}
       		productDownloadDO.setMarketId(mktId);
       	}
       	String phone = jsonObject.getString("phone");
       	if(ParamUtil.isNotEmpty(phone)){
       		productDownloadDO.setPhone(phone);
       	}
       	String deviceName = jsonObject.getString("deviceName");
       	if(ParamUtil.isNotEmpty(deviceName)){
       		productDownloadDO.setDeviceName(deviceName);
       	}
       	String ip =IPUtils.getIpAddr(request);
       	productDownloadDO.setIp(ip);
        return R.okData(productDownloadDO);
   	}
	
}
