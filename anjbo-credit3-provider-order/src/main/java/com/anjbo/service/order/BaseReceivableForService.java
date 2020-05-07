/*
 *Project: ANJBO Generator
 ****************************************************************
 * 版权所有@2018 ANJBO.COM  保留所有权利.
 ***************************************************************/
package com.anjbo.service.order;

import java.util.List;

import com.anjbo.bean.order.BaseReceivableForDto;
import com.anjbo.service.BaseService;


/**
 * 
 * @Author ANJBO Generator 
 * @Date 2018-07-03 20:14:46
 * @version 1.0
 */
public interface BaseReceivableForService extends BaseService<BaseReceivableForDto>{
	List<BaseReceivableForDto> selectOrderReceivableForByOrderNo(String orderNo);
}
