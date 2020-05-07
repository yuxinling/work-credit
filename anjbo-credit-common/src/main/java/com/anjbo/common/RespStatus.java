package com.anjbo.common;

import java.io.Serializable;

/**
 * 返回给客户端的状态信息
 * 
 */
public class RespStatus implements Serializable {

	private static final long serialVersionUID = 5852117168069614127L;
	
	/**
	 * 提示信息
	 */
	private String msg;

	/**
	 * 返回码
	 */
	private String code;

	public RespStatus() {
		super();
	}

	public RespStatus(String code,String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public void setCodeMsg(RespStatusEnum status, String msg) {
		this.code = status.getCode();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "RespStatus [msg=" + msg + ", code=" + code + "]";
	}

}
