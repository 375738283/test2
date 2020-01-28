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

import com.qh.im.domain.PhotoAlbumDO;
import com.qh.im.service.PhotoAlbumService;
import com.qh.common.utils.PageUtils;
import com.qh.common.utils.Query;
import com.qh.common.utils.R;

/**
 * 相册表
 * 
 * @author sfsfsfs
 * @email 24242423423@qq.com
 * @date 2019-07-23 22:39:52
 */
 
@Controller
@RequestMapping("/im/photoAlbum")
public class PhotoAlbumController {
	@Autowired
	private PhotoAlbumService photoAlbumService;
	
	@GetMapping()
	@RequiresPermissions("im:photoAlbum:photoAlbum")
	String PhotoAlbum(){
	    return "im/photoAlbum/photoAlbum";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("im:photoAlbum:photoAlbum")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PhotoAlbumDO> photoAlbumList = photoAlbumService.list(query);
		int total = photoAlbumService.count(query);
		PageUtils pageUtils = new PageUtils(photoAlbumList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("im:photoAlbum:add")
	String add(){
	    return "im/photoAlbum/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("im:photoAlbum:edit")
	String edit(@PathVariable("id") Long id,Model model){
		PhotoAlbumDO photoAlbum = photoAlbumService.get(id);
		model.addAttribute("photoAlbum", photoAlbum);
	    return "im/photoAlbum/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("im:photoAlbum:add")
	public R save( PhotoAlbumDO photoAlbum){
		if(photoAlbumService.save(photoAlbum)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("im:photoAlbum:edit")
	public R update( PhotoAlbumDO photoAlbum){
		photoAlbumService.update(photoAlbum);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("im:photoAlbum:remove")
	public R remove( Long id){
		if(photoAlbumService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("im:photoAlbum:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		photoAlbumService.batchRemove(ids);
		return R.ok();
	}
	
}
