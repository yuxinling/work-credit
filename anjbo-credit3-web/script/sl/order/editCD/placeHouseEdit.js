angular.module("anjboApp").controller("placeHouseEditCDCtrl", function($scope, $timeout,$http,$rootScope, $state, route, box) {

	var params = route.getParams();
	$scope.cityCode = params.cityCode;
	$scope.productCode = params.productCode;
		
	if(!$scope.pro){
		//房产信息
		$http({
			method: 'POST',
			url: 'credit/order/house/v/query',
			data: params
		}).success(function(data) {
			$scope.pro = data.data;
			//有房产信息，不是提单，如果没有产权人，房产信息，默认新建一个
			if($scope.pro) {
				if(!$scope.pro.orderBaseHousePropertyDto || $scope.pro.orderBaseHousePropertyDto.length <= 0) {
					$scope.pro.orderBaseHousePropertyDto = new Array();
					$scope.pro.orderBaseHousePropertyDto.push(new Object());
					$scope.pro.orderBaseHousePropertyDto[0].city = String(params.cityCode);
				}
				if(!$scope.pro.orderBaseHousePropertyPeopleDto || $scope.pro.orderBaseHousePropertyPeopleDto.length <= 0) {
					$scope.pro.orderBaseHousePropertyPeopleDto = new Array();
					$scope.pro.orderBaseHousePropertyPeopleDto.push(new Object());
				}
				if(!$scope.pro.orderBaseHousePurchaserDto || $scope.pro.orderBaseHousePurchaserDto.length <= 0) {
					$scope.pro.orderBaseHousePurchaserDto = new Array();
					$scope.pro.orderBaseHousePurchaserDto.push(new Object());
				}
			}
			if($scope.pro.bussinessType<1) {
				$scope.pro.bussinessType = String("1");
			}else{
				$scope.pro.bussinessType = String($scope.pro.bussinessType);
			}
		})
	}
	//编辑保存房产信息
	$scope.submitHouse = function(isShow) {
		if(null==$scope.pro || undefined==$scope.houseForm){
			return;
		}
		$scope.pro.isFinish = $scope.houseForm.$valid?1:2;
		if($scope.pro.orderBaseHousePropertyDto&&$scope.pro.orderBaseHousePropertyDto.length>0){
			for(var i=0;i<$scope.pro.orderBaseHousePropertyDto.length;i++){
				$scope.pro.orderBaseHousePropertyDto[i].isFinish=$scope.houseForm.$valid?1:2;
			}
		}
		if($scope.pro.orderBaseHousePropertyPeopleDto&&$scope.pro.orderBaseHousePropertyPeopleDto.length>0){
			for(var i=0;i<$scope.pro.orderBaseHousePropertyPeopleDto.length;i++){
				$scope.pro.orderBaseHousePropertyPeopleDto[i].isFinish=$scope.housePropertyPeopleForm.$valid?1:2;
			}
		}
		if($scope.pro.orderBaseHousePurchaserDto&&$scope.pro.orderBaseHousePurchaserDto.length>0){
			for(var i=0;i<$scope.pro.orderBaseHousePurchaserDto.length;i++){
				$scope.pro.orderBaseHousePurchaserDto[i].isFinish=$scope.housePurchaserForm.$valid?1:2;
			}
		}
		$http({
			method: 'POST',
			url: "/credit/order/house/v/update",
			data: $scope.pro
		}).success(function(data) {
			if(data.code == "SUCCESS" && !isShow) {
				box.boxAlert(data.msg);
			}
		})
	}
	
	//切换tab时保存房产信息
	$rootScope.$watch("showView",function(newValue,oldValue){
		if(oldValue == 3 && oldValue != newValue){
			//$scope.submitHouse(true);
		}
	});
	
	//添加房产信息
	$scope.addChanDto = function() {
		if($scope.pro.orderBaseHousePropertyDto.length == 0) {
			$scope.pro.orderBaseHousePropertyDto = new Array();
			$scope.pro.orderBaseHousePropertyDto.push(new Object());
			$scope.pro.orderBaseHousePropertyDto[0].city = String(params.cityCode);
		} else {
			$scope.pro.orderBaseHousePropertyDto.push(new Object());
			$scope.pro.orderBaseHousePropertyDto[$scope.pro.orderBaseHousePropertyDto.length - 1].city = String(params.cityCode);
		}
	}
	
	//删除房产信息
	$scope.deleteChanDto = function(index) {
		box.confirmAlert("删除房产信息","确定删除房产信息吗？",function(){
			$timeout(function(){
				$scope.pro.orderBaseHousePropertyDto.splice(index, 1);
			});
		});
	}
	
	//添加产权人
	$scope.addChanQuan = function() {
		if($scope.pro.orderBaseHousePropertyPeopleDto.length == 0) {
			$scope.pro.orderBaseHousePropertyPeopleDto = new Array();
			$scope.pro.orderBaseHousePropertyPeopleDto.push(new Object());
		} else {
			$scope.pro.orderBaseHousePropertyPeopleDto.push(new Object());
		}
	}
	
	//删除产权人
	$scope.deleteChanQuan = function(index) {
		box.confirmAlert("删除产权人","确定删除产权人吗？",function(){
			$timeout(function(){
				$scope.pro.orderBaseHousePropertyPeopleDto.splice(index, 1);
			});
		});
	}
	
	//添加买方
	$scope.addMaiFang = function() {
		if($scope.pro.orderBaseHousePurchaserDto.length == 0) {
			$scope.pro.orderBaseHousePurchaserDto = new Array();
			$scope.pro.orderBaseHousePurchaserDto.push(new Object());
		} else {
			$scope.pro.orderBaseHousePurchaserDto.push(new Object());
		}
	}
	
	//删除买房
	$scope.deleteMaiFang = function(index) {
		box.confirmAlert("删除买房人","确定删除买房人吗？",function(){
			$timeout(function(){
				$scope.pro.orderBaseHousePurchaserDto.splice(index, 1);
			});
		});
	}

});