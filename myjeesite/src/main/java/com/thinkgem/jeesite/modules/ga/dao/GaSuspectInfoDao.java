/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ga.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.ga.entity.GaSuspectInfo;

/**
 * 疑似主叫号码DAO接口
 * @author xzf
 * @version 2018-10-16
 */
@MyBatisDao
public interface GaSuspectInfoDao extends CrudDao<GaSuspectInfo> {
	
}