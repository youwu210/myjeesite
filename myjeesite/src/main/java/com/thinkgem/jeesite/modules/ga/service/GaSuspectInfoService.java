/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ga.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.ga.entity.GaSuspectInfo;
import com.thinkgem.jeesite.modules.ga.dao.GaSuspectInfoDao;

/**
 * 疑似主叫号码Service
 * @author xzf
 * @version 2018-10-16
 */
@Service
@Transactional(readOnly = true)
public class GaSuspectInfoService extends CrudService<GaSuspectInfoDao, GaSuspectInfo> {

	public GaSuspectInfo get(String id) {
		return super.get(id);
	}
	
	public List<GaSuspectInfo> findList(GaSuspectInfo gaSuspectInfo) {
		return super.findList(gaSuspectInfo);
	}
	
	public Page<GaSuspectInfo> findPage(Page<GaSuspectInfo> page, GaSuspectInfo gaSuspectInfo) {
		return super.findPage(page, gaSuspectInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(GaSuspectInfo gaSuspectInfo) {
		super.save(gaSuspectInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(GaSuspectInfo gaSuspectInfo) {
		super.delete(gaSuspectInfo);
	}
	
}