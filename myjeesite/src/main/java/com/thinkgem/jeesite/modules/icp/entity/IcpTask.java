/**
 * 
 */
package com.thinkgem.jeesite.modules.icp.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 备案任务管理Entity
 * @author xzf
 * @version 2018-12-03
 */
public class IcpTask extends DataEntity<IcpTask> {
	
	private static final long serialVersionUID = 1L;
	private String taskname;		// 任务名称
	private Integer state;		// 任务状态
	private Date inserttime;		// 入库时间
	private Long icpinfototal;		// 备案数
	private String zipname;		// 文档名称
	
	public IcpTask() {
		super();
		this.setUUID(false);
	}

	public IcpTask(String id){
		super(id);
	}

	@Length(min=1, max=100, message="任务名称长度必须介于 1 和 100 之间")
	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInserttime() {
		return inserttime;
	}

	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}
	
	public Long getIcpinfototal() {
		return icpinfototal;
	}

	public void setIcpinfototal(Long icpinfototal) {
		this.icpinfototal = icpinfototal;
	}
	
	@Length(min=0, max=50, message="文档名称长度必须介于 0 和 50 之间")
	public String getZipname() {
		return zipname;
	}

	public void setZipname(String zipname) {
		this.zipname = zipname;
	}
	
}