/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.icp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.icp.entity.IcpTask;
import com.thinkgem.jeesite.modules.icp.dao.IcpTaskDao;

/**
 * 备案任务管理Service
 * @author xzf
 * @version 2018-11-09
 */
@Service
@Transactional(readOnly = true)
public class IcpTaskService extends CrudService<IcpTaskDao, IcpTask> {

	public IcpTask get(String id) {
		return super.get(id);
	}
	
	public List<IcpTask> findList(IcpTask icpTask) {
		return super.findList(icpTask);
	}
	
	public Page<IcpTask> findPage(Page<IcpTask> page, IcpTask icpTask) {
		return super.findPage(page, icpTask);
	}
	
	@Transactional(readOnly = false)
	public void save(IcpTask icpTask) {
		super.save(icpTask);
	}
	
	@Transactional(readOnly = false)
	public void delete(IcpTask icpTask) {
		super.delete(icpTask);
	}
	
}