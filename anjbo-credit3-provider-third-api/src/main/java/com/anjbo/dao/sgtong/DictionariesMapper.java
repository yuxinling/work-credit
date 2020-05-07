/*
 *Project: ANJBO Generator
 ****************************************************************
 * 版权所有@2018 ANJBO.COM  保留所有权利.
 ***************************************************************/
package com.anjbo.dao.sgtong;

import java.util.List;

import com.anjbo.bean.sgtong.DictionariesDto;
import com.anjbo.dao.BaseMapper;

/**
 * 
 * @Author ANJBO Generator 
 * @Date 2018-05-02 18:19:28
 * @version 1.0
 */
public interface DictionariesMapper extends BaseMapper<DictionariesDto>{
	public List<String> findDic(DictionariesDto dto);
}
