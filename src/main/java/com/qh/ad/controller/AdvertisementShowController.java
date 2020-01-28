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

import com.qh.ad.domain.AdvertisementShowDO;
import com.qh.ad.service.AdvertisementShowService;
import com.qh.common.utils.PageUtils;
import com.qh.common.utils.Query;
import com.qh.common.utils.R;
import com.qh.redis.service.RedisUtil;

/**
 * 广告展示表
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
 
@Controller
@RequestMapping("/ad/advertisementShow")
public class AdvertisementShowController {
	@Autowired
	private AdvertisementShowService advertisementShowService;
	
	@GetMapping()
	@RequiresPermissions("ad:advertisementShow:advertisementShow")
	String AdvertisementShow(Model model){
		model.addAttribute("advertisementMap", RedisUtil.getadvertisementMap());
		model.addAttribute("partnershipMap",RedisUtil.getPartnershipMap());
		model.addAttribute("productMap", RedisUtil.getaProductMap());
	    return "ad/advertisementShow/advertisementShow";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ad:advertisementShow:advertisementShow")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AdvertisementShowDO> advertisementShowList = advertisementShowService.list(query);
		int total = advertisementShowService.count(query);
		PageUtils pageUtils = new PageUtils(advertisementShowList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ad:advertisementShow:add")
	String add(){
	    return "ad/advertisementShow/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("ad:advertisementShow:edit")
	String edit(@PathVariable("id") Long id,Model model){
		AdvertisementShowDO advertisementShow = advertisementShowService.get(id);
		model.addAttribute("advertisementShow", advertisementShow);
	    return "ad/advertisementShow/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ad:advertisementShow:add")
	public R save( AdvertisementShowDO advertisementShow){
		if(advertisementShowService.save(advertisementShow)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ad:advertisementShow:edit")
	public R update( AdvertisementShowDO advertisementShow){
		advertisementShowService.update(advertisementShow);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ad:advertisementShow:remove")
	public R remove( Long id){
		if(advertisementShowService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ad:advertisementShow:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		advertisementShowService.batchRemove(ids);
		return R.ok();
	}
	
}
