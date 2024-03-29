/**
 * Created by LinJe on 2015/11/10.
 * 基于zepto的自定义滚动条插件
 */
;(function( $, window, document, undefined ) {

    $.extend($.fn, {
        'vScrollbar': function( settings ) {
            var defs = {
                'bar': $(settings.bar),
                'handle': $(settings.handle),
                'easeSpeed': 4
            };

            $.extend(defs, settings);

            var $this = $(this),
                scrollEle = $this.parent(),
                scrollHandleEle = $(defs.handle),
                scrollBarEle = $(defs.bar),
                winHeight = parseInt(scrollEle.css('height')),
                scrollHeight = undefined,
                scrollHandleH = parseInt(scrollHandleEle.css('height')) - parseInt(scrollBarEle.css('height')),
                easeSpeed = defs.easeSpeed,
                startY = 0, distance = 0, oldDistance = 0,
                disBox = [],
                timerScrollH = null, timerScrollOut = null;


            if ( !$.fn.animate ) {
                var styleNode = document.createElement('style');
                styleNode.type = 'text/css';
                styleNode.innerHTML = '.scrollTransition{-webkit-transition:300ms all ease-out;transition:300ms all ease-out;}';
                document.getElementsByTagName('head')[0].appendChild(styleNode);
            }

            var setTranslate = function( $obj, y ) {
                    var transVal = 'translateY('+ y +'px)';
                    $obj.css({'-webkit-transform':transVal, 'transform':transVal});
                },
                getHandleDis = function() {
                    return Math.abs(distance/scrollHeight * scrollHandleH);
                },
                setHandle = function() {
                    barDistance = getHandleDis();
                    setTranslate(scrollBarEle, barDistance);
                },
                slowAction = function( $obj, target ) {
                    var transVal = 'translateY('+ target +'px)';
                    if ( $.fn.animate ) {
                        $obj.animate({'-webkit-transform':transVal, 'transform':transVal}, 300, 'ease-out');
                    } else {
                        $obj.addClass('scrollTransition').css({'-webkit-transform':transVal, 'transform':transVal});
                    }
                },
                rangeDistance = function() {
                    if ( distance > 0 ) {
                        distance = 0;
                    } else if ( distance < scrollHeight ) {
                        distance = scrollHeight < 0 ? scrollHeight : 0;
                    }
                },
                rangeHandle = function( num ) {
                    return num > 0 ? num > scrollHandleH ? scrollHandleH : num : 0;
                },
                getScrollH = function( callBack ) {
                    clearInterval(timerScrollH);
                    clearTimeout(timerScrollOut);
                    timerScrollH = setInterval(function() {
                        var tmpScrollH = scrollEle.get(0).scrollHeight;
                        if ( !scrollHeight ) {
                            if ( tmpScrollH > winHeight ) {
                                scrollHeight = winHeight - tmpScrollH;
                                scrollHandleEle.addClass('active');
                            }
                        } else {
                            clearInterval(timerScrollH);
                            clearTimeout(timerScrollOut);
                            callBack && callBack();
                        }
                    }, 100);
                    timerScrollOut = setTimeout(function() {
                        clearInterval(timerScrollH);
                        $(window).on('load', function() {
                            scrollHeight = winHeight - scrollEle.get(0).scrollHeight;
                            callBack && callBack();
                        });
                    }, 10000);
                };


            getScrollH();

            $this.on('touchstart', function(ev) {
                disBox = [];
                oldDistance = distance;
                startY = ev.changedTouches[0].pageY;
                $this.removeClass('scrollTransition');
            });

            $this.on('touchmove', function(ev) {
                var moveY = ev.changedTouches[0].pageY;

                distance = moveY - startY + oldDistance;
                rangeDistance();

                if ( distance != oldDistance ) {
                    setTranslate($this, distance);
                    setHandle();
                    disBox.push(moveY);
                }
                ev.preventDefault();
            });

            $this.on('touchend', function(ev) {
                var len = disBox.length,
                    speed = (disBox[len-1]-disBox[len-2]) * easeSpeed; //设置滚动的缓动灵敏度倍数

                if ( typeof speed == 'number' && speed === speed ) {
                    distance += speed;
                    rangeDistance();
                    slowAction($this, distance);
                    slowAction(scrollBarEle, getHandleDis());
                }
            });

            //滚动手柄
            var barDistance = 0, oldBarDistance = 0;
            scrollBarEle.on('touchstart', function(ev) {
                disBox = [];
                startY = ev.changedTouches[0].pageY;
                oldBarDistance = barDistance;
            });
            scrollBarEle.on('touchmove', function(ev) {
                var moveY = ev.changedTouches[0].pageY;
                //滚动手柄
                barDistance = rangeHandle(moveY - startY + oldBarDistance);
                setTranslate(scrollBarEle, barDistance);
                //内容
                distance = barDistance/scrollHandleH * scrollHeight;
                rangeDistance();
                setTranslate($this, distance);
                disBox.push(moveY);
                ev.preventDefault();
            });
            scrollBarEle.on('touchend', function() {
                var len = disBox.length,
                    speed = (disBox[len-1]-disBox[len-2]) * easeSpeed; //设置滚动的缓动灵敏度倍数

                if ( typeof speed == 'number' && speed === speed ) {
                    barDistance += speed;
                    barDistance = rangeHandle(barDistance);
                    //内容
                    distance = barDistance/scrollHandleH * scrollHeight;
                    rangeDistance();
                    slowAction($this, distance);
                    slowAction(scrollBarEle, barDistance);
                }
            });
            scrollHandleEle.on('click', function(ev) {
                var currentY = ev.pageY;
                //滚动手柄
                barDistance = rangeHandle(parseInt(currentY-$(this).offset().top-scrollBarEle.height()/2));
                setTranslate(scrollBarEle, barDistance);
                //内容
                distance = barDistance/scrollHandleH * scrollHeight;
                rangeDistance();
                setTranslate($this, distance);
                ev.preventDefault();
            });

            //重置滚动区域
            $this.resize = function() {
                startY = 0;
                distance = 0;
                oldDistance = 0;
                scrollHeight = undefined;
                barDistance = 0;
                oldBarDistance = 0;
                getScrollH(function() {
                    setTranslate($this, distance);
                    setHandle();
                });
            };

            return $this;
        }
    });

})( Zepto, window, document );
