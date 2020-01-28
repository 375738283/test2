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

import com.qh.im.domain.DynamicDO;
import com.qh.im.service.DynamicService;
import com.qh.common.utils.PageUtils;
import com.qh.common.utils.Query;
import com.qh.common.utils.R;

/**
 * 动态
 * 
 * @author sfsfsfs
 * @email 24242423423@qq.com
 * @date 2019-07-23 22:39:51
 */
 
@Controller
@RequestMapping("/im/dynamic")
public class DynamicController {
	@Autowired
	private DynamicService dynamicService;
	
	@GetMapping()
	@RequiresPermissions("im:dynamic:dynamic")
	String Dynamic(){
	    return "im/dynamic/dynamic";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("im:dynamic:dynamic")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DynamicDO> dynamicList = dynamicService.list(query);
		int total = dynamicService.count(query);
		PageUtils pageUtils = new PageUtils(dynamicList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("im:dynamic:add")
	String add(){
	    return "im/dynamic/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("im:dynamic:edit")
	String edit(@PathVariable("id") Long id,Model model){
		DynamicDO dynamic = dynamicService.get(id);
		model.addAttribute("dynamic", dynamic);
	    return "im/dynamic/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("im:dynamic:add")
	public R save( DynamicDO dynamic){
		if(dynamicService.save(dynamic)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("im:dynamic:edit")
	public R update( DynamicDO dynamic){
		dynamicService.update(dynamic);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("im:dynamic:remove")
	public R remove( Long id){
		if(dynamicService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("im:dynamic:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		dynamicService.batchRemove(ids);
		return R.ok();
	}
	
}
