/**
 * Created by chenyue on 2018/9/10.
 */
;(function($) {
    /**
     * 共同方法
     */
    $.extend($.fn, {
        'fadeIn': function( settings ) {
            var _this = $(this);
            settings && settings.addClass && _this.addClass(settings.addClass);
            _this.css('opacity', '0').animate({'opacity':1}, settings && settings.time || 400, '', function() {
                settings && settings.callBack && settings.callBack.call(_this);
            });
            return _this;
        },
        'fadeOut': function( settings ) {
            var _this = $(this);
            _this.animate({'opacity':0}, settings && settings.time || 400, '', function() {
                settings.removeClass && _this.removeClass(settings.removeClass);
                settings && settings.callBack && settings.callBack.call(_this);
            });
            return _this;
        }
    });

    //用户变化屏幕方向时调用
    /*--------- 判断横屏 start ---------*/
    function orient() {
        /**
         * 屏幕方向对应的window.orientation值：
         ipad： 90 或 -90 横屏
         ipad： 0 或180 竖屏
         Andriod：0 或180 横屏
         Andriod： 90 或 -90 竖屏
         */
        //console.log(window.orientation + '_' + /iPhone|mac|iPod|iPad/i.test(navigator.userAgent));
        //当竖屏时
        if ( window.orientation == 180 || window.orientation == 0 ) {
            if(/iPhone|mac|iPod|iPad/i.test(navigator.userAgent)){
                console.log("ios竖屏");
                $("#window_mc").removeClass('active');
            }else {
                console.log("android横屏");
                $("#window_mc").removeClass('active');
            }
        }
        //当横屏时
        if( window.orientation == 90 || window.orientation == -90 ) {
            if(/iPhone|mac|iPod|iPad/i.test(navigator.userAgent)){
                console.log("ios横屏");
                $("#window_mc").addClass('active');
            }else{
                console.log("android竖屏");
                $("#window_mc").removeClass('active');
            }
        }
    }
    $(window).bind( "orientationchange", function(e){
        orient();
    });

    //页面加载时调用
    $(function() {
        orient();
    });
    /*--------- 判断横屏 end ---------*/


})(Zepto);