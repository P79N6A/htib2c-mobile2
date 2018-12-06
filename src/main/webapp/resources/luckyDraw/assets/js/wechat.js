$(document).ready(function() {

  window.share = {
    imgUrl: 'http://' + window.location.host +
      '/html/assets/i/wechatshare.png',
    link: 'http://' + window.location.host +
      '/html/index.html',
    title: "",
    desc: "",
  }
  shareConfig();
});

function getURLParam(key) {
  var res = location.search.match(new RegExp(key + '=([^&]*)'));
  return res && res[1];
}

function shareConfig() {
  var thisurl = window.location.href;
  $.ajax({
    url: '../api/auth/wxshare',
    type: "POST",
    dataType: "json",
    async: false,
    data: {
      url: thisurl
    },
    success: function(response) {
      wxshare(response);
    }
  });

  function wxshare(response) {
    wx.config({
      debug: false,
      appId: response.appId,
      timestamp: response.timestamp,
      nonceStr: response.nonceStr,
      signature: response.signature,
      jsApiList: [
        'checkJsApi',
        'onMenuShareTimeline',
        'onMenuShareAppMessage',
        'onMenuShareQQ',
        'onMenuShareWeibo',
        'chooseImage',
        'previewImage',
        'uploadImage',
        'downloadImage',
        'getLocalImgData',
      ]
    })

    wx.ready(function() {
      wxcheck();

      function wxcheck() {
        wx.checkJsApi({
          jsApiList: [
            'checkJsApi',
            'onMenuShareTimeline',
            'onMenuShareAppMessage',
            'onMenuShareQQ',
            'onMenuShareWeibo',
            'chooseImage',
            'previewImage',
            'uploadImage',
            'downloadImage',
            'getLocalImgData',
          ],
          success: function(res) {
            //alert(JSON.stringify(res));

          }
        });
      }

      wx.onMenuShareTimeline({
        title: window.share.title, // 分享标题
        link: window.share.link, // 分享链接
        imgUrl: window.share.imgUrl,
        desc: window.share.desc,
        success: function() {
          G.GAEvent('WeChat_sharesuccess');

        },
        cancel: function() {
          // 用户取消分享后执行的回调函数
          G.GAEvent('WeChat_sharecancel');
        }
      });


      wx.onMenuShareAppMessage({
        title: window.share.title, // 分享标题
        link: window.share.link, // 分享链接
        imgUrl: window.share.imgUrl,
        desc: window.share.desc,
        trigger: function(res) {
          //	alert('用户点击分享到朋友圈');
        },
        success: function(res) {
          G.GAEvent('WeChat_sharefriendsuccess')

        },
        cancel: function(res) {
          G.GAEvent('WeChat_sharefriendcancel')
            //	alert('已取消');
        },
        fail: function(res) {
          //	alert(JSON.stringify(res));
        }
      });

      wx.onMenuShareQQ({
        title: window.share.title, // 分享标题
        desc: window.share.desc, // 分享描述
        link: window.share.link, // 分享链接
        imgUrl: window.share.imgUrl, // 分享图标
        success: function() {
          // 用户确认分享后执行的回调函数
        },
        cancel: function() {
          // 用户取消分享后执行的回调函数
        }
      });

      wx.onMenuShareWeibo({
        title: window.share.title, // 分享标题
        desc: window.share.desc, // 分享描述
        link: window.share.link, // 分享链接
        imgUrl: window.share.imgUrl, // 分享图标
        success: function() {
          // 用户确认分享后执行的回调函数
        },
        cancel: function() {
          // 用户取消分享后执行的回调函数
        }
      });


    })


  }

}
