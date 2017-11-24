require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	init();
	 var count=0;
	 var totalEntC = $("#totalEntC").val();
	 totalEntC = parseInt(totalEntC) *2;
    /**
	 * 初始化函数集合
	 */
    function init() { 
        bind();
       
    }
    var compSwiper;
    var perSwiper;
    
    function carrousel(swiptercont) {
        this.node = $(swiptercont);
        this.rocking = true;
        this.height = this.node.find('li').height();
        this.length = this.node.find('li').length;

        this.init = function() {
            this.node.append(this.node.find('li').eq(0).clone());
            this.node.append(this.node.find('li').eq(1).clone());
            this.node.append(this.node.find('li').eq(2).clone());
            this.node.find('li').eq(1).addClass('special02')
//            this.node.height(this.height*(this.length+3));
            this.swiper();

        };
        this.swiper = function() {
            var that=this;

            this.node.animate({
                marginTop: '-='+8+ 'px'
            }, 30,'linear', function() {
                var margTop = $(this).css('marginTop').slice(0, -2);

                if(margTop%that.height==-that.height/2){
                    $(this).find('li').eq(2-Math.ceil(margTop/that.height)).addClass('special02').siblings().removeClass('special02');
                    if(count == totalEntC){
                    	that.rocking=false;
                    	$("#cancel").hide();
                    	$("#start").hide();
                    	$("#next").show();
                    	$("#gdDiv").hide();
                    	$("#totalShow").show();
                	}else{
                		count++;
                	}
                }

                if(margTop%that.height==0){
                    if(margTop/that.height == -that.length) {
                        $(this).css('marginTop', '0px');
                        that.node.find('li').eq(1).addClass('special02').siblings().removeClass('special02');
                        if(count == totalEntC){
                        	that.rocking=false;
                        	$("#cancel").hide();
                        	$("#start").hide();
                        	$("#next").show();
                        	$("#gdDiv").hide();
                        	$("#totalShow").show();
                    	}else{
                    		count++;
                    	}
                    }

                    if(!that.rocking){
                        return false;
                    }
                }

                that.swiper();
            });

        }
        this.stop=function () {
            this.rocking=false;
        }

        this.init();
    }
   
    function bind() {
    	util.bindEvents([{
            el: '#start',
            event: 'click',
            handler: function () {
            	compSwiper = new carrousel('.swiper-comp');
            	perSwiper = new carrousel('.swiper-person');
            	$("#cancel").show();
            	$("#start").hide();
            	count = 0;
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	compSwiper.stop();
            	perSwiper.stop();
            	$("#cancel").hide();
            	$("#start").show();
            }
        },{
        	el: '#next',
        	event: 'click',
        	handler: function () {
        		var deptTaskUid =$("#deptTaskUid").val();
        		layer.dialog({
		            title: '企业和执法人员随机配对结果',
		            area: ['100%', '100%'],
		            content:window._CONFIG.chooseUrl+'/pub/server/sccheck/entagent/viewall?deptTaskUid='+deptTaskUid,
		            callback: function (data) {
		            	if(data.reload){
		            		layer.close({reload:true});
		            	}
		            	if(data.rerandom){
		            		window.location.reload(true);
		            	}
		            }
		        })
        	}
        }]);
    }
});
