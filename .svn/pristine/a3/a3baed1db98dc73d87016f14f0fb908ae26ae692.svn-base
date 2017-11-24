+function (factory) {
    if (typeof define === 'function' && define.amd) {
        // AMD
        define(['jquery'], factory);
    } else {
        factory(jQuery);
    }
}(function ($) {
    /****
     * input框点击删除按钮填充占位符
     * input框获得焦点时提示框显示，可传对应的参数进行重置
     */
    $.fn.expandInput = function (options) {
        var opt = options;
        var defaultOptions = {
            follow: '',  //类似layer.tips的follow传值，表示定位到哪个元素上
            tipsMessage: '',    //提示文案
            placeholder: '',    //占位字符，可自定义
            tipsOptions: {tips: 1}  //类似layer.tips的options传值
        };

        function Input(el, options) {
            this.options = $.extend({}, defaultOptions, options || {});
            this.el = el;
            this.input = this.el.find('input');
            this.close = this.el.find('icon-close');
            this.attachEvent();
        }

        var fn = Input.prototype;
        fn.attachEvent = function () {
            var options = this.options;
            var me = this.el;
            var input = this.input;
            var closeClick = false;
            me.off('focusout.expandInput').on('focusout.expandInput', function (e) {
                if (closeClick) {
                    e.stopImmediatePropagation();
                }
            });
            me.on('mousedown.expandInput', function (e) {
                closeClick = false;
                var target = e.target.tagName.toLocaleLowerCase();
                switch (target) {
                    case 'input':
                        var message = options['tipsMessage'];
                        if (message) {
                            var el = options.follow || input;
                            layer && layer.tips(message, el, $.parseJSON(options.tipsOptions))
                        }
                        break;
                    case 'i':
                        closeClick = true;
                        input.val('');
                        break;
                    default:
                        break;
                }
            });
        };
        function readOptions(el) {
            var options = {}, config = [];
            for (var n in defaultOptions) {
                n = n.replace(/([A-Z])/g, "-$1").toLowerCase();
                config.push(n);
            }
            for (var i = 0, l = config.length; i < l; i++) {
                var n = config[i];
                var an = 'data-' + n;
                if (n.indexOf('-') != -1) {
                    n = ($.map(n.split('-'), function (v, i) {
                        if (i == 0) return v;
                        return v.charAt(0).toUpperCase() + v.substring(1, v.length);
                    })).join('');
                }
                var val = el.attr(an);
                if (val) {
                    if (val == "0") {
                        val = false;
                    }
                }
                options[n] = val;
            }
            return options;
        }

        var that = $(this);

        function init() {
            that.each(function () {
                var el = $(this);
                var options = $.extend({}, opt || {}, readOptions(el));
                el.data('Input', new Input(el, options));
            })
        }

        $(function () {
            init();
        });
    }

});