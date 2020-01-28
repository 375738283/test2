package com.qh.ad.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.qh.ad.api.vo.AdvertisementVo;
import com.qh.ad.api.vo.ProductVo;
import com.qh.ad.domain.AdvertisementDO;
import com.qh.ad.domain.AdvertisementShowDO;
import com.qh.ad.domain.PartnershipDO;
import com.qh.ad.domain.ProductAdvertisementDO;
import com.qh.ad.domain.ProductDO;
import com.qh.ad.domain.ProductDownloadDO;
import com.qh.ad.service.AdvertisementShowService;
import com.qh.ad.service.ProductDownloadService;
import com.qh.common.utils.BeanMapperUtil;
import com.qh.common.utils.IPUtils;
import com.qh.common.utils.ParamUtil;
import com.qh.common.utils.R;
import com.qh.common.utils.RequestUtils;
import com.qh.redis.service.RedisUtil;
import com.qh.system.constenum.YesNoType;

/**
 * 广告数据上报
 * @author my
 *
 */
@RestController
@RequestMapping("/api/ad")
public class AdvertisementApi {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AdvertisementApi.class);
	@Autowired
	private AdvertisementShowService advertisementShowService;
	
	
	/***
	 * 获取广告
	 * @param request
	 * @return
	 */
    @PostMapping("/list")
    public Object list(HttpServletRequest request){
    	R r=	listDataCheck(request);
    	if(R.ifSucc(r)){
    		 ProductDO productDO= (ProductDO)r.getData();
    		 ProductVo productVo= BeanMapperUtil.map(productDO, ProductVo.class);
    		 List<ProductAdvertisementDO> list= RedisUtil.getProductAdvertisementList(productDO.getId());
    		 for (ProductAdvertisementDO productAdvertisementDO : list) {
    			 AdvertisementVo advertisementVo=new AdvertisementVo();
    			 advertisementVo.setId(productAdvertisementDO.getAdvertisementId());
    			 advertisementVo.setSeq(productAdvertisementDO.getSeq());
    			 AdvertisementDO advertisementDO= RedisUtil.getadvertisement(productAdvertisementDO.getAdvertisementId());
    			 advertisementVo.setName(advertisementDO.getName());
    			 advertisementVo.setLinkUrl(advertisementDO.getLinkUrl());
    			 advertisementVo.setPictureUrl(advertisementDO.getPictureUrl());
    			 advertisementVo.setDownloadUrl(advertisementDO.getDownloadUrl());
    			 //广告状态启用，合作企业状态启用才推给app
    			 PartnershipDO partnershipDO =RedisUtil.getPartnership(advertisementDO.getPartnershipId());
    			 if(advertisementDO.getStatus()==YesNoType.yes.id()&&partnershipDO!=null&&partnershipDO.getStatus()==YesNoType.yes.id()) {
        			 productVo.getList().add(advertisementVo);
    			 }
    		 }
    		 return R.okData(productVo);
    	}else{
    		return r;
    	}
    }
    
	
	
	/***
	 * 上传播放广告信息
	 * @param request
	 * @return
	 */
    @PostMapping("/open")
    public Object open(HttpServletRequest request){
    	R r=	openDataCheck(request);
    	if(R.ifSucc(r)){
    		AdvertisementShowDO advertisementShowDO= (AdvertisementShowDO)r.getData();
    		advertisementShowService.save(advertisementShowDO);
    		 R.ok();
    	}else{
    		return r;
    	}
    	return R.ok();
    }
    
    
    /**
   	 * @Description 检查方法
   	 * @param request
   	 * @return
   	 */
   	private R openDataCheck(HttpServletRequest request) {
   		AdvertisementShowDO advertisementShowDO=new AdvertisementShowDO();
   		JSONObject jsonObject =  RequestUtils.getJsonResultStream(request);
       	if(jsonObject == null){
       		logger.error("请检查请求参数！");
       		return R.error("请检查请求参数！");
       	}
       	logger.debug("请求数据：{}",jsonObject.toString());
    	String advertisementId = jsonObject.getString("advertisementId");
       	if(ParamUtil.isEmpty(advertisementId)){
       		logger.error("advertisementId不能为空！");
       		return R.error("advertisementId不能为空！");
       	}
       	
       	Long adId=null;
     	try {
     		adId=Long.parseLong(advertisementId);
		} catch (NumberFormatException e) {
			logger.error("advertisementId信息异常！");
     		return R.error("advertisementId信息异常！");
		}
     	
     	 if(RedisUtil.getadvertisement(adId)==null) {
          	logger.error("advertisementId信息异常！");
        		return R.error("advertisementId信息异常！");
          }
     	 advertisementShowDO.setAdvertisementId(adId);
     	  
     	  
       	
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
       	Map<Long,ProductDO> productMap=	RedisUtil.getaProductMap();
        if(productMap.get(proId)==null) {
        	logger.error("productId信息异常！");
      		return R.error("productId信息异常！");
        }
        advertisementShowDO.setProductId(proId);
       	String phone = jsonObject.getString("phone");
       	if(ParamUtil.isNotEmpty(phone)){
       		advertisementShowDO.setPhone(phone);
       	}
     	String deviceName = jsonObject.getString("deviceName");
       	if(ParamUtil.isNotEmpty(deviceName)){
       		advertisementShowDO.setDeviceName(deviceName);
       	}
       	String ip =IPUtils.getIpAddr(request);
       	advertisementShowDO.setIp(ip);
        return R.okData(advertisementShowDO);
   	}
   	
   	
   	
   	
    
    /**
   	 * @Description 检查方法
   	 * @param request
   	 * @return
   	 */
   	private R listDataCheck(HttpServletRequest request) {
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
        ProductDO productDO=	RedisUtil.getaProduct(proId);
        if(productDO==null) {
        	logger.error("productId信息异常！");
      		return R.error("productId信息异常！");
        }
        return R.okData(productDO);
   	}
   	
	
}
