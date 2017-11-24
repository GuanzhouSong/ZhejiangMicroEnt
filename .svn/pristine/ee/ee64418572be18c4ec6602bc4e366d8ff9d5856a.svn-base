/**
 * 消除from表单红色边框和提示语
 * 消除选择否 输入框中的红色边框和提示语
 * author:wangjin
 */
define(['jquery'], function ($) {
    return {
        //选择的是form 或id 对象
        clearTips: function (form) {
            var selector = $('#' + form + ' input,#' + form + ' textarea,#' + form + ' select'), parentEle, cls;
            for (var i = 0; i < selector.length; i++) {
                ele = selector.eq(i);
                if (ele.is('input') && ele.attr('type') != 'text') {
                    cls = 'error-tips-radio';
                    ele.closest('.radio-box').removeClass(cls);
                } else if (ele.is('select')) {
                    cls = 'error-tips';
                    ele.removeClass(cls);
                } else {
                    cls = 'error-tips';
                    ele.removeClass(cls);
                    parentEle = ele.parent();
                    if (parentEle.has('.js-error-tips').length) {
                        parentEle.find('.js-error-tips').remove();
                    }
                }
            }
        },
        //选择的是input的对象
        clearSelect:function($this){
            var cls = 'error-tips';
            $this.removeClass(cls);
            var parentEle = $this.parent();
            if (parentEle.has('.js-error-tips').length) {
                parentEle.find('.js-error-tips').remove();
            }
        }
    }

});