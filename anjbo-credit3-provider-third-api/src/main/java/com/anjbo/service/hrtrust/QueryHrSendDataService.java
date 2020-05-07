package com.anjbo.service.hrtrust;

import java.util.List;
import java.util.Map;

public interface QueryHrSendDataService {
	
	public Map<String,Object> getLcAppoint (String orderNo) ;

	public Map<String,Object> getLcApplAppt (String orderNo) ;

	public Map<String,Object> getLcApptIndiv (String orderNo) ;

	public Map<String,Object> getKgAppoint (String orderNo) ;

	public Map<String,Object> getKgApproval (String orderNo) ;

	public Map<String,Object> getKgHouse (String orderNo) ;

	public Map<String,Object> getKgIndiv (String orderNo) ;

	public List<Map<String,Object>> getFileApply (String orderNo) ;

	public Map<String,Object> selectHrtrustLoan(String orderNo) ;

	public Map<String,Object> getBorrowRepayment (String orderNo) ;

	public Map<String,Object> getRepaymentRegister (String orderNo) ;
	
	public Map<String,Object> getLoanStatus (String orderNo) ;
	
	
}
