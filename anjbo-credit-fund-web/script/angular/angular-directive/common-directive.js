define(function(require, exports, module){
	exports.extend= function(app){  
	
		app.directive('test',function(){
			return{
				restrict:"E",
				templateUrl: '/template/test.html',
				transclude:true,
				link: function (scope) {
					
				}
			};
		});


		app.directive('select2',function($timeout){
			return{
				restrict:"A",
				scope:{ngModel:"="},
				link: function (scope,element) {
					scope.$watch("ngModel",function(newValue){
						$timeout(function(){
							var $element = $(element);
							$element.select2();
						});
					});
				}
			};
		});
		
		//下拉框多选
		app.directive('selectMultiple',function($timeout){
			return{
				restrict:"A",
				scope:{data:"@"},
				link: function (scope,element) {
					$timeout(function(){
						var $element = $(element);
						$element.select2({
					    	multiple: true
					    });
					});
					scope.$watch('data',function(newValue,oldValue){
						$timeout(function(){
							var $element = $(element);
							if(scope.data){
						    	$element.val(angular.fromJson(scope.data)).trigger('change');
							}else{
								$element.val(undefined).trigger('change');
							}
						},100);
					});
				}
			};
		});

		//选择字典
		//pcode 不写则查询同一type下pcode为null的数据
		//pcode 传""则查询同一type所有数据
		//pcode 传对应的值则查询同一type pcode为‘pcode’的数据
		app.directive('choiceDict',function($http,$timeout,dict){
			return{
				restrict:"A",
				template: '<option ng-repeat="dict in dicts" value="{{dict.code}}">{{dict.name}}</option>',
				scope:{choiceDict:"@",pcode:"@",ngModel:"="},
				link: function (scope,element) {
					scope.dicts = new Array();
					scope.$watch("pcode", function(newValue, oldValue) {
						scope.dicts = dict.choiceDict(scope.choiceDict,newValue);
						scope.dicts.unshift({uid:"",name:"请选择"});
						scope.$watch("ngModel",function(newValue){
							$timeout(function(){
								var $element = $(element);
								$element.select2();
							},100);
						});
				    });
				}
			};
		});

		//选择字典
		//pcode 不写则查询同一type下pcode为null的数据
		//pcode 传""则查询同一type所有数据
		//pcode 传对应的值则查询同一type pcode为‘pcode’的数据
		app.directive('choiceDictName',function($http,$timeout,dict){
			return{
				restrict:"A",
				template: '<option value="">请选择</option><option ng-repeat="dict in dicts" value="{{dict.name}}">{{dict.name}}</option>',
				scope:{choiceDictName:"@",pcode:"@",ngModel:"="},
				link: function (scope,element) {
					scope.dicts = new Array();
					scope.dicts.unshift({uid:"",name:"请选择"});
					scope.$watch("pcode", function(newValue, oldValue) {
						scope.dicts = dict.choiceDict(scope.choiceDictName,newValue);
						scope.$watch("ngModel",function(newValue){
							$timeout(function(){
								var $element = $(element);
								$element.select2();
							});
						});
				   });
				}
			};
		});

		//选择人员
		//type  选人是根据权限，还是根据角色 默认：权限
		//cityCode 城市  默认查询所有
		//agencgId 机构  默认所有快鸽
		//choicePersonnel 查询权限 或者 角色 的名称  如 查询 “渠道经理” 则 传  渠道经理对应的字段需要在后台判断
		app.directive('choicePersonnel',function($http,$timeout,route){
			return{
				restrict:"A",
				template: '<option ng-repeat="personnel in personnels" value="{{personnel.uid}}">{{personnel.name}}</option>',
				scope:{choicePersonnel:"@",cityCode:"@",agencgId:"@",type:"@",productCode:"@"},
				link: function (scope,element) {
					scope.personnels = new Array();
					function getPersonnel(){
						if(scope.agencgId==""){
							scope.personnels = null;
							return false;
						}
						var productId = 0;
						if(scope.productCode){
							productId = scope.cityCode + scope.productCode;
						}else if(route.getParams()){
							productId = route.getParams().cityCode+route.getParams().productCode;
						}

						$http({
							method: 'POST',
							url:'/credit/user/base/v/choicePersonnel',
							data:{"choicePersonnel":scope.choicePersonnel,"cityCode":scope.cityCode,"agencgId":scope.agencgId,"type":scope.type,"productId":productId}
						}).success(function(data){
							scope.personnels = data.data;
							scope.personnels.unshift({uid:"",name:"请选择"});
							$timeout(function(){
								var $element = $(element);
								$element.select2();
							});
						})
					}
					scope.$watch("cityCode", function(newValue, oldValue) {
						if(newValue || newValue == ""){
							getPersonnel();
						}
					});

					scope.$watch("agencgId", function(newValue, oldValue) {
						if(newValue){
							getPersonnel();
						}
					});

					scope.$watch("productCode", function(newValue, oldValue) {
						if(newValue){
							getPersonnel();
						}
					});
					
				}
			};
		});
		
		
		//选择人员
		//type  选人是根据权限，还是根据角色 默认：权限
		//cityCode 城市  默认查询所有
		//agencgId 机构  默认所有快鸽
		//choicePersonnel 查询权限 或者 角色 的名称  如 查询 “渠道经理” 则 传  渠道经理对应的字段需要在后台判断
		app.directive('choicePersonnel2',function($http,$timeout,route){
			return{
				restrict:"A",
				template: '<option ng-repeat="personnel in personnels" value="{{personnel.uid}}">{{personnel.name}}</option>',
				scope:{choicePersonnel2:"@",cityCode:"@",agencgId:"@",type:"@"},
				link: function (scope,element) {
					scope.personnels = new Array();
					function getPersonnel(){
						if(scope.agencgId==""){
							scope.personnels = null;
							return false;
						}
						var productId = 0;
						if(scope.cityCode){
							productId = scope.cityCode+route.getParams().productCode;
						}else{
							scope.personnels = null;
							return false;
						}

						$http({
							method: 'POST',
							url:'/credit/user/base/v/choicePersonnel',
							data:{"choicePersonnel":scope.choicePersonnel2,"cityCode":scope.cityCode,"agencgId":scope.agencgId,"type":scope.type,"productId":productId}
						}).success(function(data){
							scope.personnels = data.data;
							scope.personnels.unshift({uid:"",name:"请选择"});
							$timeout(function(){
								var $element = $(element);
								$element.select2();
							});
						})
					}
					scope.$watch("cityCode", function(newValue, oldValue) {
						if(newValue || newValue == ""){
							getPersonnel();
						}
					});

					scope.$watch("agencgId", function(newValue, oldValue) {
						if(newValue){
							getPersonnel();
						}
					});

					scope.$watch("productCode", function(newValue, oldValue) {
						if(newValue){
							getPersonnel();
						}
					});
					
				}
			};
		});

		//机构
		app.directive('agencyList',function($http,$timeout){
			return{
				restrict:"A",
				template: '<option ng-repeat="agency in agencyList" value="{{agency.id}}">{{agency.name}}</option>',
				link: function (scope,element,parent) {
					if(parent.agencyList.length == 0){
						$http({
							method: 'POST',
							url:'/credit/customer/agency/v/agencyList',
						}).success(function(data){
							scope.agencyList = data.data;
							scope.agencyList.unshift({id:"",name:"全部"});
							parent.agencyList = scope.agencyList;
							$timeout(function(){
								var $element = $(element);
								$element.select2();
							});
						})
					}
				}
			};
		});

		//银行
		app.directive('bankList',function($http,$timeout){
			return{
				restrict:"A",
				template: '<option value="">请选择</option><option ng-repeat="bank in bankList" value="{{bank.id}}">{{bank.name}}</option>',
				link: function (scope,element,parent) {
					scope.bankList = bank.getData();
					$timeout(function(){
						var $element = element.find(".bankId");
						$element.select2();
					});
				}
			};
		});

		//银行-支行
		//<bank-sub-bank bank-id="" sub-bank-id="" ></bank-sub-bank>
		app.directive('bankSubBank',function($http,$timeout,bank){
			return{
				restrict:"E",
				template: '<select class="form-control bankId" ng-disabled="{{isDisabled}}" style="width:130px;" ng-model="bankId"><option value="">请选择</option><option ng-repeat="bank in bankList" value="{{bank.id}}">{{bank.name}}</option></select>-<select style="width:130px;" class="form-control subBankId" ng-disabled="{{isDisabled}}" ng-model="subBankId" ><option ng-repeat="subBank in subBankList" value="{{subBank.id}}">{{subBank.name}}</option></select>',
				scope:{bankId:"=",subBankId:"=",isDisabled:"@"},
				link: function (scope,element,parent) {
					
					scope.bankList = bank.getData();
					scope.$watch("bankId",function(newValue, oldValue){
						$timeout(function(){
							var $element = element.find(".bankId");
							$element.select2();
						});
					});
					
					scope.$watch("bankId", function(newValue, oldValue) {
						scope.subBankList = bank.choiceSubBank(newValue);
						scope.subBankList.unshift({id:"",name:"请选择"});
						var fl = true;
						angular.forEach(scope.subBankList,function(data){
							if(data.id == scope.subBankId){
								fl = false;
							}
						})
						if(fl){scope.subBankId = "";}
						scope.$watch("subBankId",function(newValue1, oldValue1){
							$timeout(function(){
								var $element = element.find(".subBankId");
								$element.select2();
							});
						});
					});
					
				}
			};
		});

		//textarea自适应
		app.directive('textarea',function($timeout){
			return{
				restrict:"E",
				scope:{ngModel:"=",ngBind:"="},
				link: function (scope,element) {
					scope.$watch("ngModel",function(newValue,oldValue){
						$(element).txtaAutoHeight();
					})
					
					scope.$watch("ngBind",function(newValue,oldValue){
						$(element).txtaAutoHeight();
					})
				}
			};
		});
		
		//图片放大
		app.directive('galleryPic',function($timeout){
			return{
				restrict:"C",
				link: function () {
					$timeout(function(){
						$(".gallery-pic").click(function(){
				        	$.openPhotoGallery(this);
				    	})
					});
				}
			};
		});

		//图片放大
		app.directive('galleryPicImg',function($timeout){
			return{
				restrict:"C",
				template: '<img src="/images/chakan.png"  class="chakan-pic-img" ><img ng-show="false" src="{{title}}" class="gallery-pic">',
				scope:{title:"@"},
				link: function () {
					$timeout(function(){
						$(".chakan-pic-img").click(function(){
				        	$.openPhotoGallery($(this).next("img"));
				    	})
					});
				}
			};
		});

		//日期控件 在上
		app.directive('formDateu',function($timeout){
			return{
				restrict:"C",
				link: function () {
					$timeout(function(){
						$(".form_dateu").datetimepicker({format: 'yyyy-mm-dd',minView: "month",language: 'zh-CN',autoclose: true,todayBtn: true,pickerPosition: "top-right"});
						$(".form_dateu").focus(function(){
							var self = this;
							$(self).on('click',function(){
								$(self).blur();
							});
						});
					});

				}
			};
		});
		//日期控件 在下
		app.directive('formDate',function($timeout){
			return{
				restrict:"C",
				link: function () {
					$timeout(function(){
						$(".form_date").datetimepicker({format: 'yyyy-mm-dd',minView: "month",language: 'zh-CN',autoclose: true,todayBtn: true});
					});

				}
			};
		});
        //时间控件 在上
		app.directive('formDatetimeu',function($timeout){
			return{
				restrict:"C",
				link: function () {
					$timeout(function(){
						$(".form_datetimeu").datetimepicker({format: 'yyyy-mm-dd hh:ii',language: 'zh-CN',autoclose: true,todayBtn: true,pickerPosition: "top-right"});
					});
				}
			};
		});

		//时间控件 在下
		app.directive('formDatetime',function($timeout){
			return{
				restrict:"C",
				link: function () {
					$timeout(function(){
						$(".form_datetime").datetimepicker({format: 'yyyy-mm-dd hh:ii',language: 'zh-CN',autoclose: true,todayBtn: true});
					});
				}
			};
		});

	};
});