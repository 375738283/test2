package com.qh.ad.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.qh.ad.domain.MarketDO;
import com.qh.ad.domain.ProductDownloadDO;
import com.qh.ad.service.ProductDownloadService;
import com.qh.common.utils.DateUtil;
import com.qh.common.utils.PageUtils;
import com.qh.common.utils.ParamUtil;
import com.qh.common.utils.Query;
import com.qh.common.utils.R;
import com.qh.redis.service.RedisUtil;

/**
 * 产品下载信息表
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:11
 */
 
@Controller
@RequestMapping("/ad/productDownload")
public class ProductDownloadController {
	@Autowired
	private ProductDownloadService productDownloadService;
	
	@GetMapping()
	@RequiresPermissions("ad:productDownload:productDownload")
	String ProductDownload(Model model){
		
		model.addAttribute("marketMap", RedisUtil.getMarketMap());
		model.addAttribute("productMap", RedisUtil.getaProductMap());
		
	    return "ad/productDownload/productDownload";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ad:productDownload:productDownload")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProductDownloadDO> productDownloadList = productDownloadService.list(query);
		int total = productDownloadService.count(query);
		PageUtils pageUtils = new PageUtils(productDownloadList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ad:productDownload:add")
	String add(){
	    return "ad/productDownload/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("ad:productDownload:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ProductDownloadDO productDownload = productDownloadService.get(id);
		model.addAttribute("productDownload", productDownload);
	    return "ad/productDownload/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ad:productDownload:add")
	public R save( ProductDownloadDO productDownload){
		if(productDownloadService.save(productDownload)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ad:productDownload:edit")
	public R update( ProductDownloadDO productDownload){
		productDownloadService.update(productDownload);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ad:productDownload:remove")
	public R remove( Long id){
		if(productDownloadService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ad:productDownload:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		productDownloadService.batchRemove(ids);
		return R.ok();
	}
	
}
