/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.icp.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.icp.entity.IcpTask;

/**
 * 备案任务管理DAO接口
 * @author xzf
 * @version 2018-11-09
 */
@MyBatisDao
public interface IcpTaskDao extends CrudDao<IcpTask> {
	
}