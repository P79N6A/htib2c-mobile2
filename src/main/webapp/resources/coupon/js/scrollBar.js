/**
 * Created by LinJe on 2016/6/1.
 * 自定义滚动条，依赖zepto
 */
;(function( $ ) {

    $.extend($.fn, {
        'scrollBar': function( settings ) {
            //自定义滚动条
            var oScrollBox = $(this),
                oScrollHandle = $(settings.handle),
                oScrollBar = $(settings.bar),
                oScrollEle = oScrollBox.get(0),
                timer_scrollH = null,
                timer_load = null;
            var downY = 0, barTop = 0, barHeight = oScrollBar.height(), scrollHeight = 0, scrollHandleHeight = 0;

            //判断是否开启滚动条
            oScrollBox.css({'overflow': 'hidden'});
            timer_scrollH = setInterval(function() {
                if ( oScrollEle.scrollHeight ) {
                    clearTimeout(timer_load);
                    if ( oScrollEle.scrollHeight > oScrollBox.height() ) {
                        oScrollHandle.addClass('active');
                        barHeight = oScrollBar.height();
                        addScroll();
                    }
                }
            }, 100);
            timer_load = setTimeout(function() {
                clearInterval(timer_scrollH);
                $(window).on('load', function() {
                    if ( oScrollEle.scrollHeight > oScrollBox.height() ) {
                        oScrollHandle.addClass('active');
                        barHeight = oScrollBar.height();
                        addScroll();
                    }
                });
            }, 8000);

            function addScroll() {
                //滚动区域
                oScrollBox.on('touchstart', function(evt) {
                    downY = evt.changedTouches[0].pageY;
                    scrollHeight = oScrollEle.scrollHeight - oScrollBox.height();
                    scrollHandleHeight = oScrollHandle.height() - oScrollBar.height();
                });

                oScrollBox.on('touchmove', function(evt) {
                    var moveY = evt.changedTouches[0].pageY,
                        target = oScrollEle.scrollTop + downY - moveY;

                    target = rangeBar(target, scrollHeight);
                    barTop = parseInt(target/scrollHeight*scrollHandleHeight);
                    oScrollBar.css('top', barTop+'px');
                    oScrollEle.scrollTop = target;
                    downY = moveY;

                    evt.preventDefault();
                });

                //滚动手柄
                oScrollBar.on('touchstart', function(evt) {
                    downY = evt.changedTouches[0].pageY;
                    scrollHeight = oScrollEle.scrollHeight - oScrollBox.height();
                    scrollHandleHeight = oScrollHandle.height() - oScrollBar.height();
                });

                oScrollBar.on('touchmove', function(evt) {
                    var moveY = evt.changedTouches[0].pageY;

                    barTop = rangeBar(barTop+moveY-downY, scrollHandleHeight);
                    oScrollBar.css('top', barTop+'px');
                    oScrollEle.scrollTop = parseInt(barTop/scrollHandleHeight*scrollHeight);
                    downY = moveY;

                    evt.preventDefault();
                });

                //滚动条
                oScrollHandle.on('click', function(evt) {
                    var currentY = evt.pageY,
                        scrollHeight = oScrollEle.scrollHeight - oScrollBox.height();
                    scrollHandleHeight = oScrollHandle.height() - oScrollBar.height();

                    barTop = rangeBar(parseInt(currentY-$(this).offset().top-barHeight/2), scrollHandleHeight);
                    oScrollEle.scrollTop = parseInt(barTop/scrollHandleHeight*scrollHeight);
                    oScrollBar.css('top', barTop+'px');

                });
            }

            function rangeBar( target, maxHeight ) {
                return target > maxHeight ? maxHeight : target < 0 ? 0 : target;
            }
        }
    });

})( Zepto );
