// 数据绑定


//红包点击
var packageBtn = $(".page1Btn");
var packageImg = $(".package1");
var animateObj = $(".animateBox").find("img");
packageBtn.click(function() {

  packageImg.click();

});

packageImg.click(function() {
    $("input[nm='userLuckyDrawFlag']").val("");
    $("input[nm='baseSize']").val("");
    $("input[nm='leftAmount']").val("");
    $("input[nm='allBaseSize']").val("");
    $("input[nm='doLuckDraw']").click();

  //
});


function luckyDrawSuccess(){

    $(".packageActive").css({"animation": "packageActiveAnimate 2.5s  ease alternate"});
    setTimeout(function() {

        //隐藏第一页的元素
        $(".titleBox").find("img").css("display", "none");
        $(".page1Text").css("display","none");
        $(".containerBox").find("p").css("display", "none");
        $(".opacityFloor").css("display", "none");
        $(".package1").css("display", "none");

        //显示喷红包元素
        $(".animateBox").css({"display": "block"});

        //喷红包动画
        var num = 0;
        animateObj.eq(num).css("display", "block");

        var t = setInterval(function() {
            animateObj.css("display", "none");
            animateObj.eq(num).css("display", "block");
            num++;
            if (num >= 7) {

                $(".containerBox").animate({
                    "opacity": "0"
                }, 1000, function() {
                    $(".titleBox").css("display", "none");
                    $(this).css("display", "none");
                });

                clearInterval(t);
                packageDownFn();
                setTimeout(function(){
                    $(".minAnimateBox").css("display","block");
                    $(".minAnimateBox").find("img").animate({"opacity":"1"},2000);
                },500)

                $(".packageBox").animate({
                    "opacity": "0"
                }, 2000, function() {
                    $(this).css("display", "none");
                });
            }
        }, 30);
    }, 2500);

}
//四个状态函数
function statusFn(str,winningsAdd,theTerm,remaining,allBaseSize) {
  $(".lastContainer").addClass(str);
  var ele = "." + str;

  switch (str) {
      //中奖 有抽奖次数
    case "winnings":

      //中奖页面 奖卷信息
      $(".winningsData").find("bind").text("+"+winningsAdd+"个月");

      //套餐服务期
      $(".winningsText").find("bind").text(theTerm+"个月");

      //剩余次数
      $(".text2").find("bind").text(remaining+"个");

      $(ele).css("display", "block");
      //依次显示
      $(ele).children(".awardRoll").animate({"opacity": "1"}, 500, function() {
        $(ele).children(".text1").animate({"opacity": "1"}, 500, function() {
          $(ele).children(".text2").animate({"opacity": "1"}, 500, function() {
            $(ele).children(".againBtn").animate({"opacity": "1"}, 500);
          });
        })
      });

      break;

      //中奖 没有抽奖次数
    case "winning":
    //中奖页面 奖卷信息
    $(".winningsData").find("bind").text("+"+winningsAdd+"个月");

    //套餐服务期
    $(".winningsText").find("bind").text(theTerm+"个月");
        $(".allText").find("bind").text(allBaseSize+"个");
      $(ele).css("display", "block");
      //依次显示
      $(ele).children(".awardRoll").animate({"opacity": "1"}, 500, function() {
        $(ele).children(".text1").animate({"opacity": "1"}, 500, function() {
          $(ele).children(".ThankYou").animate({"opacity": "1"}, 500)
        });
      });
      break;

      //未中奖 有抽奖次数
    case "notWinnings":

      //剩余次数
      $(".text2").find("bind").text(remaining+"个");

      $(ele).css("display", "block");

      //依次显示
      $(ele).children(".awardRoll").animate({"opacity": "1"}, 500, function() {
        $(ele).children(".notWinningText").animate({"opacity": "1"}, 500, function() {
          $(ele).children(".text2").animate({"opacity": "1"}, 500, function() {
            $(ele).children(".againBtn").animate({"opacity": "1"}, 500);
          });
        });
      });

      break;

      //未中奖 没有抽奖次数
    case "notWinning":

        $(".allText").find("bind").text(allBaseSize+"个");
      $(ele).css("display", "block");

      //依次显示
      $(ele).children(".awardRoll").animate({"opacity": "1"}, 500, function() {
        $(ele).children(".notWinningText").animate({"opacity": "1"}, 500, function() {
          $(ele).children(".ThankYou").animate({"opacity": "1"}, 500)
        });
      });
      break;
  }
}

//红包掉落函数
function packageDownFn() {
  $(".packageDown").css({"animation": "packageDown 3s ease-in-out", "animation-fill-mode": "forwards"});
  setTimeout(function() {
    $(".packageDown").css("display", "none");
    $(".lastDown").css("display", "block");

    // 用户的四个状态
    /*
      1中奖 有抽奖次数 winnings
      2中奖 没有抽奖次数 winning
      3未中奖 有抽奖次数 notWinnings
      4未中奖 没有抽奖次数 notWinning


    statusFn() 参数：
     1四个状态中的其中一个
     2中奖 奖卷信息
     3中奖 套餐服务期
     4有抽奖机会 剩余次数
     【注意】--
     四个参数不能为空
     页面上不需要显示的值可以传 0
    */

    var userLuckyDrawFlag = $("input[nm='userLuckyDrawFlag']").val();
      var baseSize = $("input[nm='baseSize']").val();
      var leftAmount = $("input[nm='leftAmount']").val();
      var allBaseSize = $("input[nm='allBaseSize']").val();
    statusFn(userLuckyDrawFlag,baseSize,baseSize,leftAmount,allBaseSize);

  }, 3000);

};

//再来一次点击
var lastBtn = $(".lastBtn");
lastBtn.click(function() {
  window.location.reload();
})

// 活动规则弹窗
$().shineonScroll({"father": "scrollfather2"});

// 滚动条显示
$(".scroll_ymove").css("display", "block");
$(".scroll_y").css({"display": "block", "height": "40%"});

//活动规则
var ruleObj = $(".rule");
ruleObj.click(function() {
  floorFn(1, 99, .5, 7, 720, 50);
});

//活动规则关闭
var closeObj = $(".floorBox").find("img");
closeObj.click(function() {
  floorFn(0, 0, 0, -100, 0, -30);
});

function floorFn(o, z, b, t, r, left) {
  $(".opacityFloor").css({
    "opacity": o,
    "z-index": z,
    "background": "rgba(0,0,0," + b + ")"
  });
  $(".floorBox").animate({
    "top": t + "%"
  }, 500, function() {
    $(".closeBox").find("img").css({
      "transform": "rotate(" + r + "deg)",
      "opacity": o,
      "left": left + "%"
    });
  });
};
