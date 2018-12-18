var _w = $(window).width();
var _h = $(window).height();

var _click = 'ontouchstart' in window ? 'touchstart' : 'click';
var block = false;
var prizeTye;
var afterDraw = true;
var user_id;
var block = false;


$(document).ready(function () {
    sys = detect();
    imgLoadOne();

    function imgLoadOne() {
        var loaded = 0;
        var me = this;
        if ($('body img').length === 0 || navigator.userAgent.indexOf('MSIE 9') !=
            -1) {
            loadnext();
        } else {
            $('body img').imagesLoaded().progress(function (instance, image) {
                loaded++;
                if (loaded == instance.images.length) {
                    loadnext(me);
                }
            });
        }
        // work script
        function loadnext(me) {
            setTimeout(function () {
                imgs = document.getElementsByTagName("img");
                imgsnum = imgs.length;
                for (imgi = 0; imgi < imgsnum; imgi++) {
                    if ((typeof(imgs[imgi].src) == 'undefined' || imgs[imgi].src ==
                        '') && imgs[imgi].getAttribute('baksrc') != null)
                        imgs[imgi].src = imgs[imgi].getAttribute('baksrc');
                }
                imgLoad();
            }, 500);
        }
    }

    function imgLoad() {
        console.log("正式加载");
        var loaded = 0;
        var me = this;
        if ($('body img').length === 0 || navigator.userAgent.indexOf('MSIE 9') !=
            -1) {
            show_page();
        } else {
            $('body img').imagesLoaded().progress(function (instance, image) {
                loaded++;
                if (loaded == instance.images.length) {
                    show_page(me);
                }
            });
        }
        // work script
        function show_page(me) {
            $(".loading").fadeOut();
            $(".wrap").fadeIn();
            G.GAPageView('Homepage')
        }
    }


    $(".btn_rule").on(_click, function () {
        $(".rule").fadeIn();
        G.GAEvent('Homepage_rule');
        G.GAPageView('Rule');
    })
    $(".popRule").on(_click, function () {
        $(".rule").fadeOut();
    })
    $(".btn_login").on(_click, function () {
        G.GAEvent('Homepage_login');
        G.GAPageView('Account');
        // $(".loginPage").fadeIn();
        checkMember();
    })
    $(".btn_login2").on(_click, function () {
        G.GAEvent('Account_login');
        var loginName = $(".inputName").val();
        var loginPswd = $(".inputPswd").val();
        if (loginName == '' || !IsNum(loginName)) {
            alert('请输入正确客户编号');
            return false;
        }
        ;
        if (loginPswd == '') {
            alert('密码不能为空');
            return false;
        }
        // var data = {
        //     "user_id": $.trim(loginName),
        //     "user_pswd": $.trim(loginPswd),
        // }
        if (!$("btn_login2").hasClass('process')) {
            user_id = $.trim(loginName);
            $("btn_login2").addClass('process');
            checkMember();
        }
    });
    $(".btn_play").on(_click, function () {
        G.GAEvent('Lucky_click');
        if (!$(this).hasClass('process')) {
            $(this).addClass('process');
            var data = {
                "user_id": user_id,
                "user_pswd": $.trim($(".inputPswd").val()),
            }
            luckyDraw(data);
        }
    })
    $(".btn_congra").on(_click, function () {
        G.GAEvent('Winning_get');
        G.GAPageView('Info');
        $(".btn_congra").fadeOut();
        $(".lucky").fadeIn();
    })
    $(".btn_submit2").on(_click, function () {
        G.GAEvent('Info_submit');
        checkForm();
    })
    $(".btn_back").on(_click, function () {
        $(".prizeshow").fadeOut();
        $(".finger").fadeIn();
        $(".lucky").fadeIn();
    })

    $("input").blur(function() {
        $("body").scrollTop(0);
    })
});

function luckyDraw() {
    var dtd = $.Deferred();
    $.ajax({
        url: '/htib2c-mobile/servlet/LuckyDraw2Servlet',
        type: 'post',
        data:{
            "type":2
        },
        dataType:'json',
        success: function (res) {
            dtd.resolve(res);

            if(res!=null) {
                var type = res.luckyDrawNoticeType;
                if (type == 1) {//未登录
                    window.location.href = "accountLogin.xhtml?flag=luckyDraw";
                    //            window.location.href="http://www.baidu.com";
                }else {
                    if (res.ts == 3) { //没有中奖
                        $('.unlucky').fadeIn();
                        $(".btn_play").removeClass('process');
                        G.GAPageView('Not winning');
                    } else if (res.ts == 6) { //中奖了
                        prizeTye = res.tn;
                        $(".btn_play").fadeOut();
                        $(".gift").fadeOut();
                        $(".btn_play").removeClass('process');
                        $(".awardshow").hide();
                        $(".awardshow" + prizeTye).show();
                        $(".prizeshow").fadeIn();
                        $(".btn_congra,.prizebg").fadeIn();
                        $(".lighting").fadeIn();
                        showPrize(prizeTye);
                    }
                }
            }
            // if (res.errcode == "0") {
            //     if (res.user_prize_code == 0) { //没有中奖
            //         $('.unlucky').fadeIn();
            //         $(".btn_play").removeClass('process');
            //         G.GAPageView('Not winning');
            //     } else { //中奖了
            //         prizeTye = res.user_prize_code;
            //         $(".btn_play").fadeOut();
            //         $(".gift").fadeOut();
            //         $(".btn_play").removeClass('process');
            //         $(".awardshow").hide();
            //         $(".awardshow" + prizeTye).show();
            //         $(".prizeshow").fadeIn();
            //         $(".btn_congra,.prizebg").fadeIn();
            //         $(".lighting").fadeIn();
            //         showPrize(prizeTye);
            //     }
            // } else {
            //     dtd.reject();
            //     alert(res.message);
            // }
        }
    });
}

function showPrize(tye) {
    $(".award" + tye).fadeIn();
}

function checkMember() {
    var dtd = $.Deferred();
    $.ajax({
        url: '/htib2c-mobile/servlet/LuckyDraw2Servlet',
        type: 'POST', //post
        data: {
            "type": 1
        },
        dataType: 'json',
        success: function (res) {
            dtd.resolve(res);
            var type = res.luckyDrawNoticeType;
            if (type == 1) {//未登录
                window.location.href = "accountLogin.xhtml?flag=luckyDraw";
                //            window.location.href="http://www.baidu.com";
            }
            else if (type == 3||type==4||type==7) {//不符合资格
                $('.sorry').fadeIn();
                G.GAPageView('No lucky draw');
            }
            else if (type == 8) { //拥有抽奖资格未留资
                prizeTye = res.tn;
                $(".btn_play").fadeOut();
                $(".gift").fadeOut();
                $(".btn_play").removeClass('process');
                $(".awardshow").hide();
                $(".awardshow" + prizeTye).show();
                $(".prizeshow").fadeIn();
                $(".btn_congra,.prizebg").fadeIn();
                $(".lighting").fadeIn();
                showPrize(prizeTye);
                // showPrize(prizeTye);
                // $("btn_login2").removeClass('process');
                // $(".lucky").fadeIn();
            }else { //拥有抽奖资格
                $("btn_login2").removeClass('process');
                $('.luckyDraw').fadeIn();
                G.GAPageView('Lucky');
            }
            // if (res.errcode == "0") {
            //     if (res.user_access == 2) { //没有抽奖资格
            //         $('.sorry').fadeIn();
            //         G.GAPageView('No lucky draw');
            //     } else if (res.user_access == 3) { //已中奖，未留资料直接跳转留资页面
            //         $("btn_login2").removeClass('process');
            //         $(".lucky").fadeIn();
            //     } else { //拥有抽奖资格进入抽奖界面
            //         $("btn_login2").removeClass('process');
            //         $('.luckyDraw').fadeIn();
            //         G.GAPageView('Lucky');
            //     }
            // } else {
            //     dtd.reject();
            //     alert(res.message);
            // }
        }
    });
}


function checkForm() {
    var data = {
        "name": $.trim($(".luckyName").val()),
        "telNum": $.trim($(".luckyMobi").val()),
        "address": $.trim($(".luckyAdd").val())
    };

    if (data.name == "") {
        alert('请填写姓名');
        return false;
    }

    if (!data.telNum.match(/^(1(([3578][0-9])|(47)))\d{8}$/)) {
        alert('请填写正确的手机号码');
        return false;
    }
    if (data.address == "") {
        alert('请填写地址');
        return false;
    }
    block = true;
    postForm(data);
}

function postForm(data) {
    var dtd = $.Deferred();
    $.ajax({
        url:'/htib2c-mobile/servlet/LuckyDraw2DataServlet',
        type:'POST', //post
        dataType: 'json',
        data: data,
        success: function (res) {
            dtd.resolve(res);
            if(res!="0"){
                $(".success").fadeIn();
                G.GAPageView('submit successfully');
            } else {
                dtd.reject();
                alert(res.message);
            }
            block = false;
        }
    });
    return dtd;
}

function getMember() {
    var dtd = $.Deferred();
    $.ajax({
        url: '../api/member/me',
        cache: false,
        type: "get",
        dataType: "json",
        success: function (res) {
            dtd.resolve(res);
        },
        error: function (data) {
            dtd.reject();
            alert("error");
        }
    })
    return dtd;
}

function isWeiXin() {
    var ua = window.navigator.userAgent.toLowerCase();
    if (ua.match(/MicroMessenger/i) == 'micromessenger') {
        return true;
    } else {
        return false;
    }
}

function detect() {
    var equipmentType = "";
    var agent = navigator.userAgent.toLowerCase();
    var android = agent.indexOf("android");
    var iphone = agent.indexOf("iphone");
    var ipad = agent.indexOf("ipad");
    if (android != -1) {
        equipmentType = "android";
    }
    if (iphone != -1 || ipad != -1) {
        equipmentType = "ios";
    }
    return equipmentType;
}

function IsNum(s) {
    var reg = /^[0-9]+.?[0-9]*$/;
    if (reg.test(s) && s != "") {
        return true;
    }
    return false;
}
