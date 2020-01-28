package com.qh.ad.controller;

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

import com.qh.ad.constenum.AdvertisementType;
import com.qh.ad.domain.AdvertisementDO;
import com.qh.ad.domain.PartnershipDO;
import com.qh.ad.service.AdvertisementService;
import com.qh.common.utils.PageUtils;
import com.qh.common.utils.Query;
import com.qh.common.utils.R;
import com.qh.redis.service.RedisUtil;
import com.qh.system.constenum.UserType;
import com.qh.system.constenum.YesNoType;

/**
 * 广告
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
 
@Controller
@RequestMapping("/ad/advertisement")
public class AdvertisementController {
	@Autowired
	private AdvertisementService advertisementService;
	
	@GetMapping()
	@RequiresPermissions("ad:advertisement:advertisement")
	String Advertisement(Model model){
		
//		List<PartnershipDO> partnershipList= RedisUtil.getPartnershipList();
//		Map partnershipMap=new HashMap<>();
//		for (PartnershipDO partnershipDO : partnershipList) {
//			partnershipMap.put(partnershipDO.getId(), partnershipDO.getName());
//		}
		model.addAttribute("partnershipMap",RedisUtil.getPartnershipMap());
		model.addAttribute("status",YesNoType.descStatus());
	    return "ad/advertisement/advertisement";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ad:advertisement:advertisement")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AdvertisementDO> advertisementList = advertisementService.list(query);
		int total = advertisementService.count(query);
		PageUtils pageUtils = new PageUtils(advertisementList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ad:advertisement:add")
	String add(Model model){
		model.addAttribute("advertisementTypes", AdvertisementType.desc());
		model.addAttribute("partnershipList", RedisUtil.getPartnershipList());
	    return "ad/advertisement/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("ad:advertisement:edit")
	String edit(@PathVariable("id") Long id,Model model){
		AdvertisementDO advertisement = advertisementService.get(id);
		model.addAttribute("advertisement", advertisement);
		model.addAttribute("advertisementTypes", AdvertisementType.desc());
		model.addAttribute("partnershipList", RedisUtil.getPartnershipList());
	    return "ad/advertisement/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ad:advertisement:add")
	public R save( AdvertisementDO advertisement){
		if(advertisementService.save(advertisement)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ad:advertisement:edit")
	public R update( AdvertisementDO advertisement){
		advertisementService.update(advertisement);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ad:advertisement:remove")
	public R remove( Long id){
		if(advertisementService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ad:advertisement:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		advertisementService.batchRemove(ids);
		return R.ok();
	}
	
	
	

	/***
	 * 
	 * @Description 停启用状态
	 * @param id
	 * @param cmd
	 * @return
	 */
	@PostMapping(value = "/changeStatus")
	@ResponseBody
	@RequiresPermissions("ad:advertisement:changeStatus")
	public R changeStatus(Long id,Integer status) {
		String label = "停止";
		if (status==1) {
			label = "启用";
		} else {
			label = "禁用";
		}
		try {
			advertisementService.changeStatus(id, status);
			return R.ok("状态" + label + "成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return R.ok("任务" + label + "失败");
	}
	
}
