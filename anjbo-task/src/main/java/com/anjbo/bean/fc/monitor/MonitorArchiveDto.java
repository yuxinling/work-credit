package com.anjbo.bean.fc.monitor;

import java.util.Date;

import com.anjbo.bean.BaseDto;

public class MonitorArchiveDto extends BaseDto{
	/**主键**/
	private Integer id;
	/**创建人uid*/
	private String createUid;
	/**查档类型(1分户，2分栋)**/
	private Integer type;
	/**产权证书类型（0房地产权证书 1不动产权证书）**/
	private Integer estateType;
	/**房产证号**/
	private String estateNo;
	/**身份证号**/
	private String identityNo;
	/**创建时间**/
	private Date createTime;
	/**开始时间**/
	private String startTime;
	/**结束时间**/
	private String endTime;
	/**查询频次**/
	private Integer queryFrequency;
	/**查询用途（交易类赎楼，非交易类赎楼，过桥，红本抵押，快速贷，存单质押，换房融资，其他）**/
	private String queryUsage;
	/**手机号**/
	private String phone;
	/**查档id*/
	private String archiveId;
	/**查档结果(红本、抵押在银行、查封)**/
	private String message;
	/**产权状态(抵押、查封)*/
	private String propertyStatus;
	/**变更记录*/
	private String changeRecord;
	/**更新时间**/
	private Date updateTime;
	private String uid;
	private int agencyId;  //机构Id
	private String uids;
	private String name; //创建人
	private String yearNo;  //'粤（不动产权证书要用）',
	
	private String updateTimeOrderBy; //排序
	
	/**订单号*/
	private String orderNo;
	
	
	public String getYearNo() {
		return yearNo;
	}
	public void setYearNo(String yearNo) {
		this.yearNo = yearNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUpdateTimeOrderBy() {
		return updateTimeOrderBy;
	}
	public void setUpdateTimeOrderBy(String updateTimeOrderBy) {
		this.updateTimeOrderBy = updateTimeOrderBy;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	public String getUids() {
		return uids;
	}
	public void setUids(String uids) {
		this.uids = uids;
	}
	public MonitorArchiveDto() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getEstateType() {
		return estateType;
	}
	public void setEstateType(Integer estateType) {
		this.estateType = estateType;
	}
	public String getEstateNo() {
		return estateNo;
	}
	public void setEstateNo(String estateNo) {
		this.estateNo = estateNo;
	}
	public String getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getQueryFrequency() {
		return queryFrequency;
	}
	public void setQueryFrequency(Integer queryFrequency) {
		this.queryFrequency = queryFrequency;
	}
	public String getQueryUsage() {
		return queryUsage;
	}
	public void setQueryUsage(String queryUsage) {
		this.queryUsage = queryUsage;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public void setArchiveId(String archiveId) {
		this.archiveId = archiveId;
	}
	public String getArchiveId() {
		return archiveId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getPropertyStatus() {
		return propertyStatus;
	}
	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}
	public String getChangeRecord() {
		return changeRecord;
	}
	public void setChangeRecord(String changeRecord) {
		this.changeRecord = changeRecord;
	}
	public String getCreateUid() {
		return createUid;
	}
	public void setCreateUid(String createUid) {
		this.createUid = createUid;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
}
