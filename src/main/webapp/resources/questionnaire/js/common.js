/* by ohkei 66005199@qq.com */

var twTimer = 0.7;
var touchTf = true;
var webPath = "http://homecredit.agenda-bj.com/";
//webPath = "../";
webPath = "http://hcc.mmuugg.com/";
webPath = "https://www.mmuugg.com/";
//webPath = "https://cnazweb.chinacloudsites.cn/";
webPath = "https://"+window.location.host+"/";
//alert("webPath:"+webPath);

//输出
function trace(str){
	console.log(str);
}
//淡入
function alphaUp(_obj,_timer){
	if(!_timer){
		_timer = twTimer;
	}
    _obj.show();
    _obj.css({opacity:0});
    TweenMax.to(_obj, _timer, {autoAlpha:1});
}
function alphaUp_(_obj,_timer){
	if(!_timer){
		_timer = twTimer;
	}
	_obj.show();
    TweenMax.to(_obj, _timer, {autoAlpha:1});
}
function alphaUp_fn(_obj,_fn,_timer){
	if(!_timer){
		_timer = twTimer;
	}
	_obj.show();
	_obj.css({opacity:0});
    TweenMax.to(_obj,_timer, {autoAlpha:1,onComplete:_fn});
}
//淡入-延迟
function alphaUp_delay(_obj,_delay,_origin,_timer){
	if(!_timer){
		_timer = twTimer;
	}
	_obj.show();
	var _top = _obj.css("top").split("px")[0];
	var _left = _obj.css("left").split("px")[0];
	var _bottom = _obj.css("bottom").split("px")[0];
	if(!_origin){
		if(_origin==="bottom"){
			_obj.css({opacity:0,bottom:_bottom+50+"px"});
			TweenMax.to(_obj, _timer, {autoAlpha:1,delay:_delay,bottom:_bottom+"px"});
			return;
		}else{
			_obj.css({opacity:0,top:_top-50+"px"});
		}
	}else{
		if(_origin==="left"){
			_obj.css({opacity:0,left:"-640px"});
			TweenMax.to(_obj, _timer, {autoAlpha:1,delay:_delay,left:_left+"px"});
			return;
		}else{
			_obj.css({opacity:0});
		}
	}
    TweenMax.to(_obj, _timer, {autoAlpha:1,delay:_delay,top:_top+"px"});
}
//淡入-缩放
function alphaUp_scale(_obj,_delay,_timer){
	if(!_timer){
		_timer = 1;
	}
	_obj.show();
	_obj.css({opacity:0,"width":"1px","height":"1px"});
    TweenMax.to(_obj, _timer, {autoAlpha:1,delay:_delay,width:"auto",height:"auto"});
}
//淡出
function alphaDown(_obj,_timer){
	if(!_timer){
		_timer = twTimer;
	}
    //touchTF = false;
    TweenMax.to(_obj, twTimer, {autoAlpha:0,onComplete:alphaDownEnd});
    function alphaDownEnd(){
        //touchTF = true;
    }
}
function alphaDown_fn(_obj,_fn,_timer){
	if(!_timer){
		_timer = twTimer;
	}
	TweenMax.to(_obj, twTimer, {autoAlpha:0,onComplete:_fn});
}
//判断是否PC
function isPc() {
	var userAgentInfo = navigator.userAgent;
	var agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");
	var flag = true;
	for (var v = 0; v < agents.length; v++) {
		if (userAgentInfo.indexOf(agents[v]) > 0) { flag = false; break; }
	}
	return flag;
}
//下拉框
//setSel(".Prov select", prov_array, ".Prov p");
//setSel(".City select", city_array[0], ".City p");
//setSel(".Shop select", shop_array[0][0], ".Shop p");
function setSel(_selectObj, _array, _spanObj, nameTF) {
	$(_selectObj).empty();
	var selectObj = document.querySelector(_selectObj);
	
    var iLen = _array.length;
    var selectedValue = ";";
    selectObj.options.length = 0;
    //alert("iLen:"+iLen);
    if(iLen==0){
    	return;
    }
    for(var i = 0; i < iLen; i++) {
    	var _val = _array[i];
    	if(nameTF){
    		_val = _array[i].name;
    	}
        selectObj.options.add(new Option(_val ,i-1));
        
    	if(i == 0){
    		selectedValue = _val;
    		selectObj.options[i].selected = true;
    	}
    }
    //trace("selectedValue:"+selectedValue);
	if(_spanObj){
		var spanObj = $(_spanObj);
		//alert(selectedValue);
    	spanObj.text(selectedValue);
	}	
}
/*$("#city").on("change", function () {
	cityId = document.querySelector("#city").selectedIndex;
	//cityId = $(this).get(0).selectedindex;
	cityName = $(this).find("option:selected").text();
});*/
function setComma(_num){
	var $num = String(Math.round(_num));
	var len = $num.length;
	var str = "";
	if(len<=3){
		str = $num;
	}else if(len==4){
		str = $num.substr(0,1)+","+$num.substr(1,3);
	}else if(len==5){
		str = $num.substr(0,2)+","+$num.substr(2,3);
	}else if(len==6){
		str = $num.substr(0,3)+","+$num.substr(3,3);
	}else if(len==7){
		str = $num.substr(0,1)+","+$num.substr(1,3)+","+$num.substr(4,3);
	}else if(len==8){
		str = $num.substr(0,2)+","+$num.substr(2,3)+","+$num.substr(5,3);
	}else if(len==9){
		str = $num.substr(0,3)+","+$num.substr(3,3)+","+$num.substr(6,3);
	}else if(len==10){
		str = $num.substr(0,1)+","+$num.substr(1,3)+","+$num.substr(4,3)+","+$num.substr(6,3);
	}else if(len==11){
		str = $num.substr(0,2)+","+$num.substr(2,3)+","+$num.substr(5,3)+","+$num.substr(7,3);
	}else if(len==12){
		str = $num.substr(0,3)+","+$num.substr(3,3)+","+$num.substr(6,3)+","+$num.substr(8,3);
	}
	//trace("setComma str:"+str);
	return str;
}
// 验证中文名称
function checkName(name) {
	var pattern = /^[\u4E00-\u9FA5]{1,6}$/;
	return pattern.test(name);
}
//校验手机号
function checkTel(str){
    var regExp = "^[1][3,4,5,7,8]\\d{9}$";
    var regExpS = new RegExp(regExp,"");
    return regExpS.test(str);
}
// 验证身份证 
function checkIdc(card) { 
	var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
	return pattern.test(card); 
} 


//获取url中的参数
function getParam(name) {
	if(window.location.search.indexOf(name)==-1){
		return "";
	}
	var db_arr = window.location.search.substr(1).split("&");
    for(var i=0;i<db_arr.length;i++){
		if(db_arr[i].indexOf(name)!=-1){
			return db_arr[i].split("=")[1];
		}
	}
}
//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}
//获取页面url参数
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) return unescape(r[2]); return null;
}
//获取文件名
function getPageName(){
	var _url = window.location.href;
    var _name = _url.split(".htm")[0].split("/").pop();
    return _name;
}

//设置Cookie
function setCookie(name,value,time){
    var msec = getMsec(time); //获取毫秒
    var exp = new Date();
    exp.setTime(exp.getTime() + msec*1);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
	console.log("setCookie:",name + "="+ escape (value) + ";expires=" + exp.toGMTString());
}
//将字符串时间转换为毫秒,1秒=1000毫秒
function getMsec(str){
   var timeNum = str.substring(0,str.length-1)*1; //时间数量
   var timeStr = str.substring(str.length-1,str.length); //时间单位前缀，如h表示小时
   
   if (timeStr=="s") //20s表示20秒
   {
        return timeNum*1000;
   }
   else if (timeStr=="h") //12h表示12小时
   {
       return timeNum*60*60*1000;
   }
   else if (timeStr=="d")
   {
       return timeNum*24*60*60*1000; //30d表示30天
   }
}
/*function getCookie(name){
    var arr,reg = new RegExp("(^| )"+name+"=([^;]*)(;|$)"); //正则匹配
	alert(name);
	alert(arr);
	alert(document.cookie.match(reg));
    if(arr==document.cookie.match(reg)){
		alert(unescape(arr[2]));
        return unescape(arr[2]);
    }else{
        return null;
    }
}*/
function getCookie(name){
	var strcookie = document.cookie;//获取cookie字符串
	var arrcookie = strcookie.split("; ");//分割
	//遍历匹配
	for ( var i = 0; i < arrcookie.length; i++) {
		var arr = arrcookie[i].split("=");
		if (arr[0] == name){
			return arr[1];
		}
	}
	return "";
}
Array.prototype.insert = function (index, item) {
  this.splice(index, 0, item);
};
//Resize刷新
//$(window).resize(function(){
//	//trace("common resize");
//	//history.go(0);
//	location.reload();
//});

//判断横屏
var $scroll = true;
function orient() {
	var _orient = $(window).width()/$(window).height();
	console.log("_orient:"+_orient);
	/*if(Number(_orient)>1){
		//横屏
		alphaUp($("#window_mc"));
	}else{
		//竖屏
		alphaDown($("#window_mc"));
	}*/
	
	/*
	 * 屏幕方向对应的window.orientation值：
	ipad： 90 或 -90 横屏
	ipad： 0 或180 竖屏
	Andriod：0 或180 横屏
	Andriod： 90 或 -90 竖屏
	*/
	$('html').scrollTop(0);
	var ori = window.orientation;
	//alert("ori:"+ori);
	
	if (ori == 180 || ori== 0) {
		//alphaDown($("#window_mc"));
		$("#window_mc").hide();
		//$('html,body').removeClass('ovfHiden');
		//$('html,body').css({"overflow": "auto","height": "auto"});
		$scroll = true;
		$(".main-ct").show();
		$("body").css({"background":"rgb(202,205,208)"});
		return;
        if(browser.versions.android){
	        console.log("android横屏");
	        alphaDown($("#window_mc"));
		}else{
	        console.log("ios竖屏");
	        alphaDown($("#window_mc"));
		}
    }
    if(ori == 90 || ori == -90) {
		//alphaUp($("#window_mc"));
		$("#window_mc").show();
		//$('html,body').addClass('ovfHiden');
		$scroll = false;
		return;
		alert("browser.versions.android:"+browser.versions.android);
        if(browser.versions.android){
	        console.log("android竖屏");
	        alphaDown($("#window_mc"));
		}else{
	        alert("ios横屏");
	        alphaUp($("#window_mc"));
		}
    }
}
//页面加载时调用
$(function(){
	orient();
	$(window).scroll(function(){
		if(!$scroll){
			$(window).scrollTop(0);
			$(".main-ct").hide();
			$("body").css({"background":"rgb(46,50,51)"});
		}else{
			$(".main-ct").show();
			$("body").css({"background":"rgb(202,205,208)"});
		}
	});
});
//用户变化屏幕方向时调用
$(window).bind( "orientationchange", function(e){
	orient();
});
