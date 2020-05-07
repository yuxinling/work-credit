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
import com.anjbo.controller.api.UserApi;
import com.anjbo.controller.BaseController;
import com.anjbo.bean.PreparationReplyrecordDto;
import com.anjbo.common.RespHelper;
import com.anjbo.common.RespData;
import com.anjbo.common.RespDataObject;
import com.anjbo.common.RespPageData;
import com.anjbo.common.RespStatus;
import com.anjbo.common.RespStatusEnum;
import com.anjbo.controller.IPreparationReplyrecordController;
import com.anjbo.service.PreparationReplyrecordService;

/**
 * 
 * @Author ANJBO Generator 
 * @Date 2018-06-25 16:16:14
 * @version 1.0
 */
@RestController
public class PreparationReplyrecordController extends BaseController implements IPreparationReplyrecordController{

	@Resource private PreparationReplyrecordService preparationReplyrecordService;
	
	@Resource private UserApi userApi;

	/**
	 * 分页查询
	 * @author Generator 
	 */
	@Override
	public RespPageData<PreparationReplyrecordDto> page(@RequestBody PreparationReplyrecordDto dto){
		RespPageData<PreparationReplyrecordDto> resp = new RespPageData<PreparationReplyrecordDto>();
		try {
			resp.setCode(RespStatusEnum.SUCCESS.getCode());
			resp.setMsg(RespStatusEnum.SUCCESS.getMsg());
			resp.setRows(preparationReplyrecordService.search(dto));
			resp.setTotal(preparationReplyrecordService.count(dto));
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
	public RespData<PreparationReplyrecordDto> search(@RequestBody PreparationReplyrecordDto dto){ 
		RespData<PreparationReplyrecordDto> resp = new RespData<PreparationReplyrecordDto>();
		try {
			return RespHelper.setSuccessData(resp, preparationReplyrecordService.search(dto));
		}catch (Exception e) {
			logger.error("查询异常,参数："+dto.toString(), e);
			return RespHelper.setFailData(resp, new ArrayList<PreparationReplyrecordDto>(), RespStatusEnum.FAIL.getMsg());
		}
	}

	/**
	 * 查找
	 * @author Generator 
	 */
	@Override
	public RespDataObject<PreparationReplyrecordDto> find(@RequestBody PreparationReplyrecordDto dto){ 
		RespDataObject<PreparationReplyrecordDto> resp = new RespDataObject<PreparationReplyrecordDto>();
		try {
			return RespHelper.setSuccessDataObject(resp, preparationReplyrecordService.find(dto));
		}catch (Exception e) {
			logger.error("查找异常,参数："+dto.toString(), e);
			return RespHelper.setFailDataObject(resp, new PreparationReplyrecordDto(), RespStatusEnum.FAIL.getMsg());
		}
	}

	/**
	 * 新增
	 * @author Generator 
	 */
	@Override
	public RespDataObject<PreparationReplyrecordDto> add(@RequestBody PreparationReplyrecordDto dto){ 
		RespDataObject<PreparationReplyrecordDto> resp = new RespDataObject<PreparationReplyrecordDto>();
		try {
			dto.setCreateUid(userApi.getUserDto().getUid());
			return RespHelper.setSuccessDataObject(resp, preparationReplyrecordService.insert(dto));
		}catch (Exception e) {
			logger.error("新增异常,参数："+dto.toString(), e);
			return RespHelper.setFailDataObject(resp, new PreparationReplyrecordDto(), RespStatusEnum.FAIL.getMsg());
		}
	}

	/**
	 * 编辑
	 * @author Generator 
	 */
	@Override
	public RespStatus edit(@RequestBody PreparationReplyrecordDto dto){ 
		RespStatus resp = new RespStatus();
		try {
			dto.setUpdateUid(userApi.getUserDto().getUid());
			preparationReplyrecordService.update(dto);
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
	public RespStatus delete(@RequestBody PreparationReplyrecordDto dto){ 
		RespStatus resp = new RespStatus();
		try {
			preparationReplyrecordService.delete(dto);
			return RespHelper.setSuccessRespStatus(resp);
		}catch (Exception e) {
			logger.error("删除异常,参数："+dto.toString(), e);
			return RespHelper.failRespStatus();
		}
	}
		
}