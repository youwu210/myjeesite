/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ga.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 疑似主叫号码Entity
 * @author xzf
 * @version 2018-10-16
 */
public class GaSuspectInfo extends DataEntity<GaSuspectInfo> {
	
	private static final long serialVersionUID = 1L;
	private String callingnumber;		// 诈骗号码
	private String name;		// 名字
	private Integer gender;		// 性别
	private String idcard;		// 身份证号码
	private String address;		// 地址
	private Integer belonggang;		// 是否诈骗团伙成员
	private Long gangid;		// 所属诈骗团伙ID
	private Integer age;		// 年龄
	private Integer isswindle;		// 是否诈骗
	private Integer isfake;		// 是否改号
	private String faketarget;		// 冒充目标
	private String detail;		// 诈骗详情
	private Long amount;		// 诈骗金额
	private Long swindlecount;		// 诈骗次数
	private Date starttime;		// 开始时间
	private Long uploadflag;		// 上报标志
	
	public GaSuspectInfo() {
		super();
	}

	public GaSuspectInfo(String id){
		super(id);
	}

	@Length(min=0, max=50, message="诈骗号码长度必须介于 0 和 50 之间")
	public String getCallingnumber() {
		return callingnumber;
	}

	public void setCallingnumber(String callingnumber) {
		this.callingnumber = callingnumber;
	}
	
	@Length(min=0, max=50, message="名字长度必须介于 0 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	@Length(min=0, max=20, message="身份证号码长度必须介于 0 和 20 之间")
	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	@Length(min=0, max=100, message="地址长度必须介于 0 和 100 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getBelonggang() {
		return belonggang;
	}

	public void setBelonggang(Integer belonggang) {
		this.belonggang = belonggang;
	}
	
	public Long getGangid() {
		return gangid;
	}

	public void setGangid(Long gangid) {
		this.gangid = gangid;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getIsswindle() {
		return isswindle;
	}

	public void setIsswindle(Integer isswindle) {
		this.isswindle = isswindle;
	}
	
	public Integer getIsfake() {
		return isfake;
	}

	public void setIsfake(Integer isfake) {
		this.isfake = isfake;
	}
	
	@Length(min=0, max=100, message="冒充目标长度必须介于 0 和 100 之间")
	public String getFaketarget() {
		return faketarget;
	}

	public void setFaketarget(String faketarget) {
		this.faketarget = faketarget;
	}
	
	@Length(min=0, max=1000, message="诈骗详情长度必须介于 0 和 1000 之间")
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public Long getSwindlecount() {
		return swindlecount;
	}

	public void setSwindlecount(Long swindlecount) {
		this.swindlecount = swindlecount;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	
	public Long getUploadflag() {
		return uploadflag;
	}

	public void setUploadflag(Long uploadflag) {
		this.uploadflag = uploadflag;
	}
	
}