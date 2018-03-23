/*==================== AJAX start ====================*/
  (function( window, document, undefined ){
	var myLab = {
		//***********===//***ajax*异*步*请*求*数*据***\\===**********\\
	/*
	type: 请求的方法 "get" 或 "post"， 默认: "get"; （注：jsonp模式下为 "get"）
	url: 发送请求的地址。
	data: 发送到服务器的数据，url后的传参 'foo=bar1&foo2=bar2'
	dataType: 服务器返回的数据类型 默认: text
				"json": 返回 JSON 数据
				"jsonp": 跨域传输
				"text": 返回纯文本字符串
	processData: 是否对 返回结果的数据 自动转换数据格式, 默认: true; （注：jsonp模式下此参数不参与）
	async: 是否异步加载，默认: true （注：jsonp模式下此参数不参与）
	cache: 默认: true，设置为 false 将不缓存此页面。 （注：jsonp模式下 默认: false）
	success: 请求成功时调用此函数，如带参数 data，可获得返回的数据
	error: 请求失败时调用此函数， 如带参数 data， 则抛出错误信息
	*/
	ajax : function( json ){
		var type = json.type !== "post" || json.dataType === "jsonp" ? "get" : "post";
		
		var url = null;
		if( typeof json.url !== "undefined" &&  json.url && json.url.length > 0 ){
			url = json.url;
		} else {
			alert( "发送请求的地址url必须是字符串且不能为空！" );
			return;
		};
		
		var data = json.data;
		//处理发送数据格式
		if(myLab.isJson( data )){
			var arr = [];
			for(var i in data){
				arr.push(i+'='+data[i]);
			}
			data = arr.join('&'); 
			//alert(data);
		}
		
		var dataType = json.dataType !== undefined && typeof json.dataType === "string" ? json.dataType : "text";
		var processData = json.processData !== undefined && typeof json.processData === "boolean" ? json.processData : true;
		var async = json.async !== undefined && typeof json.async === "boolean" ? json.async : true;
		var cache = json.cache !== undefined && typeof json.cache === "boolean" ? json.cache : true;
		var jsonpcache = json.cache !== undefined && typeof json.cache === "boolean" && dataType === "jsonp" ? json.cache : false;
		var success = json.success;
		var error = json.error;
		
		if( !cache ){ data += '&' + this.date_getTime(); };
	
		if( type === 'get' && data ) { url += '?' + data; };
		
		if( dataType === "jsonp" ){ this.jsonp( {"url":url, "cache":jsonpcache, "jsonp": json.jsonp, "success": success, "error": error} ); return; };//调用跨域传输。。。 不执行以下语句！
		
		var xhr = null;
		try {
			xhr = new XMLHttpRequest();
		} catch (e) {
			xhr = new ActiveXObject('Microsoft.XMLHTTP');
		};
		
		xhr.open( type, url, async );
		//alert(type+','+url)
		if( type === 'get' ) {
			xhr.send();
		} else {
			xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
			xhr.send(data);
		};
		
		xhr.onreadystatechange = function() {
			
			if ( xhr.readyState == 4 ) {
				if ( xhr.status == 200 ) {
					var result = dataType === "json" && processData ? parseTxt( xhr.responseText ) : xhr.responseText;
					typeof success === "function" && success( result );
				} else {
					//出错了。。。
					typeof error === "function" && error( xhr.status );
				};
			};
			
		};
		
	},
	//JSON类型判断
	isJson : function(obj){
		var result = typeof(obj) == "object" && Object.prototype.toString.call(obj).toLowerCase() == "[object object]" && !obj.length;
		return result;
	},
	/*
	//***********===//***josnp*跨*域*传*输***\\===**********\\
	url: 发送请求的地址，默认截取 callback后的字符作为回调函数名。 如需自定义回调函数名，请使用下面的jsonp参数
	jsonp: 自定义回到函数名，值必须是json格式的字符串。 如：'{"callback": "mycbFn"}'
	cache: 默认: false，设置为 false 将不缓存此页面
	success: 请求成功时调用此函数，如带参数 data，可获得返回的数据
	error: 请求失败时调用此函数
	*/
	jsonp: function( json ){
		
		var url = null;
		if( typeof json.url !== "undefined" &&  json.url && json.url.length > 0 ){
			url = json.url;
		} else {
			alert( "发送请求的地址url必须是字符串且不能为空！" );
			return;
		};
		
		var cache = json.cache !== undefined && typeof json.cache === "boolean" ? json.cache : false;
		var success = json.success;
		var error = json.error;
		var callbackName = null;
		var oJsonp = json.jsonp ? myLab.parseTxt( json.jsonp ) : null;
		
		if( oJsonp ){
			for( var attr in oJsonp ){
				callbackName = oJsonp[attr];
				if( url.indexOf(attr + "=") !== -1 ){
					//url中含有回调函数的关键 key
					url = url.replace( url.split(attr +"=")[1], "myLab.jsonpCallBack."+callbackName );	
				} else {
					url += "&" + attr + "=" + "myLab.jsonpCallBack." + callbackName;
				};
			};
		} else {
			if( url.indexOf("callback") !== -1 ){
				callbackName = url.split("&callback=")[1];
				callbackName = callbackName.indexOf("&") ? callbackName.split("&")[0] : callbackName;
				url = url.replace( callbackName, "myLab.jsonpCallBack."+callbackName );
			} else {
				alert("无法获取回调函数名！");
				return;
			};
		};
		
		url = !cache ? url + '&' + this.date_getTime() : url;
		this.loadScript( url, '', "head", error );
		
		//调用数据
		if( typeof this.jsonpCallBack !== "object" ) this.jsonpCallBack = {};
		this.jsonpCallBack[callbackName] = function(data){ typeof success === "function" && success(data); };
		
	},
	date_getTime : function(){
		var time = new Date();
		var now = time.getTime();
		return now;	
	},
	loadScript : function( src, callBack, target, error ){
		var script = document.createElement("script");
		target = typeof target === "undefined" || target === "" || target === null ? "head" : target;
		document.getElementsByTagName(target)[0].appendChild( script );
		myLab.loadImg( script, src, callBack, error );
	},
	loadImgArr : function( loadImgSrcArr, loadingFn, callBack ){
		var loadI = 0;//初始化的进度数
		var totalImg = loadImgSrcArr.length;//统计页面图片总数
		//载入loading数据
		for (var i = 0; i < totalImg; i++) {
			var image = new Image();//创建一个图片对象
			
			myLab.loadImg( image, loadImgSrcArr[i], function(){
				
				loadI ++;
				var Scale = loadI / totalImg;
				var percent = Math.floor(Scale * 100);
				//设置进度数
				typeof loadingFn == "function" && loadingFn(percent);
				//当所有图片加载完毕时
				if(loadI == totalImg){
					setTimeout(function() {
						typeof callBack == "function" && callBack();
					}, 300);
				};
				
			},function(){
				this.src = '';
				loadI ++;
				var Scale = loadI / totalImg;
				var percent = Math.floor(Scale * 100);
				//设置进度数
				typeof loadingFn == "function" && loadingFn(percent);
				//当所有图片加载完毕时
				if(loadI == totalImg){
					setTimeout(function() {
						typeof callBack == "function" && callBack();
					}, 300);
				};	
			});
		};
	},
	//判断单张图片加载完成方法
	loadImg : function( obj, src, callBack, error ) {
		if ( obj.readyState ) { //IE
			obj.onreadystatechange = function() {
				if( obj.readyState == "loaded" || obj.readyState == "complete" ) {
					obj.onreadystatechange = null;
					typeof callBack == "function" && callBack();
				}
			};
		} else { //Others: Firefox, Safari, Chrome, and Opera
			obj.onload = function() {
				typeof callBack == "function" && callBack();
			};
		};
		
		obj.onerror = function(){ typeof error === "function" && error.call(obj) };
				
				obj.src = src;
			}
		}
		window.myLab = myLab;	
	})( window, document, undefined );
	/*==================== AJAX end ====================*/