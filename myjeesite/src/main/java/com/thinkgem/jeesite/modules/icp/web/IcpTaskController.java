/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.icp.web;

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
import com.thinkgem.jeesite.modules.icp.entity.IcpTask;
import com.thinkgem.jeesite.modules.icp.service.IcpTaskService;

/**
 * 备案任务管理Controller
 * @author xzf
 * @version 2018-11-09
 */
@Controller
@RequestMapping(value = "${adminPath}/icp/icpTask")
public class IcpTaskController extends BaseController {

	@Autowired
	private IcpTaskService icpTaskService;
	
	/**
	 * 每个方法之前都要执行，类似于model.addAttribute("icpTask", entity);
	 * 类似于@ModelAttribute(value="icpTask")  不写value就等于返回值类型首字母小写（icpTask）
	 */
	@ModelAttribute(value="icpTask")
	public IcpTask get(@RequestParam(required=false) String id) {
		IcpTask entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = icpTaskService.get(id);
		}
		if (entity == null){
			entity = new IcpTask();
		}
		return entity;
	}
	
	@RequiresPermissions("icp:icpTask:view")
	@RequestMapping(value = {"list", ""})
	public String list(IcpTask icpTask, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<IcpTask> page = icpTaskService.findPage(new Page<IcpTask>(request, response), icpTask); 
		model.addAttribute("page", page);
		return "modules/icp/icpTaskList";
	}

	@RequiresPermissions("icp:icpTask:view")
	@RequestMapping(value = "form")
	public String form(IcpTask icpTask, Model model) {
		model.addAttribute("icpTask", icpTask);
		return "modules/icp/icpTaskForm";
	}

	@RequiresPermissions("icp:icpTask:edit")
	@RequestMapping(value = "save")
	public String save(IcpTask icpTask, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, icpTask)){
			return form(icpTask, model);
		}
		icpTaskService.save(icpTask);
		addMessage(redirectAttributes, "保存备案任务成功");
		return "redirect:"+Global.getAdminPath()+"/icp/icpTask/?repage";
	}
	
	@RequiresPermissions("icp:icpTask:edit")
	@RequestMapping(value = "delete")
	public String delete(IcpTask icpTask, RedirectAttributes redirectAttributes) {
		icpTaskService.delete(icpTask);
		addMessage(redirectAttributes, "删除备案任务成功");
		return "redirect:"+Global.getAdminPath()+"/icp/icpTask/?repage";
	}

}