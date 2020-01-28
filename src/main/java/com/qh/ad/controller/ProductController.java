package com.qh.ad.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qh.ad.domain.AdvertisementDO;
import com.qh.ad.domain.MarketDO;
import com.qh.ad.domain.ProductAdvertisementDO;
import com.qh.ad.domain.ProductDO;
import com.qh.ad.service.ProductService;
import com.qh.common.utils.PageUtils;
import com.qh.common.utils.Query;
import com.qh.common.utils.R;
import com.qh.redis.service.RedisUtil;

/**
 * app产品
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:11
 */
 
@Controller
@RequestMapping("/ad/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	@RequiresPermissions("ad:product:product")
	String Product(Model model){
		model.addAttribute("marketMap", RedisUtil.getMarketMap());
		model.addAttribute("advertisementMap", RedisUtil.getadvertisementMap());
		model.addAttribute("partnershipMap",RedisUtil.getPartnershipMap());
	    return "ad/product/product";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ad:product:product")
	public PageUtils list(@RequestParam Long marketId,@RequestParam Long advertisementId, @RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProductDO> productList = productService.list(query);
		for (ProductDO productDO : productList) {
			productDO.setProductAdvertisementList(RedisUtil.getProductAdvertisementList(productDO.getId()));
			List<Long> productAdverIdList=new ArrayList<>();
			for (ProductAdvertisementDO productAdvertisementDO : productDO.getProductAdvertisementList()) {
				productAdverIdList.add(productAdvertisementDO.getAdvertisementId());
			}
			productDO.setAdvertisementIdList(productAdverIdList);
		}
		int total = productService.count(query);
		PageUtils pageUtils = new PageUtils(productList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ad:product:add")
	String add(Model model){
		model.addAttribute("marketList", RedisUtil.getMarketList());
		model.addAttribute("advertisementList", RedisUtil.getadvertisementList());
	    return "ad/product/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("ad:product:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ProductDO product = productService.get(id);
		model.addAttribute("product", product);
		model.addAttribute("marketList", RedisUtil.getMarketList());
		model.addAttribute("advertisementList", RedisUtil.getadvertisementList());
		
		
		
		product.setProductAdvertisementList(RedisUtil.getProductAdvertisementList(product.getId()));
		List<Long> productAdverIdList=new ArrayList<>();
		for (ProductAdvertisementDO productAdvertisementDO : product.getProductAdvertisementList()) {
			productAdverIdList.add(productAdvertisementDO.getAdvertisementId());
		}
		product.setAdvertisementIdList(productAdverIdList);
	    return "ad/product/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ad:product:add")
	public R save( ProductDO product){
		if(productService.save(product)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ad:product:edit")
	public R update( ProductDO product){
		if(product.getMarketIds()==null) {
			product.setMarketIds("");
		}
		productService.update(product);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ad:product:remove")
	public R remove( Long id){
		if(productService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ad:product:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		productService.batchRemove(ids);
		return R.ok();
	}
	
	
	

	/***
	 * 
	 * @Description 修改推送开关
	 * @param id
	 * @param cmd
	 * @return
	 */
	@PostMapping(value = "/changePushSwitch")
	@ResponseBody
	@RequiresPermissions("ad:product:changePushSwitch")
	public R changePushSwitch(Long id,Integer pushSwitch) {
		String label = "停止";
		if (pushSwitch==1) {
			label = "启用";
		} else {
			label = "关闭";
		}
		try {
			productService.changePushSwitch(id, pushSwitch);
			return R.ok("状态" + label + "成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return R.ok("任务" + label + "失败");
	}
	
	
}
