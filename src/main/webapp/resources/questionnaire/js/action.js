$(window).ready(function () {
	//第几题(从0开始),-1起始页，-2结束页
	var tNum = -1;
	
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
		//1已回答，2已结束
		var _param = getUrlParam("r");
		trace(_param);
		if(_param=="1"){
			trace(".has-tip-pg");
			alphaUp($(".has-tip-pg"));
			return;
		}else if(_param=="2"){
			trace(".end-tip-pg");
			alphaUp($(".end-tip-pg"));
			return;
		}else if(_param=="3"){
			trace(".err-tip-pg");
			//alphaUp($(".err-tip-pg"));
			//return;
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
		
		_type = allData[n].type;
		
		//提问
		$(".que-wrap").empty();
		$(".que-wrap").text((n+1)+". "+allData[n].que);
		
		$(".ans-wrap").empty();
		var _html = "";
		var iLen = allData[n].ans.length;
		
		//选项
		if(_type=="cb"||_type=="cb_"){
			_html += "<ul>";
			for(var i=0;i<iLen;i++){
				if(allData[n].ans[i]==Other){
					_html += '<li><img src="../resources/questionnaire/img/cb0.png" alt="" class="cb"> <span>'+allData[n].ans[i]+'</span> <input type="text" maxlength="60"></li>';
				}else{
					_html += '<li><img src="../resources/questionnaire/img/cb0.png" alt="" class="cb"> <span>'+allData[n].ans[i]+'</span></li>';
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

							$(this).find("img").attr("src","../resources/questionnaire/img/cb1.png");
							$(this).find("span").css({"color":"rgb(0,161,196)"});
							$(this).find("input").css({"border-color":"rgb(0,161,196)","color":"rgb(0,161,196)"});
						}else{
							$(this).data("cb",0);

							$(this).find("img").attr("src","../resources/questionnaire/img/cb0.png");
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
						$(".ans-wrap li").find("img").attr("src","../resources/questionnaire/img/cb0.png");
						$(".ans-wrap li").find("span").css({"color":"rgb(173,173,173)"});
						$(".ans-wrap li").find("input").css({"border-color":"rgb(173,173,173)","color":"rgb(173,173,173)"});
						
						$(this).data("cb",1);
						$(this).find("img").attr("src","../resources/questionnaire/img/cb1.png");
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
		//var _que = $(".que-wrap").text();
		//var _ans = getAns();
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
			/*$(".que-wrap").eq(n).find("li").each(function(i,el){
				if($(this)){

				}
			});*/
			$(".ans-wrap li").each(function(){
				if($(this).data("cb")==1){
					if($(this).find("span").text()==Other){
						_str += $(this).find("span").text()+":"+$(this).find("input").val()+"|";
					}else{
						_str += $(this).find("span").text()+"|";
					}
				}
			});
		}else if(_type=="area"){
			_str = $(".ans-wrap textarea").val();
		}else if(_type=="sel"){
			if($(".ans-wrap .txt").text()==selInit){
				alphaUp($(".err-next"));
				return;
			}
			if($(".ans-wrap .txt").text()==Other){
				_str = Other+":"+$(".ans-wrap>div>input").val();
			}else{
				_str = $(".ans-wrap .txt").text();
			}
		}
		
		if(_str==""){
			alphaUp($(".err-next"));
			return;
		}
		alphaDown($(".err-next"));
		if(_str.substr(_str.length-1,_str.length)=="|"){
			_str = _str.substr(0,_str.length-1);
		}
		
		//alert(_str);
		//return _str;
		if(n>=tMax-1){
			tNum = -2;
			showQue();
		}else{
			tNum++;
			showQue();
		}
	}
});