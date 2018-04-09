$(window).ready(function () {
	//第几题(从0开始),-1起始页，-2结束页
	var tNum =parseInt($("input[nm='answered']").val());
	
	//最大题数
	var tMax = allData.length;
	
	//当前问题类型
	var _type = "";
	
	//下拉-首选项
	var selInit = "请选择";
	
	var errTf = false;
	
	//显示-当前题目
	showQue();
	function showQue(){
		//0未开始，1已回答，2已结束，3错误页，其他开始答题
//		var _param = getUrlParam("r");
		var _param = $("input[nm='status']").val();
		trace(_param);
		if(_param=="0"){
			//0未开始
			trace(".unstart-tip-pg");
			alphaUp($(".unstart-tip-pg"));
			return;
		}
		if(_param=="1"){
			//已答毕
			trace(".has-tip-pg");
			alphaUp($(".has-tip-pg"));
			return;
		}else if(_param=="2"){
			//问卷结束
			trace(".end-tip-pg");
			alphaUp($(".end-tip-pg"));
			return;
		}else if(_param=="3"){
			//错误
			trace(".err-tip-pg");
			errTf = true;
		}
		
		var n = tNum;
		if(n==-1){
			alphaUp($(".start-pg"));
			$(".ct-pg").hide();
			return;
		}else if(n==-2){
			alphaUp($(".end-pg"));
			return;
		}
		$(".start-pg").hide();
		alphaUp($(".ct-pg"));
		
		$(".num-wrap").text("Q"+(n+1));
		
		//进度-百分数
		var _per = Math.round((n+1)*100/tMax);
		$(".line-wrap>p").text(_per+"%");
		
		//进度条
		$(".line-wrap>div>div").css({"width":(_per-1)+"%"});
		_qusId= allData[n].qusId;
		_type = allData[n].type;
		_skip = allData[n].skip;
		//提问
		$(".que-wrap").empty();
		$(".que-wrap").text((n+1)+". "+allData[n].que);
		$(".ans-wrap").attr("que_type",_type);
		$(".ans-wrap").attr("que_id",_qusId);
		$(".ans-wrap").empty();
		
		var _html = "";
		var iLen = allData[n].ans.length;
		
		//选项
		if(_type=="cb"||_type=="cb_"){
			_html += "<ul>";
			for(var i=0;i<iLen;i++){
				if(allData[n].ans[i]==Other){
					_html += '<li><img src="/htib2c-mobile/resources/questionnaire/img/cb0.png" alt="" class="cb"> <span index="'+i+'">'+allData[n].ans[i]+'</span> <input type="text" maxlength="60"></li>';
				}else{
					_html += '<li><img src="/htib2c-mobile/resources/questionnaire/img/cb0.png" alt="" class="cb"> <span index="'+i+'">'+allData[n].ans[i]+'</span></li>';
				}				
			}
			_html += "</ul>";
			$(".ans-wrap").html(_html);
			
			if(_type=="cb_"){
				//按钮：多选
				$(".ans-wrap li").each(function(){
					$(this).data("cb",0);
					$(this).click(function(){
						if($(this).data("cb")==0){
							$(this).data("cb",1);

							$(this).find("img").attr("src","/htib2c-mobile/resources/questionnaire/img/cb1.png");
							$(this).find("span").css({"color":"rgb(0,161,196)"});
							$(this).find("input").css({"border-color":"rgb(0,161,196)","color":"rgb(0,161,196)"});
						}else{
							$(this).data("cb",0);

							$(this).find("img").attr("src","/htib2c-mobile/resources/questionnaire/img/cb0.png");
							$(this).find("span").css({"color":"rgb(173,173,173)"});
							$(this).find("input").css({"border-color":"rgb(173,173,173)","color":"rgb(173,173,173)"});
						}
					});
				});
			}else{
				$(".ans-wrap li").each(function(){
					//按钮：单选
					$(this).data("cb",0);
					$(this).click(function(){
						$(".ans-wrap li").data("cb",0);
						$(".ans-wrap li").find("img").attr("src","/htib2c-mobile/resources/questionnaire/img/cb0.png");
						$(".ans-wrap li").find("span").css({"color":"rgb(173,173,173)"});
						$(".ans-wrap li").find("input").css({"border-color":"rgb(173,173,173)","color":"rgb(173,173,173)"});
						
						$(this).data("cb",1);
						$(this).find("img").attr("src","/htib2c-mobile/resources/questionnaire/img/cb1.png");
						$(this).find("span").css({"color":"rgb(0,161,196)"});
						$(this).find("input").css({"border-color":"rgb(0,161,196)","color":"rgb(0,161,196)"});
					});
				});
			}
			
		}else if(_type=="area"){
			//文本域
			_html += '<textarea id="textarea" name="textarea" placeholder="请在此输入您的答案" maxlength=60></textarea>';
			$(".ans-wrap").html(_html);
			
			/*$("#textarea").on("input propertychange", function() {
				var maxlength = 3;
				var $this = $(this), _val = $this.val(), count = "";
				if (_val.length > maxlength) {
					$this.val(_val.substring(0, maxlength));
				}
				count = maxlength - $this.val().length;
				$("#textarea").text(count);
			}); */
		}else if(_type=="sel"){
			var _array = allData[n].ans;
			_array.insert(0,selInit);
			
			//下拉列表
			_html += '<div class="sel-wrap"><p class="txt"></p><select name="select" id="select"></select></div><div class="oth-wrap none"><span>请填写</span> <input type="text" maxlength="60"></div>';
			$(".ans-wrap").html(_html);
			
			setSel("#select", _array, ".ans-wrap .txt");
			$("#select").on("change", function () {
				//cityId = document.querySelector("#select").selectedIndex;
				//cityId = $(this).get(0).selectedindex;
				$(".ans-wrap .txt").text($(this).find("option:selected").text());
				$(".ans-wrap .txt").attr("index",$(this).find("option:selected").val());
				
				if($(".ans-wrap .txt").text()==Other){
					alphaUp($(".ans-wrap .oth-wrap"));
				}else{
					alphaDown($(".ans-wrap .oth-wrap"));
				}
			});
		}
		
	}
	
	//按钮：开始答题
	$(".start-btn").click(function(){
		if(errTf){
			alphaUp($(".err-tip-pg"));
			return;
		}
		tNum = 0;
		showQue();
	});
	
	//按钮：下一步
	$(".next-btn").click(function(){
	   var n = tNum;
	   
       var _queType = $(".ans-wrap").attr("que_type");
       var content="";
//       if(_queType=="cb"||_queType=="cb_"){
//    	   //单选或者多选
//    	   var img=$(".ans-wrap").find("li img");
//	       $.each(img,function(index,item){
//				if($(item).attr("src").indexOf("cb1")>0){
//					var contenTagDom=$(item).next()[0];
//					var op_index=$(contenTagDom).attr("index");
//					content+=op_index+"@";
//					if($(contenTagDom).text()=="其他"){
//						content+=$(contenTagDom).next()[0].value+"#";
//					}else{
//						content+=$(contenTagDom).text()+"#";
//					}
//				}
//			})
//			content=content.substring(0,content.length-1);
//       }else if(_queType=="sel"){
//    	  var sel_text= $(".ans-wrap .txt").text();
//		  var sel_index=$(".ans-wrap .txt").attr("index");
//		  content+=sel_index+"@"+sel_text;
//       }else if(_queType=="area"){
//    	   var _text= $("#textarea").val();
//    	   content+=_text;
//       }
       
        var _que = $(".que-wrap").text();
		getAns();
		//alert("_que:"+_que+",_ans:"+_ans);
		/*$.post("", {
			que:_que,
			ans:_ans
		}, function (result) {
			//{"returnMsg":{"success":"操作成功","state":true}}
			//$("#leadRawData").val(result);
			
			
		});*/
		
	});
	$(".err-tip-pg").click(function(){
		alphaDown($(".err-tip-pg"));
	});
	
	function getAns(){
		var n = tNum;
		var _str = "";
		
		if(_type=="cb"||_type=="cb_"){
			$(".ans-wrap li").each(function(){
				if($(this).data("cb")==1){
					var index=$(this).find("span").attr("index");
					_str +=index+"#D_#";
					if($(this).find("span").text()==Other){
						_str += $(this).find("span").text()+":"+$(this).find("input").val()+"#E_#";
					}else{
						_str += $(this).find("span").text()+"#E_#";
					}
				}
			});
		}else if(_type=="area"){
			_str = $(".ans-wrap textarea").val();
		}else if(_type=="sel"){
			var index=$(".ans-wrap .txt").attr("index");
			_str+=index+"#D_#"
			if($(".ans-wrap .txt").text()==selInit){
				alphaUp($(".err-next"));
				return;
			}
			if($(".ans-wrap .txt").text()==Other){
				_str += Other+":"+$(".ans-wrap>div>input").val();
			}else{
				_str += $(".ans-wrap .txt").text();
			}
			
		}
		
		if(!_skip){
			if(_str==""){
				alphaUp($(".err-next"));
				return;
			}
		}
		alphaDown($(".err-next"));
		if(_str.substr(_str.length-4,_str.length)=="#E_#"){
			_str = _str.substr(0,_str.length-4);
		}
		//保存
		var que_id=$(".ans-wrap").attr("que_id");
       $.ajax({
    		url:'/htib2c-mobile/servlet/QuestionnaireSaveServlet',
    	    type:'POST', //post
    	    async:false,    //或false,是否异步
    	    data:{
    	        "questionnaireId":questionnaireId,"answers":_str,"queId":que_id
    	    },
    	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
    	    success:function(data){
    	        if(data){
    	        	if(parseInt(data)>0){
	    	        	if(n>=tMax-1){
	    	    			tNum = -2;
	    	    			showQue();
	    	    		}else{
	    	    			tNum++;
	    	    			showQue();
	    	    		}
    	            }else{
    	            	//错误
    	    			alphaUp($(".err-tip-pg"));
    	    			return;
    	            }
    	        	
    	        }
    	    },
    	    error:function(xhr){
    	    	//错误
    			alphaUp($(".err-tip-pg"));
    			return;
    	    }
    	})
	}
	$(".ct-wrap").css({"height":($(window).height()-130)+"px"});
});