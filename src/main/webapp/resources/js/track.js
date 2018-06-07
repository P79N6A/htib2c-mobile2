/**
 * Created by ohkei 66005199@qq.com
 */

//GA监测
/*(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
 (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
 m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
 })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

 ga('create', 'UA-98629510-4');
 ga('send', 'pageview');

 function ClickEvent(event,interaction) {
 if(interaction){
 console.log(event+","+interaction);
 }else{
 console.log(event);
 }

 event = event.toUpperCase();
 interaction=interaction||false;
 if (event.indexOf("BUT_") != -1) {

 try{ga('send', 'event', 'BUT', event, {'nonInteraction': interaction});}
 catch(err){};
 }
 else {

 try{ga('send', 'pageview',event, {'nonInteraction': interaction});}
 catch(err){};
 }
 }*/

window.dataLayer = window.dataLayer || [];
function gtag(){dataLayer.push(arguments);}
gtag('js', new Date());

/*gtag('config', 'UA-99008680-3', {
 'page_title'
 });
 gtag('event', 'event_name');*/
function ClickEvent(_val,_pv) {
    console.log(_val+ "," + _pv||"");
    //alert(_val+ "," + _pv||"");
    if(_pv){
        gtag('config', 'UA-119760192-1', {
            "page_title":_val
        });
    }else{
        gtag('event', _val);
    }
    var _openid = getUrlParam("openId");
    console.log("_openid:", _openid);
    fa("send", "click", _val, {"openid":_openid});
}

