﻿angular.module("anjboApp", ['ngCookies']).config(['$httpProvider', function($httpProvider) {
	$httpProvider.defaults.withCredentials = true;
}]).controller("login", function($scope, $location, $http, $cookies, $cookieStore) {
	function checkBrowser() {
		var is360 = navigator.mimeTypes[2].type == 'application/vnd.chromium.remoting-viewer' ? true : false;
		var isChrome = navigator.userAgent.indexOf("Chrome") > -1 && !is360 && navigator.userAgent.indexOf("Edge") < 0;
		if(!isChrome) {
			alert("请下载谷歌浏览器后再执行此操作");
			location.href = 'http://www.google.cn/chrome/browser/desktop/';
		}
	};
	checkBrowser();

	Notification.requestPermission(function(permission) {});

	var url = $location.absUrl();
	if(!(url.indexOf("localhost") != -1 || url.indexOf("127.0.0.1") != -1)) {
		if(url.indexOf("https") == -1) {
			url = url.replace("http", "https");
			window.location.href = url;
		}
	}

	$scope.validateCodeUrl = '/credit/user/auth';
	$scope.changeValidateCode = function() {
		$scope.validateCodeUrl = '/credit/user/auth?' + Math.random();
	}
	$scope.changeValidateCodeSMS = function(e) {
		$scope.errorTxt = "";
		$scope.loginForm.validateCodeSms.$dirty = false;
		if(undefined == $scope.loginForm.userMobile.$modelValue || undefined == $scope.loginForm.validateCodeToSms.$modelValue) {
			$scope.loginForm.userMobile.$dirty = true;
			$scope.loginForm.validateCodeToSms.$dirty = true;
			return false;
		}
		$http({
			method: 'POST',
			url: '/credit/user/sendSMS',
			data: {
				"userMobile": $scope.userMobile,
				"validateCode": $scope.validateCodeToSms
			}
		}).success(function(data) {
			if(data.code == "SUCCESS") {
				$scope.countdown("sendSMSCode");
			} else {
				$scope.changeValidateCode();
				$scope.errorTxt = data.msg;
			}
		})
	}
	$scope.myKeyup = function(e) {
		var keycode = window.event ? e.keyCode : e.which;
		if(keycode == 13) {
			$scope.login();
		}
	};

	$scope.login = function() {
		var loginParam;
		if($("#loginSwitch1").is(':hidden')) {
			if(undefined == $scope.loginForm.userAccount.$modelValue || undefined == $scope.loginForm.userPassword.$modelValue || undefined == $scope.loginForm.validateCode.$modelValue) {
				$scope.loginForm.userAccount.$dirty = true;
				$scope.loginForm.userPassword.$dirty = true;
				$scope.loginForm.validateCode.$dirty = true;
				return false;
			}
			loginParam = {
				"userAccount": $scope.userAccount,
				"userPassword": $scope.userPassword,
				"validateCode": $scope.validateCode
			};
		} else {
			$scope.loginForm.validateCodeToSms.$dirty = false;
			if(undefined == $scope.loginForm.userMobile.$modelValue || undefined == $scope.loginForm.validateCodeSms.$modelValue) {
				$scope.loginForm.userMobile.$dirty = true;
				$scope.loginForm.validateCodeSms.$dirty = true;
				return false;
			}
			loginParam = {
				"userMobile": $scope.userMobile,
				"validateCode": $scope.validateCodeSms
			};
		}
		$http({
			method: 'POST',
			url: '/credit/user/login',
			data: loginParam
		}).success(function(data) {
			console.log(data)
			$cookieStore.remove("pageParams");
			if(data.code == "SUCCESS") {
				window.location.href = "index.html#/orderList";
			} else {
				if($("#loginSwitch1").is(':hidden')) {
					$scope.changeValidateCode();
				}
				$scope.errorTxt = data.msg;
			}
		})
	}

	$scope.loginSwitch = function(e, switchFlag) {
		if(switchFlag == 0) {
			$(".error .errorG0").addClass("ng-hide");
			$("#loginSwitch0").hide();
			$("#loginSwitch1").show();
		} else {
			$(".error .errorG1").addClass("ng-hide");
			$("#loginSwitch0").show();
			$("#loginSwitch1").hide();
		}
	}
	//倒计时
	$scope.countdown = function(id) {
		$scope.isdis = true;
		var codeTime = 60;
		var codeState = "";
		var st = setInterval(function() {
			if(codeTime > 1) {
				codeState = (--codeTime + 's');

			} else {
				clearInterval(st);

				codeState = '获取短信验证码';
				$(".yanzheng-box a").removeClass("dis");
				$scope.isdis = false;
				$scope.changeValidateCode();
				$scope.$apply();
			}
			$("#" + id).text(codeState);
		}, 1000);
	}
});