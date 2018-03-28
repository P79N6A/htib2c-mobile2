//微信JS接口调用方法
var hideSign = 1;
function onBridgeReady() {

    if (hideSign == 1) {
        WeixinJSBridge.call('hideOptionMenu');
    } else if (hideSign == 2) {
        WeixinJSBridge.call('hideToolbar');
    } else if (hideSign == 12) {
        WeixinJSBridge.call('showOptionMenu');
    } else if (hideSign == 22) {
        WeixinJSBridge.call('showToolbar');
    }

}

//隐藏右上角操作按钮,oid:1表示隐藏右上角操作按钮,2表示隐藏底部导航栏
function myHideOptionMenu(oid) {
    hideSign = oid;
    if (typeof WeixinJSBridge == "undefined") {
        if (document.addEventListener) {
            document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
        } else if (document.attachEvent) {
            document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
            document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
        }
    } else {
        onBridgeReady();
    }
}
