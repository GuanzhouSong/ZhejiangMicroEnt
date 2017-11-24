require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules'], function (layer, dataTable, util, http,handlebars) {

    
    /**
     * 初始化函数集合
     */
	timeSet();
	init();
	
	function timeSet(){
		$('#selectDate').html('');	
        var d = new Date();
        var year = d.getFullYear();
        for(var a=1;a<=3;a++){
    	$('#selectDate').append("<option value='"+year+"'>"+year+"</option>");
        year--;
      }
	}
    
    function init() {
        bind();
        formValidate();
    }
    
    
    function formValidate(){
                http.httpRequest({
                    url: '/syn/infomange/inforecestat/getdata',
                    serializable: false,
                    data: {'year':$('#selectDate').val()},
                    type: 'post',
                    success: function (data) {
                    	$('.col').remove();
                    	for(var i=0;i<130;i++){
                    		for(var j=1;j<27;j++){
                    			if(i>(j-1)*26-1 && i<j*26) $('#tj'+j).append('<td class="col">'+data[i]+'</td>');
                    		}
                    	}
                    }
                });
       }
    
    function bind() {
        util.bindEvents([{
            el: '#reset',
            event: 'click',
            handler: function () {
            	timeSet();
            }
        },{
            el: '#search',
            event: 'click',
            handler: function () {
            	formValidate();
            }
        }
        ]);
    }
    
})
