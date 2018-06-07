/**
 * Created by ohkei 66005199@qq.com
 */
;(function ($) {

    //******************** loading start ********************
    clearInterval(si_load);
    //si_load = setInterval(loadAni,300);
    var ballNum = 1;
    si_load = setInterval(loadBall,200);
    function loadBall(){
        ballNum++;
        if(ballNum>12){
            ballNum = 1;
        }
        $(".load-img").css({"top":(ballNum-1)*(-1334)+"px"});
    }

    $("body").lazyLoading()
        .progress(function (per) {
            //$("#loading pan").text(per + "%");

            var load_wd = per*5.21;
            load_wd = 1;
            console.log("per:",per,"load_wd:",load_wd);
            $(".load-bar-cur").css({"width":load_wd+"px","height":"12px"});
        })
        .callBack(function () {
            loadNum = 1;
            var si_load = setInterval(function(){
                loadNum++;
                var load_wd = loadNum*5.21;
                console.log("load_wd:",load_wd);
                $(".load-bar-cur").css({"width":load_wd+"px","height":"12px"});
                if(loadNum>=100){
                    clearInterval(si_load);
                    firstFn();
                    //loadNum = 1;
                }
            },5);

        });
    //******************** loading end********************

    /*document.querySelector('body').addEventListener('touchmove', function(e) {
     e.preventDefault();
     })*/

    //获取url参数：状态值
    var $ts = Number(getUrlParam("ts"))||"";

    //获取url参数：剩余次数
    var $num = getUrlParam("num")||"";

    //获取url参数：本次奖品等级
    var $tn = Number(getUrlParam("tn"))||"";

    console.log("$ts:",$ts,"$num:",$num,"$tn:",$tn);

    //获取url参数：本次奖品名称
    var $txt = getUrlParam("txt")||"";

    //获取url参数：总计奖品值
    var $tt1 = getUrlParam("tt1")||"";
    var $tt2 = getUrlParam("tt2")||"";
    var $tt3 = getUrlParam("tt3")||"";
    var $tt4 = getUrlParam("tt4")||"";

    var nameVal = "";
    var telVal = "";
    var addrVal = "";
    var errType = "";
    //
    var moveBoxInit = Number($(".move-box").css("left").split("px")[0]);
    var moveHandInit = Number($(".hand").css("left").split("px")[0]);
    var moveNum = moveBoxInit;
    var handLeftDis = moveHandInit - moveBoxInit;

    var handTopInit = Number($(".hand").css("top").split("px")[0]);
    var downNum = handTopInit;
    var prizeLeftDis = -46;
    var prizeTopDis = 833;
    //开启-首页
    function firstFn() {
        clearInterval(si_load);
        alphaDown($("#loading"));
        $(".home-pg").addClass("active");
        alphaUp($(".home-pg"));

        ClickEvent("P1.0", 1);
    }

    //活动规则-滑动
    var ruleTf = false;
    var ruleDownY = 0;
    var ruleInitY = Number($(".rule-txt").css("top").split("px")[0]);
    var ruleYmin = ruleInitY;
    var ruleYmax = 1937 - 766;
    $(".rule-txt").on("touchstart",function(e){
        //console.log(".rule-txt start");
        ruleTf = true;
        ruleDownY = e.changedTouches[0].clientY;
        ruleInitY = Number($(".rule-txt").css("top").split("px")[0]);

    });
    $(".rule-txt").on("touchend",function(e){
        //console.log(".rule-txt end");
        ruleTf = false;
    });
    $(".rule-txt").on("touchmove",function(e){
        //console.log(".rule-txt move");
        if(ruleTf){
            var e = e || window.event;
            //console.log(e.changedTouches[0].clientY);
            var ruleCurY = Number($(".rule-txt").css("top").split("px")[0]);
            var move_y = (e.changedTouches[0].clientY-ruleDownY);
            console.log(rule_y);
            var rule_y = ruleInitY + move_y;
            if(rule_y>ruleYmin){
                rule_y = ruleYmin;
            }
            if(rule_y<-ruleYmax){
                rule_y = -ruleYmax;
            }
            $(".rule-txt").css("top",rule_y+"px");
        }
    },false);

    //Button Event
    (function(){
        //活动规则-打开
        $(".rule-btn").click(function(){
            alphaUp($(".rule-pg"));
            rota360(".rule-close");
            //$('html,body,#page').css({'overflow':'hidden','height':'100%'});
            $(".page").css("position","fixed");

            ClickEvent("P1.0_Rule");
            ClickEvent("P1.1", 1);
        });
        //活动规则-关闭
        $(".rule-close").click(function(){
            alphaDown($(".rule-pg"));
            $(this).removeClass("rota360");
            //$('html,body,#page').css({'overflow':'auto','height':'1334px'});
            $(".page").css("position","absolute");

            ClickEvent("P1.1_Close");
        });

        //马上订购
        $(".dg-btn").click(function(){
            alphaDown($(".dg-pg"));
            ClickEvent("P2.0_Order");

            setTimeout(function(){
                window.location.href = "orderEntry.xhtml";
            },1000);
        });

        //开始游戏
        var keyP=0;
        $(".start-btn").click(function(){
            $(".start-btn").hide();
            // if(!touchTF){
            //     return;
            // }
            // touchTF = false;
            // setTimeout(function(){
            //     touchTF = true;
            // },twTimer*1000);

            $.ajax({
                url:'/htib2c-mobile/servlet/LuckyDraw2Servlet',
                type:'POST', //post
                async:false,    //或false,是否异步
                data:{
                    "type":1
                },
                dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                success:function(result){
                    if(result!=null){
                        var type =result.luckyDrawNoticeType;
                        if(type==3){
                            keyP=1;
                            alphaUp($(".end-pg"));
                        }
                        if(type==4){
                            keyP=1;
                            alphaUp($(".send-ok-pg"));
                        }
                        if(type==1){
                            window.location.href="accountLogin.xhtml?flag=luckyDraw2";
                            //            window.location.href="http://www.baidu.com";
                        }
                        $ts = Number(result.ts)

                        //获取url参数：剩余次数
                        $num =  result.num

                        //获取url参数：本次奖品等级
                        $tn = Number(result.tn)||"";


                        //获取url参数：本次奖品名称
                        $txt = result.txt||"";

                        //获取url参数：总计奖品值
                        $tt1 = result.tt1||"";
                        $tt2 = result.tt2||"";
                        $tt3 = result.tt3||"";
                        $tt4 = result.tt4||"";
                        if(type==6){
                            downAni($(".lose3-pg"),1);
                            $(".lose3-pg>.txt").text($txt);
                            $(".lose3-pg>.tt1").text($tt1);
                            $(".lose3-pg>.tt2").text($tt2);
                            $(".lose3-pg>.tt3").text($tt3);
                            ClickEvent("P3.2", 1);
                            keyP=1;
                        }
                        if(type==7){
                            downAni($(".lose2-pg"),1);
                            ClickEvent("P3.6", 1);
                            keyP=1;
                        }
                        if(type==8){
                            downAni($(".win2-pg"),1);
                            $(".win2-pg>.txt").text($txt);
                            $(".win2-pg>.tt1").text($tt1);
                            $(".win2-pg>.tt2").text($tt2);
                            $(".win2-pg>.tt3").text($tt3);
                            $(".win2-pg>.tt4").text($tt4);
                            ClickEvent("P3.3", 1);
                            keyP=1;
                        }

                    }
                },
                error:function(xhr){
                    //错误
                    alphaUp($(".send-ok-pg"));
                    return;
                }
            })
            ClickEvent("P1.0_Start");
            if($ts==1){
                //测试-订购页
                //alphaUp($(".dg-pg"));
                //scaleAni($(".dg-pg>img").eq(0));
                downAni($(".dg-pg"));
                ClickEvent("P2.0", 1);
            }else {
                //游戏页
                //alphaUp($(".game-pg"));
                alphaDown($(".home-pg"));
                startTime();
                ClickEvent("P3.0", 1);
            }

            //测试-中奖1
            //alphaUp($(".win1-pg"));

            //测试-中奖2
            //alphaUp($(".win2-pg"));

            //测试-未中奖1
            //alphaUp($(".lose1-pg"));

            //测试-未中奖2
            //alphaUp($(".lose2-pg"));

            //测试-未中奖3
            //alphaUp($(".lose3-pg"));
        });

        //再玩一次
        $(".re-btn").click(function(){
            //alphaDown($(this).parent());
            //history.go(0);
            if($ts==2){
                ClickEvent("P3.5_Again");
            }else if($ts==5){
                ClickEvent("P3.1_Again");
            }
            // setTimeout(function(){
            //     //location.reload();
            //     location.href = location.href;
            // },1000);
            // location.href = location.href;
            // $ts = 4;
            console.log($ts);
            $(".ctrl-btn").css("display","")
            $(".enter-btn").show();
            setTimeout(function(){
                //location.reload();
                //location.href = location.href;

                alphaDown($(".lose1-pg"));
                alphaDown($(".win1-pg"));
                //alphaUp($(".home-pg"));

                moveNum = moveBoxInit;
                downNum = handTopInit;

                $(".move-box").css("left",moveBoxInit+"px");
                $(".hand").css("left",moveHandInit+"px");
                startTime();
                enterTf = true;
                $(".prize").hide();
                $(".prize").css({"top":(downNum+prizeTopDis)+"px","left":(moveNum+prizeLeftDis)+"px"});
                moveTf = true;
                $(".hand").attr("src","../resources/images/img3/hand-1.png");
            },1000);
        });

        //关闭tip
        $(".close-btn").click(function(){
            if(errType == "name"){
                ClickEvent("P4.2_Close");
            }else if(errType == "tel"){
                ClickEvent("P4.3_Close");
            }else if(errType == "addr"){
                ClickEvent("P4.4_Close");
            }else{
                ClickEvent("P4.1_Close");
            }
            alphaDown($(this).parent());
            $(this).removeClass("rota360");

        });

        //****************** 倒计时 start ******************
        //-28058
        var numTop = 45;
        //var numTop = 22;
        var numGp2 = false;
        var pgHt = 1336;
        var pgTopInit = -2;
        //console.log(".num-img top值:",(-pgHt*(numTop-1)));
        //$(".num-img").css("top",(pgTopInit-pgHt*(numTop-1))+"px");
        var si_time = -3;
        function startTime(){
            clearInterval(si_time);
            setTimeout(function(){
                si_time = setInterval(function(){
                    if(keyP!=1){
                        numTop--;
                    }
                    /*if(!numGp2){
                     if(numTop<=0){
                     numGp2 = true;
                     $(".num-img").css("left","-754px");
                     numTop = 24;
                     }
                     }else{
                     if(numTop<=1){
                     clearInterval(si_time);
                     enterFn();
                     }
                     }
                     $(".num-img").css("top",(pgTopInit-pgHt*(numTop-1))+"px");*/
                    $(".num-img").text(numTop);
                    if(numTop<=0){
                        clearInterval(si_time);
                        enterFn();
                    }
                    if(numTop<=1){
                        clearInterval(si_time);
                        enterFn();
                    }
                },1000);
            },500);
        }
        //****************** 倒计时 end ******************


        //****************** 移动 start ******************
        var dist = 3;
        var moveTf = true;
        // var moveNum = Number($(".move-box").css("left").split("px")[0]);
        // var handLeftDis = Number($(".hand").css("left").split("px")[0])-moveNum;
        var si_move = -1;
        console.log("moveNum:",moveNum,"handLeftDis:",handLeftDis);
        $(".left-btn").on("touchstart",function(e){
            console.log(".left-btn");
            ClickEvent("P3.0_Left");
            $(".ctrl-btn").attr("src","../resources/images/img3/ctrl-1.png");
            clearInterval(si_move);
            si_move = setInterval(function(){
                if(!moveTf){
                    clearInterval(si_move);
                    ctrlImgInit();
                    return;
                }
                if(moveNum>300){
                    moveNum -= dist;
                    $(".move-box").css("left",moveNum+"px");
                    $(".hand").css("left",(moveNum+handLeftDis)+"px");
                }
            },10);
        });
        $(".right-btn").on("touchstart",function(e){
            console.log(".right-btn");
            ClickEvent("P3.0_Right");
            $(".ctrl-btn").attr("src","../resources/images/img3/ctrl-2.png");
            clearInterval(si_move);
            si_move = setInterval(function(){
                if(!moveTf){
                    clearInterval(si_move);
                    ctrlImgInit();
                    return;
                }
                if(moveNum<600){
                    moveNum += dist;
                    $(".move-box").css("left",moveNum+"px");
                    $(".hand").css("left",(moveNum+handLeftDis)+"px");
                }
            },10);
        });
        $(".left-btn").on("touchend",function(e){
            clearInterval(si_move);
            ctrlImgInit();
        });
        $(".right-btn").on("touchend",function(e){
            clearInterval(si_move);
            ctrlImgInit();
        });
        function ctrlImgInit(){
            $(".ctrl-btn").attr("src","../resources/images/img3/ctrl-btn.png");
        }
        //****************** 移动 end ******************


        //****************** 抓取 start ******************
        var enterTf = true;
        // var downNum = Number($(".hand").css("top").split("px")[0]);
        // var handTopInit = downNum;
        var si_down = -2;
        // var prizeLeftDis = -46;
        // var prizeTopDis = 833;

        $(".enter-btn").click(function(){
            $(".ctrl-btn").css("display","none")
            $(".enter-btn").hide();
            if(!enterTf){
                return;
            }
            ClickEvent("P3.0_Grab");
            enterFn();
        });
        function enterFn(){
            enterTf = false;
            ctrlImgInit();
            clearInterval(si_time);
            moveTf = false;
            $(".hand").attr("src","../resources/images/img3/hand-2.png");
            clearInterval(si_down);
            $.ajax({
                url:'/htib2c-mobile/servlet/LuckyDraw2Servlet',
                type:'POST', //post
                async:false,    //或false,是否异步
                data:{
                    "type":2
                },
                dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                success:function(result){
                    if(result!=null){
                        var type =result.luckyDrawNoticeType;
                        if(type==3){
                            alphaUp($(".send-ok-pg"));
                        }
                        // if(type==4){
                        //     alphaUp($(".send-ok-pg"));
                        // }
                        // if(type==1){
                        //     window.location.href="accountLogin.xhtml?flag=luckyDraw2";
                        //     //            window.location.href="http://www.baidu.com";
                        // }
                        $ts = Number(result.ts)

                        //获取url参数：剩余次数
                        $num =  result.num

                        //获取url参数：本次奖品等级
                        $tn = Number(result.tn)||"";


                        //获取url参数：本次奖品名称
                        $txt = result.txt||"";

                        //获取url参数：总计奖品值
                        $tt1 = result.tt1||"";
                        $tt2 = result.tt2||"";
                        $tt3 = result.tt3||"";
                        $tt4 = result.tt4||"";
                        // if(type==6){
                        //     downAni($(".lose3-pg"),1);
                        //     $(".lose3-pg>.txt").text($txt);
                        //     $(".lose3-pg>.tt1").text($tt1);
                        //     $(".lose3-pg>.tt2").text($tt2);
                        //     $(".lose3-pg>.tt3").text($tt3);
                        //     ClickEvent("P3.2", 1);
                        //     keyP=1;
                        // }
                        // if(type==7){
                        //     downAni($(".lose2-pg"),1);
                        //     ClickEvent("P3.6", 1);
                        //     keyP=1;
                        // }
                        // if(type==8){
                        //     downAni($(".win2-pg"),1);
                        //     $(".win2-pg>.txt").text($txt);
                        //     $(".win2-pg>.tt1").text($tt1);
                        //     $(".win2-pg>.tt2").text($tt2);
                        //     $(".win2-pg>.tt3").text($tt3);
                        //     $(".win2-pg>.tt4").text($tt4);
                        //     ClickEvent("P3.3", 1);
                        //     keyP=1;
                        // }

                        }
                },
                error:function(xhr){
                    //错误
                    alphaUp($(".send-ok-pg"));
                    return;
                }
            })
            si_down = setInterval(function(){
                if(downNum<-50){
                    downNum += dist;
                    $(".hand").css("top",downNum+"px");
                }else{
                    clearInterval(si_down);
                    console.log("到底了");
                    $(".hand").attr("src","../resources/images/img3/hand-1.png");

                    if($ts==5||$ts==6){
                        //中奖
                        $(".prize").attr("src","../resources/images/img3/prize-"+$tn+".png");
                    }else{
                        //未中
                        $(".prize").attr("src","../resources/images/img3/prize-5.png");
                    }
                    //$(".prize").removeClass("none");
                    $(".prize").show();
                    $(".prize").css({"top":(downNum+prizeTopDis)+"px","left":(moveNum+prizeLeftDis)+"px"});
                    si_down = setInterval(function(){
                        if(downNum>handTopInit){
                            downNum -= dist;
                            $(".hand").css("top",downNum+"px");
                            $(".prize").css({"top":(downNum+prizeTopDis)+"px"});
                        }else{
                            clearInterval(si_down);
                            console.log("到顶了");

                            //未抓到奖球，脱落
                            if($ts<5){
                                clearInterval(si_down);
                                si_down = setInterval(function(){
                                    if(downNum<180+handTopInit){
                                        downNum += dist;
                                        $(".prize").css({"top":(downNum+prizeTopDis)+"px"});
                                    }else{
                                        clearInterval(si_down);
                                        console.log("落入球堆了");
                                    }
                                });
                            }

                            clearInterval(si_move);
                            si_move = setInterval(function(){
                                if(moveNum>93){
                                    moveNum -= dist;
                                    $(".move-box").css("left",moveNum+"px");
                                    $(".hand").css("left",(moveNum+handLeftDis)+"px");
                                    if($ts>=5){
                                        $(".prize").css({"left":(moveNum+prizeLeftDis)+"px"});
                                    }
                                }else{
                                    clearInterval(si_move);
                                    console.log("到洞口上方了");
                                    console.log("downNum:",downNum);
                                    $(".hand").attr("src","../resources/images/img3/hand-2.png");

                                    //本次无奖
                                    if($ts<5){
                                        if($ts==2){
                                            //本次未中奖，非最后一次
                                            //alphaUp($(".lose1-pg"),1);
                                            //scaleAni($(".lose1-pg>img").eq(0),1);
                                            downAni($(".lose1-pg"),1);
                                            $(".lose1-pg>.num").text($num);
                                            ClickEvent("P3.5", 1);
                                        }else if($ts==3){
                                            //本次未中奖，总计无奖，最后一次
                                            //alphaUp($(".lose2-pg"),1);
                                            //scaleAni($(".lose2-pg>img").eq(0),1);
                                            downAni($(".lose2-pg"),1);
                                            ClickEvent("P3.6", 1);
                                        }else{
                                            // if($ts==4)
                                            //本次未中奖，总计有奖，最后一次
                                            //alphaUp($(".lose3-pg"),1);
                                            //scaleAni($(".lose3-pg>img").eq(0),1);
                                            downAni($(".lose3-pg"),1);
                                            $(".lose3-pg>.txt").text($txt);
                                            $(".lose3-pg>.tt1").text($tt1);
                                            $(".lose3-pg>.tt2").text($tt2);
                                            $(".lose3-pg>.tt3").text($tt3);
                                            ClickEvent("P3.2", 1);
                                        }
                                        return;
                                    }

                                    //本次有奖
                                    clearInterval(si_down);
                                    si_down = setInterval(function(){
                                        if(downNum<260+handTopInit){
                                            downNum += dist;
                                            $(".prize").css({"top":(downNum+prizeTopDis)+"px"});
                                        }else{
                                            clearInterval(si_down);
                                            console.log("落入洞口了");

                                            if($ts==5){
                                                //本次中奖，非最后一次
                                                //alphaUp($(".win1-pg"),1);
                                                //scaleAni($(".win1-pg>img").eq(0),1);
                                                downAni($(".win1-pg"),1);
                                                $(".win1-pg>.txt").text($txt);
                                                $(".win1-pg>.num").text($num);
                                                ClickEvent("P3.1", 1);
                                            }else if($ts==6){
                                                //本次中奖，总计有奖，最后一次
                                                //alphaUp($(".win2-pg"),1);
                                                //scaleAni($(".win2-pg>img").eq(0),1);
                                                downAni($(".win2-pg"),1);
                                                $(".win2-pg>.txt").text($txt);
                                                $(".win2-pg>.tt1").text($tt1);
                                                $(".win2-pg>.tt2").text($tt2);
                                                $(".win2-pg>.tt3").text($tt3);
                                                $(".win2-pg>.tt4").text($tt4);
                                                ClickEvent("P3.3", 1);
                                            }
                                        }
                                    },10);
                                }
                            },10);
                        }
                    },10);
                }
            },10);
        }
        //****************** 抓取 end ******************

        $(".enter-btn").show();
        $(".ctrl-btn").css("display","")
        //****************** 留资 start ******************
        $(".send-btn").click(function(){
            if(!touchTF){
                return;
            }

            nameVal = "";
            telVal = "";
            addrVal = "";

            if($ts==6){
                nameVal = $(".win2-pg .name").val();
                telVal = $(".win2-pg .tel").val();
                addrVal = $(".win2-pg .addr").val();
                ClickEvent("P3.3_Sub");
            }else{
                nameVal = $(".lose3-pg .name").val();
                telVal = $(".lose3-pg .tel").val();
                addrVal = $(".lose3-pg .addr").val();
                ClickEvent("P3.2_Sub");
            }

            console.log("nameVal:",nameVal,$(".name").text()," telVal:"+telVal, " addrVal:"+addrVal);
            if(nameVal==""){
                //alphaUp($(".tip-name-pg"));
                //scaleAni($(".tip-name-pg>img").eq(0));
                errType = "name";
                downAni($(".tip-name-pg"));
                rota360(".close-btn");
                ClickEvent("P4.2", 1);
                return;
            }
            if(telVal==""){
                //alphaUp($(".tip-tel-pg"));
                //scaleAni($(".tip-tel-pg>img").eq(0));
                errType = "tel";
                downAni($(".tip-tel-pg"));
                rota360(".close-btn");
                ClickEvent("P4.3", 1);
                return;
            }
            if(addrVal==""){
                //alphaUp($(".tip-addr-pg"));
                //scaleAni($(".tip-addr-pg>img").eq(0));
                errType = "addr";
                downAni($(".tip-addr-pg"));
                rota360(".close-btn");
                ClickEvent("P4.4", 1);
                return;
            }
            /*if(!checkTel(telVal)){
                //alphaUp($(".tip-err-pg"));
                //scaleAni($(".tip-err-pg>img").eq(0));
                errType = "err";
                downAni($(".tip-err-pg"));
                rota360(".close-btn");
                ClickEvent("P4.1", 1);
                return;
            }*/
            touchTF = false;
            $.ajax({
                url:'/htib2c-mobile/servlet/LuckyDraw2DataServlet',
                type:'POST', //post
                async:false,    //或false,是否异步
                data:{
                    "name":nameVal,"telNum":telVal,"address":addrVal
                },
                dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                success:function(result){
                    touchTF = true;
                    if(result!="0"){
                        downAni($(".send-ok-pg"));
                        ClickEvent("P3.4", 1);
                    }else{
                        alphaUp($(".tip-err-pg"));
                    }
                },
                error:function(xhr){
                    touchTF = true;
                    //错误
                    alphaUp($(".tip-err-pg"));
                    return;
                }
            })

            //测试提交成功
            //alphaUp($(".send-ok-pg"));
            //scaleAni($(".send-ok-pg>img").eq(0));
            //
            // touchTF = false;
            // myLab.ajax({
            //     url: "http://subaru.agenda-bj.com.cn/Subaru/Subaru1225",
            //     type: "post",
            //     data: {
            //         openid:openid,
            //         name:nameVal,
            //         tel:telVal,
            //         addr:addrVal,
            //         utm_source:utm_source,
            //         utm_medium:utm_medium
            //     },
            //     dataType: "text",
            //     success: function (data) {
            //         /*{ result = 1, msg = "提交成功" }
            //          { result = 0, msg = "提交失败" }*/
            //         touchTF = true;
            //         jsonAll = JSON.parse(data);
            //
            //         if(Number(jsonAll.result)==1){
            //             //alert("提交成功");
            //             //alphaUp($(".send-ok-pg"));
            //             //scaleAni($(".send-ok-pg>img").eq(0));
            //             downAni($(".send-ok-pg"));
            //             ClickEvent("P3.4", 1);
            //         }else{
            //             wowUI.dialog.alert("提 示", jsonAll.msg);
            //         }
            //     },
            //     error:function(data){
            //         touchTF = true;
            //         wowUI.dialog.alert("提 示", data);
            //     }
            // });
        });
        //****************** 留资 end ******************

    })();
})(Zepto);

