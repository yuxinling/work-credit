/*
 *Project: ANJBO Generator
 ****************************************************************
 * 版权所有@2018 ANJBO.COM  保留所有权利.
 ***************************************************************/
package com.anjbo.service.impl.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjbo.bean.finance.LendingInterestDto;
import com.anjbo.dao.finance.LendingInterestMapper;
import com.anjbo.service.finance.LendingInterestService;
import com.anjbo.service.impl.BaseServiceImpl;

/**
 * 
 * @Author ANJBO Generator 
 * @Date 2018-07-03 18:34:33
 * @version 1.0
 */
@Service
public class LendingInterestServiceImpl extends BaseServiceImpl<LendingInterestDto>  implements LendingInterestService {
	@Autowired private LendingInterestMapper lendingInterestMapper;

}
