/**
 * Created by lp on 2017/5/5.
 */


$(function () {
    $(document.body).bind('touchmove', function (event) {
        /*event.preventDefault();*/
    });
//页面高度
    var w = $(window).width();
    var h = $(window).height()
    $('.page').width(w);
    $('.page').height(h);


    $('#helptel,.span2').click(function () {
        window.location.href = 'tel:4008980050'
    })
    $('.alert .span2').click(function () {
        window.location.href = 'tel:4008980050'
    })

    //键盘按钮
    $('.numbtn').click(function(){

    })
    /*$('#censel span').click(function(){
     window.location.href='key.html'
     })*/
    $('#censel span').bind('touchstart',function(){
        $(this).removeClass('textshadow')
        $(this).addClass('textlight')
    })
    $('#censel span').bind('touchend',function(){
        $(this).removeClass('textlight')
        $(this).addClass('textshadow')
        window.location.href='key.xhtml'
    })
    $('#censel div').bind('touchstart',function(){
        $(this).removeClass('textshadow')
        $(this).addClass('textlight')
    })
    $('#censel div').bind('touchend',function(){
        $(this).removeClass('textlight')
        $(this).addClass('textshadow')
    })
    var clickNum=0;
    $('.numbtn').each(function(i,divs){
        $(divs).bind('touchstart',function(){
            $(divs).css('background','url("../resources/images/img/keybg2.png") repeat-x')
            clickNum++;
            var thisval=$(this).attr('datanum')
            var thisfunction=$(this).attr('data')
            var thePw=$('#keytc').html();
            var  thetxt=$('#keyPW').html();
            if(thisval){
                if(thetxt.length < 4){
                    thetxt+=thisval
                    thePw += "*"
                }
                
            }else
            if(thisfunction=='over'){
            	
            }else
            if(thisfunction=='backspace'){
                thetxt=thetxt.substr(0,thetxt.length-1);
                thePw=thePw.substr(0,thePw.length-1)
            }
            $('#keytc').html(thePw);
            $('#keyPW').html(thetxt);
//            if(thetxt.length==4){
//            	checkPin();
//            }
        })
        $(divs).bind('touchend',function(){
            $(divs).css('background','url(" ../resources/images/img/keybg.png") repeat-x')
        })
    })

})