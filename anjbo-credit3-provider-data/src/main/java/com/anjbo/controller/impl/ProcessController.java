/*
 *Project: ANJBO Generator
 ****************************************************************
 * 版权所有@2018 ANJBO.COM  保留所有权利.
 ***************************************************************/
package com.anjbo.controller.impl;

import java.util.ArrayList;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.anjbo.controller.BaseController;
import com.anjbo.bean.ProcessDto;
import com.anjbo.common.RespHelper;
import com.anjbo.common.RespData;
import com.anjbo.common.RespDataObject;
import com.anjbo.common.RespPageData;
import com.anjbo.common.RespStatus;
import com.anjbo.common.RespStatusEnum;
import com.anjbo.controller.IProcessController;
import com.anjbo.service.ProcessService;

/**
 * 
 * @Author ANJBO Generator 
 * @Date 2018-05-03 15:02:45
 * @version 1.0
 */
@RestController
public class ProcessController extends BaseController implements IProcessController{

	@Resource private ProcessService processService;

	/**
	 * 分页查询
	 * @author Generator 
	 */
	@Override
	public RespPageData<ProcessDto> page(@RequestBody ProcessDto dto){
		RespPageData<ProcessDto> resp = new RespPageData<ProcessDto>();
		try {
			resp.setCode(RespStatusEnum.SUCCESS.getCode());
			resp.setMsg(RespStatusEnum.SUCCESS.getMsg());
			resp.setRows(processService.search(dto));
			resp.setTotal(processService.count(dto));
		}catch (Exception e) {
			logger.error("分页异常,参数："+dto.toString(), e);
			resp.setCode(RespStatusEnum.FAIL.getCode());
			resp.setMsg(RespStatusEnum.FAIL.getMsg());
		}
		return resp;
	}


	/**
	 * 查询
	 * @author Generator 
	 */
	@Override
	public RespData<ProcessDto> search(@RequestBody ProcessDto dto){ 
		RespData<ProcessDto> resp = new RespData<ProcessDto>();
		try {
			return RespHelper.setSuccessData(resp, processService.search(dto));
		}catch (Exception e) {
			logger.error("查询异常,参数："+dto.toString(), e);
			return RespHelper.setFailData(resp, new ArrayList<ProcessDto>(), RespStatusEnum.FAIL.getMsg());
		}
	}

	/**
	 * 查找
	 * @author Generator 
	 */
	@Override
	public RespDataObject<ProcessDto> find(@RequestBody ProcessDto dto){ 
		RespDataObject<ProcessDto> resp = new RespDataObject<ProcessDto>();
		try {
			return RespHelper.setSuccessDataObject(resp, processService.find(dto));
		}catch (Exception e) {
			logger.error("查找异常,参数："+dto.toString(), e);
			return RespHelper.setFailDataObject(resp, new ProcessDto(), RespStatusEnum.FAIL.getMsg());
		}
	}

	/**
	 * 新增
	 * @author Generator 
	 */
	@Override
	public RespDataObject<ProcessDto> add(@RequestBody ProcessDto dto){ 
		RespDataObject<ProcessDto> resp = new RespDataObject<ProcessDto>();
		try {
			return RespHelper.setSuccessDataObject(resp, processService.insert(dto));
		}catch (Exception e) {
			logger.error("新增异常,参数："+dto.toString(), e);
			return RespHelper.setFailDataObject(resp, new ProcessDto(), RespStatusEnum.FAIL.getMsg());
		}
	}

	/**
	 * 编辑
	 * @author Generator 
	 */
	@Override
	public RespStatus edit(@RequestBody ProcessDto dto){ 
		RespStatus resp = new RespStatus();
		try {
			processService.update(dto);
			return RespHelper.setSuccessRespStatus(resp);
		}catch (Exception e) {
			logger.error("新增异常,参数："+dto.toString(), e);
			return RespHelper.failRespStatus();
		}
	}
		
}