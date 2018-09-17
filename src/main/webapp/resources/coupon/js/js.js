/**
 * Created by lp on 2017/5/5.
 */


$(function(){
    $(document.body).bind('touchmove', function (event) {
        //event.preventDefault();
    });
//ҳ��߶�
    var w=$(window).width();
    var h=$(window).height()
//     $('.page').width(w);
//    $('.page').height(h);


    $('#helptel,.span2').click(function(){
        window.location.href='tel:4008980050'
    })
    $('.alert .span2').click(function(){
        window.location.href='tel:4008980050'
    })

    //���̰�ť
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
        window.location.href='key.html'
    })
    $('#censel div').bind('touchstart',function(){
        $(this).removeClass('textshadow')
        $(this).addClass('textlight')
    })
    $('#censel div').bind('touchend',function(){
        $(this).removeClass('textlight')
        $(this).addClass('textshadow')
    })
   $('.numbtn').each(function(i,divs){
       $(divs).bind('touchstart',function(){
           $(divs).css('background','url("img/keybg2.png") repeat-x')
           var thisval=$(this).attr('datanum')
           var thisfunction=$(this).attr('data')
           var thetxt=$('#keytc').html();
           if(thisval){
               thetxt+=thisval
           }else
           if(thisfunction=='over'){
               //alert(thetxt)
           }else
           if(thisfunction=='backspace'){
               thetxt=thetxt.substr(0,thetxt.length-1)
           }
           $('#keytc').html(thetxt)
       })
       $(divs).bind('touchend',function(){
           $(divs).css('background','url("img/keybg.png") repeat-x')
       })
   })

})