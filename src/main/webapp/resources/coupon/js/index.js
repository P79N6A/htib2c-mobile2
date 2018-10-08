/**
 * Created by chenyue on 2017/5/5.
 */
;(function($) {

    //活动规则 滚动条
    var detailsCommon = function( opts ) {
        opts.content.scrollBar({'handle': opts.handle, 'bar': opts.bar});
    };

    /**
     * loading页
     */
    ;(function() {
        var getSrc = function(){
            var arr = [];
            $('img').each(function(index, elm){
                arr.push( $(elm).attr("src") );
            });
            arr.push('../resources/coupon/images/bg.jpg');
            arr.push('../resources/coupon/images/buling.png');
            arr.push('../resources/coupon/images/ticket.png');
            arr.push('../resources/coupon/images/ticket-box.png');
            arr.push('../resources/coupon/images/tips.png');
            arr.push('../resources/coupon/images/title.png');
            return arr;
        };
        var loading = function( aSrc, loadFn, callBack ){
            var loadI = 0;
            var totalImg = aSrc.length;
            for (var i = 0; i < totalImg; i++) {
                var image = new Image();
                image.onload = function() {
                    loadI ++;
                    var Scale = loadI / totalImg;
                    var Percent = Math.floor(Scale * 100);
                    loadFn && loadFn( Percent );
                    loadI == totalImg && callBack && callBack();
                };
                image.src = aSrc[i];
            }
        };
        loading( getSrc(), function( num ){
        },function(){
            var welfare = $('#welfare');

            welfare.addClass('active');
            //初始化滚动条
            detailsCommon({
                'content': welfare.find('.scroll_cont'),
                'handle': welfare.find('.scroll_handle'),
                'bar': welfare.find('.scroll_bar')
            });
        });

        //微信锁屏
        $('.page').on('touchmove',function(ev) {
            ev.preventDefault();
        });


    })();


    //领取优惠券
    ;(function() {
        var welfare = $('#welfare'),
            oUl = welfare.find('.scroll-wrap ul');

        oUl.on('click','li .btn',function() {
        	var btn= $(this);
            var _this = $(this).parents('li');
            var couponId=$(this).attr("id");
            if( _this.hasClass('active') ) {
            	document.getElementById("package:toOrderPackage").click();
            }else {
            	$.ajax({
            		url:"/htib2c-mobile/servlet/CouponDataServlet",
            		data:{"couponId":couponId},
            		dataType:"json",
            		type:"POST",
            		success:function(date){
            			if(date=="1"){
            				  _this.addClass('active').find('span').text('去使用');
            			}else{
            				alert("领取失败");
            			}
            		}
            	});
               
            }

        });

    })();



})(Zepto);


