package com.qh.ad.controller;

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

import com.qh.ad.domain.PartnershipDO;
import com.qh.ad.service.PartnershipService;
import com.qh.common.utils.PageUtils;
import com.qh.common.utils.Query;
import com.qh.common.utils.R;

/**
 * 合作方
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
 
@Controller
@RequestMapping("/ad/partnership")
public class PartnershipController {
	@Autowired
	private PartnershipService partnershipService;
	
	@GetMapping()
	@RequiresPermissions("ad:partnership:partnership")
	String Partnership(){
	    return "ad/partnership/partnership";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ad:partnership:partnership")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PartnershipDO> partnershipList = partnershipService.list(query);
		int total = partnershipService.count(query);
		PageUtils pageUtils = new PageUtils(partnershipList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ad:partnership:add")
	String add(){
	    return "ad/partnership/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("ad:partnership:edit")
	String edit(@PathVariable("id") Long id,Model model){
		PartnershipDO partnership = partnershipService.get(id);
		model.addAttribute("partnership", partnership);
	    return "ad/partnership/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ad:partnership:add")
	public R save( PartnershipDO partnership){
		if(partnershipService.save(partnership)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ad:partnership:edit")
	public R update( PartnershipDO partnership){
		partnershipService.update(partnership);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ad:partnership:remove")
	public R remove( Long id){
		if(partnershipService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ad:partnership:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		partnershipService.batchRemove(ids);
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
	@RequiresPermissions("ad:partnership:changeStatus")
	public R changeStatus(Long id,Integer status) {
		String label = "停止";
		if (status==1) {
			label = "启用";
		} else {
			label = "禁用";
		}
		try {
			partnershipService.changeStatus(id, status);
			return R.ok("状态" + label + "成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return R.ok("任务" + label + "失败");
	}
	
}
