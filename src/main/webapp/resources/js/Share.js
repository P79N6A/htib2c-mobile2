$(function () {
    $.ajax({
        url: "http://crm.mmuugg.com/handler/SharedSignatureHandler.ashx",
        type: "GET",
        cache: true,
        data: { u: location.href },
        dataType: "jsonp",
        success: function (back) {
            wx.config({
                debug: false,
                appId: back.appId,
                timestamp: back.timestamp,
                nonceStr: back.nonceStr,
                signature: back.signature,
                jsApiList: [
                // 所有要调用的 API 都要加到这个列表中
                 'hideMenuItems',
                 'onMenuShareTimeline',
                 'onMenuShareAppMessage',
                 'scanQRCode'
                ]
            });
        },
        error: function () {
        }
    });
});

wx.ready(function () {
    // 在这里调用 API
    wx.error(function (res) {
    });
    addWeiXinEvent();
});
$.timelineTitle = "动动手指，赢斯巴鲁森林人EyeSight限量车模";
$.shareAppTitle = "动动手指，赢斯巴鲁森林人EyeSight限量车模";
$.shareAppDesc = "自动起步、遇障停车的超好玩车模，就问你想不想要？";
$.shareUrl = "http://subaru.agenda-bj.com.cn/Subaru/AuShare1225";
//$.shareUrl = "http://subaru.agenda-bj.com.cn/EyeSight/index.html?utm_source=Share&utm_medium=Wechat";

$.shareImage = "http://subaru.agenda-bj.com.cn/forester1712/img/share.jpg";
var addWeiXinEvent = function () {
    wx.hideMenuItems({
        menuList: [
        "menuItem:copyUrl",
        "menuItem:share:qq",
        "menuItem:openWithQQBrowser",
        "menuItem:openWithSafari"] // 要隐藏的菜单项，只能隐藏“传播类”和“保护类”按钮，所有menu项见附录3
    });
    wx.onMenuShareAppMessage({
        title: $.shareAppTitle,
        desc: $.shareAppDesc,
        link: $.shareUrl,
        imgUrl: $.shareImage,
        trigger: function (res) {

        },
        success: function (res) {
           // 用户确认分享后执行的回调函数
           ClickEvent("BUT_300.0_friendsuccess");
        },
        cancel: function (res) {
           ClickEvent("BUT_300.0_friendcancel");
        },
        fail: function (res) {

        }
    });
    wx.onMenuShareTimeline({
        title: $.timelineTitle,
        link: $.shareUrl,
        imgUrl: $.shareImage,
        trigger: function (res) {
			
        },
        success: function (res) {
            // 用户确认分享后执行的回调函数
            ClickEvent("BUT_300.0_success");
        },
        cancel: function (res) {
			ClickEvent("BUT_300.0_cancel");
        },
        fail: function (res) {
			
        }
    });
};
