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

import com.qh.im.domain.DynamicPhotoDO;
import com.qh.im.service.DynamicPhotoService;
import com.qh.common.utils.PageUtils;
import com.qh.common.utils.Query;
import com.qh.common.utils.R;

/**
 * 动态相册关联表
 * 
 * @author sfsfsfs
 * @email 24242423423@qq.com
 * @date 2019-07-23 22:39:52
 */
 
@Controller
@RequestMapping("/im/dynamicPhoto")
public class DynamicPhotoController {
	@Autowired
	private DynamicPhotoService dynamicPhotoService;
	
	@GetMapping()
	@RequiresPermissions("im:dynamicPhoto:dynamicPhoto")
	String DynamicPhoto(){
	    return "im/dynamicPhoto/dynamicPhoto";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("im:dynamicPhoto:dynamicPhoto")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DynamicPhotoDO> dynamicPhotoList = dynamicPhotoService.list(query);
		int total = dynamicPhotoService.count(query);
		PageUtils pageUtils = new PageUtils(dynamicPhotoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("im:dynamicPhoto:add")
	String add(){
	    return "im/dynamicPhoto/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("im:dynamicPhoto:edit")
	String edit(@PathVariable("id") Long id,Model model){
		DynamicPhotoDO dynamicPhoto = dynamicPhotoService.get(id);
		model.addAttribute("dynamicPhoto", dynamicPhoto);
	    return "im/dynamicPhoto/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("im:dynamicPhoto:add")
	public R save( DynamicPhotoDO dynamicPhoto){
		if(dynamicPhotoService.save(dynamicPhoto)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("im:dynamicPhoto:edit")
	public R update( DynamicPhotoDO dynamicPhoto){
		dynamicPhotoService.update(dynamicPhoto);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("im:dynamicPhoto:remove")
	public R remove( Long id){
		if(dynamicPhotoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("im:dynamicPhoto:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		dynamicPhotoService.batchRemove(ids);
		return R.ok();
	}
	
}
