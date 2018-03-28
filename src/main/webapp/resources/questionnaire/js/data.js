/*
类型说明：
cb_，多选
cb，单选
sel，下拉列表
area，文本域

注意：ans里包含“其他”，则会有input输入框
*/

//其它选项文本
var Other = "其他";
var questionnaireId=$("input[nm='questionnaire']").val();
var allData;
//所有题目
$.ajax({
	url:'/htib2c-mobile/servlet/QuestionnaireDataServlet',
    type:'POST', //GET
    async:false,    //或false,是否异步
    data:{
        "questionnaireId":questionnaireId
    },
    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
    success:function(data){
        if(data){
        	allData=data;
        }
    },
    error:function(xhr){
    	//错误
		alphaUp($(".err-tip-pg"));
		return;
    }
})
var all = [
	{"type":"cb_","que":"请问您的兴趣爱好是_____？（可多选）","ans":["旅游探险","影视文艺类","体育赛事","健身运动","厨艺美食","宠物","电子游戏","舞台剧演出","艺术展",Other],"skip":true},
	
	{"type":"cb_","que":"请问您平时喜欢阅读哪种类型的公众号文章？（可多选）","ans":["时政、商业财经新闻资讯","汽车、科技、体育赛事资讯","科普教育及育儿方面","情感励志美文","品质生活、好物推荐","幽默小故事"]},
	
	{"type":"cb","que":"请问您的年龄是_____？","ans":["18-25岁","26-30岁","31-35岁","36-45岁","46-50岁","50岁以上"],"skip":true},
	
	{"type":"cb","que":"请问您的性别是_____？","ans":["男性","女性"],"skip":true},
	
	{"type":"cb","que":"请问您所从事的行业领域为_____？","ans":["房地产","金融","医疗","文体传媒","IT、电子、互联网","教育","商贸","运输、物流、贸易","服务类","政府、非营利机构",Other]},
	
	{"type":"cb","que":"请问您有无子女？","ans":["有","无"]},
	
	{"type":"sel","que":"请问您拥有且最常用的梅赛德斯-奔驰车型是？","ans":["B-Class","C-Class","CLA-Class","CLS-Class","E-Class","G-Class","GL-Class","GLA-Class","GLC-Class","GLK-Class","GLE-Class","GLS-Class","ML-Class","S-Class","SLC-Class","SLK-Class","SL-Class",Other]},
	
	{"type":"cb_","que":"请问您喜欢哪种形式的车主福利？（可多选）","ans":["梅赛德斯-奔驰 智能互联服务续订优惠","梅赛德斯-奔驰品牌的精品好物","品牌甄选的汽车配件及用具","与梅赛德斯-奔驰 智能互联有合作关系的其他高端品牌体验券"]},
	
	{"type":"cb_","que":"请问您是否愿意向其他车主或朋友推荐梅赛德斯-奔驰智能互联公众号？（可多选）","ans":["愿意推荐公众号内的文章","愿意推荐公众号内的功能","不愿意"]},
	
	{"type":"cb_","que":"请问以下哪些选项是车顶i键的功能？（可多选）","ans":["兴趣点搜索","车载语音电话","旅程咨询","经销商信息查询与连接","拨打语音电话"]},
	
	{"type":"area","que":"问答式模版","ans":[]}
]