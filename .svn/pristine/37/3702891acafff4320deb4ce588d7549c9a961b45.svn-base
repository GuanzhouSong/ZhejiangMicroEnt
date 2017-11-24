;(function ($) {

    /**
     * [tableInit description] 表格初始化之后才可以调用
     * @param  {[type]} dom1 [复选框的选择器]
     * @param  {[type]} btn [保存按钮]
     * @param  {[type]} table  [初始化的表格变量]
     */
    return tableInit = function (dom1, btn, table) {

        var hideArr = [];
        var showArr = [];

        _btnShow(table, btn, dom1, hideArr, showArr);
    };


    function _btnShow(table, btn, dom1, hideArr, showArr) {
        $(btn).on('click', function () {

            hideArr = [];
            showArr = [];

            //获取需要隐藏列得value值
            for (var i = 0; i < $(dom1).not(":checked").length; i++) {
                hideArr.push(parseInt($(dom1).not(":checked").eq(i).val()))
            }

            //获取需要显示列得value值
            for (var j = 0; j < $(dom1 + ":checked").length; j++) {
                showArr.push(parseInt($(dom1 + ":checked").eq(j).val()))
            }
        

            //隐藏列
            var columnHide = table.columns(hideArr);
            var columnShow = table.columns(showArr);
            columnHide.visible(false, false);
            columnShow.visible(true, false);

            //调整列的大小和重绘
            table.columns.adjust().draw( false );
        })
    }


})(jQuery);
