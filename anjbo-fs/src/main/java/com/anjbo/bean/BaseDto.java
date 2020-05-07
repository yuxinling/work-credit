package com.anjbo.bean;

import java.util.Date;

/**
 * 基类
 * @ClassName: BaseDto 
 * @author limh limh@zxsf360.com
 * @date 2014-12-10 下午06:04:30
 */
public class BaseDto extends BasePager{

	private static final long serialVersionUID = 1L;
	/**创建人**/
	protected String createUid;
	/**创建时间**/
	protected Date createTime;
	/**修改人**/
	protected String updateUid;
	/**修改时间**/
	protected Date updateTime;
	/**标示id**/
	protected String sid;
	/**设备**/
	protected String device;
	/**设备id**/
	protected String deviceId;
	/**版本**/
	protected String version;
	/**密钥**/
	protected String key;
	/**登录用户uid**/
	protected String uid;
	/**关联orderNo*/
	protected String relationOrderNo;
	
	public String getVersion() {
		return version;
	}
	public String getKey() {
		return key;
	}
	public String getRelationOrderNo() {
		return relationOrderNo;
	}
	public void setRelationOrderNo(String relationOrderNo) {
		this.relationOrderNo = relationOrderNo;
	}
	public String getCreateUid() {
		return createUid;
	}
	public void setCreateUid(String createUid) {
		this.createUid = createUid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUid() {
		return updateUid;
	}
	public void setUpdateUid(String updateUid) {
		this.updateUid = updateUid;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
}
