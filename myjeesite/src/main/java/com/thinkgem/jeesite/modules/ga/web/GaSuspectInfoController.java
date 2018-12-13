/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ga.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.ga.entity.GaSuspectInfo;
import com.thinkgem.jeesite.modules.ga.service.GaSuspectInfoService;

/**
 * 疑似主叫号码Controller
 * @author xzf
 * @version 2018-10-16
 */
@Controller
@RequestMapping(value = "${adminPath}/ga/gaSuspectInfo")
public class GaSuspectInfoController extends BaseController {

	@Autowired
	private GaSuspectInfoService gaSuspectInfoService;
	
	@ModelAttribute
	public GaSuspectInfo get(@RequestParam(required=false) String id) {
		GaSuspectInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gaSuspectInfoService.get(id);
		}
		if (entity == null){
			entity = new GaSuspectInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("ga:gaSuspectInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(GaSuspectInfo gaSuspectInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GaSuspectInfo> page = gaSuspectInfoService.findPage(new Page<GaSuspectInfo>(request, response), gaSuspectInfo); 
		model.addAttribute("page", page);
		return "modules/ga/gaSuspectInfoList";
	}

	@RequiresPermissions("ga:gaSuspectInfo:view")
	@RequestMapping(value = "form")
	public String form(GaSuspectInfo gaSuspectInfo, Model model) {
		model.addAttribute("gaSuspectInfo", gaSuspectInfo);
		return "modules/ga/gaSuspectInfoForm";
	}

	@RequiresPermissions("ga:gaSuspectInfo:edit")
	@RequestMapping(value = "save")
	public String save(GaSuspectInfo gaSuspectInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gaSuspectInfo)){
			return form(gaSuspectInfo, model);
		}
		gaSuspectInfoService.save(gaSuspectInfo);
		addMessage(redirectAttributes, "保存疑似主叫号码成功");
		return "redirect:"+Global.getAdminPath()+"/ga/gaSuspectInfo/?repage";
	}
	
	@RequiresPermissions("ga:gaSuspectInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(GaSuspectInfo gaSuspectInfo, RedirectAttributes redirectAttributes) {
		gaSuspectInfoService.delete(gaSuspectInfo);
		addMessage(redirectAttributes, "删除疑似主叫号码成功");
		return "redirect:"+Global.getAdminPath()+"/ga/gaSuspectInfo/?repage";
	}

}