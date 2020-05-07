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
import com.anjbo.bean.AgencyFeescaleSectionDto;
import com.anjbo.common.RespHelper;
import com.anjbo.common.RespData;
import com.anjbo.common.RespDataObject;
import com.anjbo.common.RespPageData;
import com.anjbo.common.RespStatus;
import com.anjbo.common.RespStatusEnum;
import com.anjbo.controller.IAgencyFeescaleSectionController;
import com.anjbo.service.AgencyFeescaleSectionService;

/**
 * 
 * @Author ANJBO Generator 
 * @Date 2018-05-10 16:54:58
 * @version 1.0
 */
@RestController
public class AgencyFeescaleSectionController extends BaseController implements IAgencyFeescaleSectionController{

	@Resource private AgencyFeescaleSectionService agencyFeescaleSectionService;

	/**
	 * 分页查询
	 * @author Generator 
	 */
	@Override
	public RespPageData<AgencyFeescaleSectionDto> page(@RequestBody AgencyFeescaleSectionDto dto){
		RespPageData<AgencyFeescaleSectionDto> resp = new RespPageData<AgencyFeescaleSectionDto>();
		try {
			resp.setCode(RespStatusEnum.SUCCESS.getCode());
			resp.setMsg(RespStatusEnum.SUCCESS.getMsg());
			resp.setRows(agencyFeescaleSectionService.search(dto));
			resp.setTotal(agencyFeescaleSectionService.count(dto));
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
	public RespData<AgencyFeescaleSectionDto> search(@RequestBody AgencyFeescaleSectionDto dto){ 
		RespData<AgencyFeescaleSectionDto> resp = new RespData<AgencyFeescaleSectionDto>();
		try {
			return RespHelper.setSuccessData(resp, agencyFeescaleSectionService.search(dto));
		}catch (Exception e) {
			logger.error("查询异常,参数："+dto.toString(), e);
			return RespHelper.setFailData(resp, new ArrayList<AgencyFeescaleSectionDto>(), RespStatusEnum.FAIL.getMsg());
		}
	}

	/**
	 * 查找
	 * @author Generator 
	 */
	@Override
	public RespDataObject<AgencyFeescaleSectionDto> find(@RequestBody AgencyFeescaleSectionDto dto){ 
		RespDataObject<AgencyFeescaleSectionDto> resp = new RespDataObject<AgencyFeescaleSectionDto>();
		try {
			return RespHelper.setSuccessDataObject(resp, agencyFeescaleSectionService.find(dto));
		}catch (Exception e) {
			logger.error("查找异常,参数："+dto.toString(), e);
			return RespHelper.setFailDataObject(resp, new AgencyFeescaleSectionDto(), RespStatusEnum.FAIL.getMsg());
		}
	}

	/**
	 * 新增
	 * @author Generator 
	 */
	@Override
	public RespDataObject<AgencyFeescaleSectionDto> add(@RequestBody AgencyFeescaleSectionDto dto){ 
		RespDataObject<AgencyFeescaleSectionDto> resp = new RespDataObject<AgencyFeescaleSectionDto>();
		try {
			return RespHelper.setSuccessDataObject(resp, agencyFeescaleSectionService.insert(dto));
		}catch (Exception e) {
			logger.error("新增异常,参数："+dto.toString(), e);
			return RespHelper.setFailDataObject(resp, new AgencyFeescaleSectionDto(), RespStatusEnum.FAIL.getMsg());
		}
	}

	/**
	 * 编辑
	 * @author Generator 
	 */
	@Override
	public RespStatus edit(@RequestBody AgencyFeescaleSectionDto dto){ 
		RespStatus resp = new RespStatus();
		try {
			agencyFeescaleSectionService.update(dto);
			return RespHelper.setSuccessRespStatus(resp);
		}catch (Exception e) {
			logger.error("编辑异常,参数："+dto.toString(), e);
			return RespHelper.failRespStatus();
		}
	}

	/**
	 * 删除
	 * @author Generator 
	 */
	@Override
	public RespStatus delete(@RequestBody AgencyFeescaleSectionDto dto){ 
		RespStatus resp = new RespStatus();
		try {
			agencyFeescaleSectionService.delete(dto);
			return RespHelper.setSuccessRespStatus(resp);
		}catch (Exception e) {
			logger.error("删除异常,参数："+dto.toString(), e);
			return RespHelper.failRespStatus();
		}
	}
		
}