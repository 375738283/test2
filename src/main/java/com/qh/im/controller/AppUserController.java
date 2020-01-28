package com.qh.im.controller;

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

import com.qh.im.domain.AppUserDO;
import com.qh.im.service.AppUserService;
import com.qh.common.utils.PageUtils;
import com.qh.common.utils.Query;
import com.qh.common.utils.R;

/**
 * 
 * 
 * @author sfsfsfs
 * @email 24242423423@qq.com
 * @date 2019-07-23 22:39:51
 */
 
@Controller
@RequestMapping("/im/appUser")
public class AppUserController {
	@Autowired
	private AppUserService appUserService;
	
	@GetMapping()
	@RequiresPermissions("im:appUser:appUser")
	String AppUser(){
	    return "im/appUser/appUser";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("im:appUser:appUser")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AppUserDO> appUserList = appUserService.list(query);
		int total = appUserService.count(query);
		PageUtils pageUtils = new PageUtils(appUserList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("im:appUser:add")
	String add(){
	    return "im/appUser/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("im:appUser:edit")
	String edit(@PathVariable("id") Long id,Model model){
		AppUserDO appUser = appUserService.get(id);
		model.addAttribute("appUser", appUser);
	    return "im/appUser/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("im:appUser:add")
	public R save( AppUserDO appUser){
		if(appUserService.save(appUser)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("im:appUser:edit")
	public R update( AppUserDO appUser){
		appUserService.update(appUser);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("im:appUser:remove")
	public R remove( Long id){
		if(appUserService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("im:appUser:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		appUserService.batchRemove(ids);
		return R.ok();
	}
	
}
