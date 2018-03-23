/**
 * Created by LinJe on 2016/2/3.
 * 轻量级UI，包括弹窗、横竖屏提醒等
 */
;(function( window, document, undefined ) {

    function WowUI() {
        this.styleTag = document.createElement('style');
        this.styleTag.type = 'text/css';
        document.getElementsByTagName('head')[0].appendChild(this.styleTag);
    }

    //html处理
    WowUI.prototype.innerHTML = {

        //弹窗类
        'dialog': {
            'confirm': function() {
                var oConfirm = document.createElement('div');

                oConfirm.className = 'wowui_dialog_confirm';
                oConfirm.innerHTML = '<div class="wowui_mask"></div>\n\
                                        <div class="wowui_dialog">\n\
                                            <div class="wowui_dialog_hd"><strong class="wowui_dialog_title">弹窗标题</strong></div>\n\
                                            <div class="wowui_dialog_bd">自定义弹窗内容，居左对齐显示，告知需要确认的信息等</div>\n\
                                            <div class="wowui_dialog_ft">\n\
                                                <a href="javascript:;" class="wowui_btn_dialog default">取消</a>\n\
                                                <a href="javascript:;" class="wowui_btn_dialog primary">确定</a>\n\
                                            </div>\n\
                                        </div>';

                document.getElementsByTagName('body')[0].appendChild(oConfirm);

                return {
                    'parentNode': oConfirm,
                    'title': document.querySelector('.wowui_dialog_confirm .wowui_dialog_title'),
                    'content':  document.querySelector('.wowui_dialog_confirm .wowui_dialog_bd'),
                    'cancle': document.querySelector('.wowui_dialog_confirm a.default'),
                    'ok': document.querySelector('.wowui_dialog_confirm a.primary')
                };
            },

            'alert': function() {
                var oAlert = document.createElement('div');

                oAlert.className = 'wowui_dialog_alert';
                oAlert.innerHTML = '<div class="wowui_mask"></div>\n\
                                    <div class="wowui_dialog">\n\
                                        <div class="wowui_dialog_hd"><strong class="wowui_dialog_title">弹窗标题</strong></div>\n\
                                        <div class="wowui_dialog_bd">弹窗内容，告知当前页面信息等</div>\n\
                                        <div class="wowui_dialog_ft">\n\
                                            <a href="javascript:;" class="wowui_btn_dialog primary">确定</a>\n\
                                        </div>\n\
                                    </div>';

                document.getElementsByTagName('body')[0].appendChild(oAlert);

                return {
                    'parentNode': oAlert,
                    'title': document.querySelector('.wowui_dialog_alert .wowui_dialog_title'),
                    'content':  document.querySelector('.wowui_dialog_alert .wowui_dialog_bd'),
                    'ok': document.querySelector('.wowui_dialog_alert a.primary')
                };
            }
        },

        //横竖屏提醒类
        'screenRemind': {
            'style1': function() {
                var oRemind = document.createElement('div');

                oRemind.className = 'wowui_screen_remind style1';
                oRemind.innerHTML = '<div class="icon">\n\
                                        <img src="data:image/png;base64,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" width="100%">\n\
                                        </div>';

                document.getElementsByTagName('body')[0].appendChild(oRemind);

                return {
                    'parentNode': oRemind
                };
            }
        }

    };

    //样式处理
    WowUI.prototype.style = {
        'dialog': function() {
            return document.createTextNode('.wowui_mask {\n\
                        position: fixed;\n\
                        z-index: 500;\n\
                        width: 100%;\n\
                        height: 100%;\n\
                        top: 0;\n\
                        left: 0;\n\
                        background: rgba(0, 0, 0, 0.6);\n\
                    }\n\
                    .wowui_dialog {\n\
                        position: fixed;\n\
                        z-index: 500;\n\
                        width: 85%;\n\
                        top: 50%;\n\
                        left: 50%;\n\
                        -webkit-transform: translate(-50%, -50%);\n\
                        transform: translate(-50%, -50%);\n\
                        background-color: #FAFAFC;\n\
                        text-align: center;\n\
                        border-radius: 3px;\n\
                    }\n\
                    .wowui_dialog_confirm .wowui_dialog .wowui_dialog_bd {\n\
                        text-align: left;\n\
                    }\n\
                    .wowui_dialog_hd {\n\
                        padding: 25px 20px 15px;\n\
                    }\n\
                    .wowui_dialog_title {\n\
                        font-weight: 400;\n\
                        font-size: 24px;\n\
                    }\n\
                    .wowui_dialog_bd {\n\
                        padding: 0 20px;\n\
                        font-size: 18px;\n\
                        color: #888;\n\
                    }\n\
                    .wowui_dialog_ft {\n\
                        position: relative;\n\
                        line-height: 52px;\n\
                        margin-top: 20px;\n\
                        font-size: 18px;\n\
                        display: -webkit-box;\n\
                        display: -webkit-flex;\n\
                        display: -ms-flexbox;\n\
                        display: flex;\n\
                    }\n\
                    .wowui_dialog_ft a {\n\
                        display: block;\n\
                        -webkit-box-flex: 1;\n\
                        -webkit-flex: 1;\n\
                        -ms-flex: 1;\n\
                        flex: 1;\n\
                        color: #3CC51F;\n\
                        text-decoration: none;\n\
                        -webkit-tap-highlight-color: rgba(0, 0, 0, 0);\n\
                    }\n\
                    .wowui_dialog_ft a:active {\n\
                        background-color: #EEEEEE;\n\
                    }\n\
                    .wowui_dialog_ft:after {\n\
                        content: " ";\n\
                        position: absolute;\n\
                        left: 0;\n\
                        top: 0;\n\
                        width: 100%;\n\
                        height: 1px;\n\
                        border-top: 1px solid #D5D5D6;\n\
                        color: #D5D5D6;\n\
                        -webkit-transform-origin: 0 0;\n\
                        transform-origin: 0 0;\n\
                        -webkit-transform: scaleY(0.5);\n\
                        transform: scaleY(0.5);\n\
                    }\n\
                    .wowui_dialog_confirm .wowui_dialog_ft a {\n\
                        position: relative;\n\
                    }\n\
                    .wowui_dialog_confirm .wowui_dialog_ft a:after {\n\
                        content: " ";\n\
                        position: absolute;\n\
                        left: 0;\n\
                        top: 0;\n\
                        width: 1px;\n\
                        height: 100%;\n\
                        border-left: 1px solid #D5D5D6;\n\
                        color: #D5D5D6;\n\
                        -webkit-transform-origin: 0 0;\n\
                        transform-origin: 0 0;\n\
                        -webkit-transform: scaleX(0.5);\n\
                        transform: scaleX(0.5);\n\
                    }\n\
                    .wowui_dialog_confirm .wowui_dialog_ft a:first-child:after {\n\
                        display: none;\n\
                    }\n\
                    .wowui_btn_dialog.default {\n\
                        color: #353535;\n\
                    }\n\
                    .wowui_btn_dialog.primary {\n\
                        color: #0BB20C;\n\
                    }');
        },

        'screenRemind': function() {
            return document.createTextNode('.wowui_screen_remind {\n\
                        position: fixed;\n\
                        top: 0;\n\
                        left: 0;\n\
                        z-index: 500;\n\
                        width: 100%;\n\
                        height: 100%;\n\
                        background: rgba(0, 0, 0, 0.9);\n\
                        display: none;\n\
                    }\n\
                    .wowui_screen_remind.style1 .icon {\n\
                        position: absolute;\n\
                        top: 50%;\n\
                        left: 50%;\n\
                        width: 46.87%;\n\
                        -webkit-transform: translate3d(-50%, -50%, 0);\n\
                        transform: translate3d(-50%, -50%, 0);\n\
                    }');
        }
    };

    //弹窗类
    WowUI.prototype.dialog = {
        '$confirm': function( title, content ) {
            var _this = this;

            if ( _this.confirmNode == undefined ) {
                _this.confirmNode = _this.render('dialog confirm');
            };

            _this.confirmNode.parentNode.style.display = 'block';
            _this.confirmNode.title.innerHTML = title;
            _this.confirmNode.content.innerHTML = content;
        },
        '$alert': function( title, content ) {
            var _this = this;

            if ( _this.alertNode == undefined ) {
                _this.alertNode = _this.render('dialog alert');
            };

            _this.alertNode.parentNode.style.display = 'block';
            _this.alertNode.title.innerHTML = title;
            _this.alertNode.content.innerHTML = content;
        }
    };

    //横竖屏提醒类
    WowUI.prototype.screenRemind = {
        '$style1': {
            'open': function() {
                var _this = this;

                if ( _this.screenRemind_style1_Node == undefined ) {
                    _this.screenRemind_style1_Node = _this.render('screenRemind style1');
                };
            }
        }
    };

    //弹窗渲染处理
    WowUI.prototype.render = function( type ) {
        var _this = this,
            node;

        switch (type) {
            //confirm弹窗
            case 'dialog confirm':
                node = _this.innerHTML.dialog.confirm();
                var parentNode = node.parentNode,
                    cancle = node.cancle,
                    ok = node.ok;

                if ( _this.dialogStyle == undefined ) {
                    _this.styleTag.appendChild(_this.style.dialog());
                }

                //点击取消
                cancle.onclick = function() {
                    parentNode.style.display = 'none';
                    //回调监听
                    typeof _this.dialog.$confirm.cancle == 'function' && _this.dialog.$confirm.cancle();
                };
                //点击确定
                ok.onclick = function() {
                    parentNode.style.display = 'none';
                    //回调监听
                    typeof _this.dialog.$confirm.ok == 'function' && _this.dialog.$confirm.ok();
                };
                break;

            //alert弹窗
            case 'dialog alert':
                node = _this.innerHTML.dialog.alert();
                var parentNode = node.parentNode,
                    ok = node.ok;

                if ( _this.dialogStyle == undefined ) {
                    _this.styleTag.appendChild(_this.style.dialog());
                }

                //点击确定
                ok.onclick = function() {
                    parentNode.style.display = 'none';
                    //回调监听
                    typeof _this.dialog.$alert.ok == 'function' && _this.dialog.$alert.ok();
                };
                break;

            //横竖屏提醒1
            case 'screenRemind style1':
                node = _this.innerHTML.screenRemind.style1();
                var parentNode = node.parentNode;

                if ( _this.screenRemind_style1_Style == undefined ) {
                    _this.styleTag.appendChild(_this.style.screenRemind());
                }

                function listenScreen(){
                    if(window.orientation == 180 || window.orientation == 0){
                        //竖屏状态
                        parentNode.style.display = 'none';
                    };
                    if(window.orientation == 90 || window.orientation == -90){
                        //横屏状态
                        parentNode.style.display = 'block';
                    };
                };
                listenScreen();
                window.addEventListener("onorientationchange" in window ? "orientationchange" : "resize", listenScreen, false);
                break;
        }

        return node;
    };

    WowUI.prototype.dialog.$confirm.cancle = null;
    WowUI.prototype.dialog.$confirm.ok = null;

    WowUI.prototype.dialog.$alert.ok = null;


    //对外暴露wowUI
    window.wowUI = new WowUI();

    //更改this指针
    //弹窗类
    wowUI.dialog.confirm = function( title, content ) {
        wowUI.dialog.$confirm.call(wowUI, title, content);
    };
    wowUI.dialog.alert = function( title, content ) {
        wowUI.dialog.$alert.call(wowUI, title, content);
    };
    //横竖屏提醒类
    wowUI.screenRemind.style1 = {
        'open': function() {
            wowUI.screenRemind.$style1.open.call(wowUI);
        }
    }

})( window, document );
