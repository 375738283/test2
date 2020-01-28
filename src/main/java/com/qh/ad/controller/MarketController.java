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

import com.qh.ad.domain.MarketDO;
import com.qh.ad.service.MarketService;
import com.qh.common.utils.PageUtils;
import com.qh.common.utils.Query;
import com.qh.common.utils.R;

/**
 * 应该市场
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
 
@Controller
@RequestMapping("/ad/market")
public class MarketController {
	@Autowired
	private MarketService marketService;
	
	@GetMapping()
	@RequiresPermissions("ad:market:market")
	String Market(){
	    return "ad/market/market";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ad:market:market")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MarketDO> marketList = marketService.list(query);
		int total = marketService.count(query);
		PageUtils pageUtils = new PageUtils(marketList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ad:market:add")
	String add(){
	    return "ad/market/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("ad:market:edit")
	String edit(@PathVariable("id") Long id,Model model){
		MarketDO market = marketService.get(id);
		model.addAttribute("market", market);
	    return "ad/market/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ad:market:add")
	public R save( MarketDO market){
		if(marketService.save(market)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ad:market:edit")
	public R update( MarketDO market){
		marketService.update(market);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ad:market:remove")
	public R remove( Long id){
		if(marketService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ad:market:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		marketService.batchRemove(ids);
		return R.ok();
	}
	
}
