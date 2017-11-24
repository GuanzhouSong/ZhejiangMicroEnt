+function (factory) {
    if (typeof define === 'function' && define.amd) {
        // AMD
        define(['jquery'], factory);
    } else {
        factory($);
    }
}(function ($) {
    'use strict';
    var defaultOptions = {
        trigger: 'click',
        target: ''
    };

    function dropDown(el, options) {
        this.options = $.extend({}, defaultOptions, options || {});
        this.el = el;
        this.attachEvent();
    }

    var fn = dropDown.prototype;
    fn.show = function () {
        var target = this.options.target;
        this.el.addClass('drop-on');
        $(target).show();
    };
    fn.hide = function () {
        var target = this.options.target;
        this.el.removeClass('drop-on');
        $(target).hide();
    };
    fn.toggle = function () {
        var target = this.options.target;
        $(target).toggle();
        this.el.toggleClass('drop-on')
    };

    /**
     * 事件绑定
     */
    fn.attachEvent = function () {
        var options = this.options;
        var type = options.trigger;
        var me = this;
        var el = this.el;
        switch(type){
            case 'hover':
                this.el.hover(function () {
                    me.show();
                    el.trigger('hx.dropdown.show');
                }, function () {
                    me.hide();
                    el.trigger('hx.dropdown.hide');
                });
                break;
            case 'toggle':
                this.el.on('click', function () {
                    me.toggle();
                    el.trigger('hx.dropdown.toggle');
                });
                break;
            default:
                break;
        }
    };

    /**
     * 获得元素的data自定义属性
     * @param el
     * @returns {{}}
     */
    function readOptions(el) {
        var options = {};
        var config = [];
        for (var n in defaultOptions) {
            config.push(n);
        }
        for (var i = 0, l = config.length; i < l; i++) {
            var n = config[i];
            var an = 'data-' + n;
            var val = el.attr(an);
            options[n] = val;
        }
        return options;
    }

    /**
     * 初始化dropdown对象
     * @param context
     */
    function init(context) {
        var selector = '[data-component="dropDown"]';
        context.find(selector).each(function () {
            var el = $(this);
            var options = readOptions(el);
            var data = el.data('dropDown');
            if (!data) {
                el.data('dropDown', data = new dropDown(el, options));
            }
        })
    }

    $(function () {
        var $doc = $(document);
        init($doc);
    })
});