/*by ohkei QQ：66005199*/

//声明
var twTimer = 0.8;
var loadNum = 0;
var si_load = -11;
var webPath = "";

var testTF = false;
	
var jsonAll;
var touchTF = true;

var utm_source = String(String(getUrlParam("utm_source")).toLowerCase())||"";
var utm_medium = String(String(getUrlParam("utm_medium")).toLowerCase())||"";
var utmsource = String(String(getUrlParam("utm_source")).toLowerCase())||"";
var utmmedium = String(String(getUrlParam("utm_medium")).toLowerCase())||"";
var openid = getUrlParam("openid")||"";

//trace
function trace(arguments){
	console.log(arguments);
}
//loading
function loadAni(){
	loadNum++;
	if(loadNum>3){
		loadNum = 0;
	}
	if(loadNum==0){
		$("#loading").find("p").text("Loading");	
	}else if(loadNum==1){
		$("#loading").find("p").text("Loading .");	
	}else if(loadNum==2){
		$("#loading").find("p").text("Loading . .");	
	}else if(loadNum==3){
		$("#loading").find("p").text("Loading . . .");	
	}
}

//淡入
function alphaUp(_obj,_delay,_timer){
	if(!_timer){
		_timer = twTimer;
	}
    _obj.show();
	var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1;
	if(isAndroid){
		return;
	}
    _obj.css({opacity:0});
	if(!_delay){
		_delay = 0;
	}
	TweenMax.to(_obj, _timer, {delay:_delay,autoAlpha:1});
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
	if(!_origin){
		_obj.css({opacity:0,top:_top-50+"px"});
	}else{
		if(_origin==="left"){
			_obj.css({opacity:0,left:"-640px"});
			//alert(_left);
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
	var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1;
	if(isAndroid){
		_obj.hide();
		return;
	}
    TweenMax.to(_obj, twTimer, {autoAlpha:0,onComplete:alphaDownEnd});
    function alphaDownEnd(){
        //touchTF = true;
    }
}
//旋转
function rota360(_obj){
	//TweenMax.to($(_obj), twTimer, {rotation:360,delay:twTimer * 0.6});
	/*if($(_obj).hasClass(rota360)){
		$(_obj).removeClass("rota360");
	}*/
	setTimeout(function(){
		$(_obj).addClass("rota360");
	},twTimer*80);
	
}
//动画
function iAnimate(_obj,_delay,_ani){
	setTimeout(function(){
		$(_obj).addClass("animated "+_ani);
	},_delay);
}

//up动画
function upAni(_obj,_topEnd,_delay){
	var _topInit = _topEnd+50;
	_obj.css({opacity:0,top:_topInit+"px"});
	TweenMax.to(_obj,twTimer,{autoAlpha:1,top:_topEnd+"px",delay:_delay});
}
//down动画
function downAni(_obj,_delay){
	if(!_delay){
		_delay = 0;
	}
	_obj.show();
	_obj.css({opacity:0,top:"-50px"});
	TweenMax.to(_obj,twTimer,{autoAlpha:1,top:0,delay:_delay});
}
//scale动画
function scaleAni(_obj,_delay){
	_obj.show();
	if(!_delay){
		_delay = 0;
	}
	TweenMax.from(_obj,twTimer,{opacity:0,scaleX:1.5,scaleY:1.5,delay:_delay});
}
//校验手机号
function checkTel(str){
    var regExp = "^[1][3,4,5,7,8]\\d{9}$";
    var regExpS = new RegExp(regExp,"");
    return regExpS.test(str);
}
//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
//获取文件名
function getPageName(_url){
    var _name = _url.split(".htm")[0].split("/").pop();
    return _name;
}
//删除url中的参数
//delUrlParam("openid");
function delUrlParam(_str){
	var _new = "";
	var _search = window.location.search;
	var _array = _search.split("&");
	var _len = _array.length;
	if(_len>0){
		for(var i = 0;i<_len;i++){
			var _param = _array[i].split("=")[0];
			if(_param.toLowerCase()==_str||_param.toLowerCase()==("?"+_str)){
				_array.splice(i, 1);
				break;
			}
		}
		_new = _array.join("&");
		//alert(_new);
		return _new;
	}
}
//设置文本框
function setTxt(_obj,_init,valTF){
	//console.log(_init);
	if(valTF){
		_obj.val(_init);
	    _obj.focus(function(){
	    	if($(this).val()==_init){
	    		$(this).val("");
	    	}
		});
		_obj.blur(function(){
			if($(this).val()==""){
	    		$(this).val(_init);
	    	}
		});
	}else{
		_obj.text(_init);
	    _obj.focus(function(){
	    	if($(this).text()==_init){
	    		$(this).text("");
	    	}
		});
		_obj.blur(function(){
			if($(this).text()==""){
	    		$(this).text(_init);
	    	}
		});
	}
}
//下拉框
//setSel(document.querySelector(".Prov select"), $(".Prov p"),prov_array);
//setSel(document.querySelector(".City select"), $(".City p"),city_array[0]);
//setSel(document.querySelector(".Shop select"), $(".Shop p"),shop_array[0][0]);
function setSel(selectObj, spanObj, _array, nameTF) {
    var iLen = _array.length;
    var selectedValue = ";";
    selectObj.options.length = 0;
    //console.log("iLen:"+iLen);
    if(iLen==0){
    	return;
    }
    for(var i = 0; i < iLen; i++) {
    	var _val = _array[i];
    	if(nameTF){
    		_val = _array[i].name;
    	}
        selectObj.options.add(new Option(_val , _val));
        //&&spanObj!=$("#Shop")
    	if(i == 0){
    		selectedValue = _val;
    		selectObj.options[i].selected = true;
    	}
    }
    //console.log("selectedValue:"+selectedValue);
    spanObj.text(selectedValue);	
}

//时间戳
function date_getTime(){
	var time = new Date();
	var now = time.getTime();
	return now;	
}
//弧度转换角度
function a2d (n){
	return n*180/Math.PI;
}
//判断PC
//alert(isPc());
function isPc(){
	var urlhash = window.location.hash;
	if (!urlhash.match("fromapp")){
		if ((navigator.userAgent.match(/(iPhone|iPod|Android|ios|iPad)/i))){
			//alert("你是手机浏览器");
			return false;
		}
	}
	return true;
}
//判断微信
function isWx(){
    var ua = navigator.userAgent.toLowerCase();
    if(ua.match(/MicroMessenger/i)=="micromessenger") {
        return true;
    } else {
        return false;
    }
}
//判断winPhone
function isWinphone() {
	var userAgentInfo = navigator.userAgent.toLowerCase();
	var flag = false;
	if (userAgentInfo.indexOf("windows phone")!=-1){ flag = true;}
	return flag;
}
//判断图片是否存在 
function checkImg(imgurl) {
    var imgObj = new Image();  
    imgObj.src = imgurl;  
    //没有图片，则返回-1  
    if (imgObj.fileSize > 0 || (imgObj.width > 0 && imgObj.height > 0)) {  
    	return true;  
    } else {  
		return false;
    }  
}
//判断浏览器
var browser = {
	versions: function() {
	var u = navigator.userAgent, app = navigator.appVersion;
		return {//移动终端浏览器版本信息 
			trident: u.indexOf('Trident') > -1, //IE内核
			presto: u.indexOf('Presto') > -1, //opera内核
			webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
			gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
			mobile: !!u.match(/AppleWebKit.*Mobile.*/) || !!u.match(/AppleWebKit/), //是否为移动终端
			ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
			android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
			iPhone: u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, //是否为iPhone或者QQHD浏览器
			iPad: u.indexOf('iPad') > -1, //是否iPad
			webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
		};
	}(),
	language: (navigator.browserLanguage || navigator.language).toLowerCase()
}
//滚动
var currentPosition,si_scroll; 
function runTo(tarY){
	currentPosition = document.documentElement.scrollTop || document.body.scrollTop; 
	currentPosition += 20; 
	//console.log(currentPosition+","+tarY+","+$(document).height()+","+$(window).height());
	if(currentPosition>=tarY-$(window).height()){
		clearInterval(si_scroll);
		document.body.scrollTop = tarY; 
		console.log("scroll end");
	}else{
		document.body.scrollTop = currentPosition;
		console.log("scroll step");
	}
}
function gotoBtm(){
	clearInterval(si_scroll);
	si_scroll = setInterval(runTo,10,document.body.scrollHeight);
}
//--------- 判断横屏 ---------
function orient() {	
	/*
	 * 屏幕方向对应的window.orientation值：
	ipad： 90 或 -90 横屏
	ipad： 0 或180 竖屏
	Andriod：0 或180 横屏
	Andriod： 90 或 -90 竖屏
	*/
	//console.log("window.orientation:"+window.orientation);
	if ( window.orientation == 180 || window.orientation==0 ) {
        if(browser.versions.android){
	        console.log("android横屏");
	        alphaDown($("#window_mc"));
		}else{
	        console.log("ios竖屏");
	        alphaDown($("#window_mc"));
		}
    }
    if( window.orientation == 90 || window.orientation == -90 ) {
        if(browser.versions.android){
	        console.log("android竖屏");
	        alphaDown($("#window_mc"));
		}else{
	        console.log("ios横屏");
	        alphaUp($("#window_mc"));
		}
    }
}
//页面加载时调用
;$(function(){
	orient();
});
//用户变化屏幕方向时调用
$(window).bind( "orientationchange", function(e){
	orient();
});

//非微信浏览器位移page
/*if(!isWx()){
	$(".page").css("top","110px");
}*/

var u = navigator.userAgent;
var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1; //android终端
var isIos = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
//alert('是否是Android：'+isAndroid);
//alert('是否是iOS：'+isiOS);

//阻止touchmove默认事件
/*$("body").on("touchmove", function (e) {
	e.preventDefault();
});*/


/*by ohkei QQ：66005199*/