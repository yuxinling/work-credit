/*
 *Project: ANJBO Generator
 ****************************************************************
 * 版权所有@2018 ANJBO.COM  保留所有权利.
 ***************************************************************/
package com.anjbo.service.process;

import com.anjbo.bean.process.AppCancellationDto;
import com.anjbo.service.BaseService;


/**
 * 
 * @Author ANJBO Generator 
 * @Date 2018-07-03 17:23:32
 * @version 1.0
 */
public interface AppCancellationService extends BaseService<AppCancellationDto>{

	public void add(AppCancellationDto dto);
	
}
