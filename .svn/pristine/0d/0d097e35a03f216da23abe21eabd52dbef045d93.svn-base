define("component/layer",["layer1"],
		function(e){function t(){var e=parent.layer.getFrameIndex(window.name);return e}
		return parent.CALLBACK={},
		{dialog:function(t){var n={ltype:1,type:2},r=$.extend({},n,t),a=1===r.ltype?parent.layer:e,o=a.open(
				{title:r.title,area:r.area,content:r.content,type:r.type,zIndex:a.zIndex,
					success:function(e){a.setTop(e)},end:function(){r.callback&&r.callback(parent.CALLBACK)}});return o},
					close:function(n){parent.CALLBACK.reload=!1;
					var r={ltype:1},a=$.extend({},r,n),o=1===a.ltype?parent.layer:e;a.reload&&
					(parent.CALLBACK.reload=a.reload);
					var c=1===a.ltype?t():a.index;o.close(c)},
					closeAll:function(t,n){var r=n&&1===n?parent.layer:e;r.closeAll(t)},
					alert:function(t,n,r)
					{var a={ltype:1},o=$.extend({},a,n),c=1===o.ltype?parent.layer:e;o=$.extend(o,
							{zIndex:c.zIndex,success:function(e){c.setTop(e)}});var s=c.alert(t,o,r);return s},
							confirm:function(t,n,r,a)
							{var o={ltype:1},c=$.extend({},o,n),s=1===c.ltype?parent.layer:e;
							return c=$.extend(c,{zIndex:s.zIndex,success:function(e){s.setTop(e)}}),
							s.confirm(t,c,r,a)},
							msg:function(t,n,r){var a={ltype:1},
								o=$.extend({},a,n),c=1===o.ltype?parent.layer:e;
							return o=$.extend(o,{zIndex:c.zIndex,
								success:function(e){c.setTop(e)}}),c.msg(t,o,r)}}}),
								define("common/util",["jquery"],
										function(){return{bindEvents:function(e){$.each(e,function(e,t)
												{"string"==typeof t.el?
														$(document).on(t.event,t.el,t.handler):$(t.el).on(t.event,t.handler)})},
														getUrlParams:function(e){var t={},n=[];return e&&-1!==e.indexOf("?")?($.each(e.substr(e.indexOf("?")+1).split("&"),function(e,r){n=r.split("="),t[n[0]]=n[1]}),t):t},trims:function(e){var t,n=[];return $.each(e,function(e,r){t=r.replace(/ /g,""),""!=t&&n.push(t)}),n},timeInterval:function(e,t){var n=arguments[2]||new Date;switch(e){case"s":n=new Date(n.getTime()+1e3*t);break;case"n":n=new Date(n.getTime()+6e4*t);break;case"h":n=new Date(n.getTime()+36e5*t);break;case"d":n=new Date(n.getTime()+864e5*t);break;case"w":n=new Date(n.getTime()+6048e5*t);break;case"m":n=new Date(n.getFullYear(),n.getMonth()+t,n.getDate(),n.getHours(),n.getMinutes(),n.getSeconds());break;default:n=new Date(n.getFullYear()+t,n.getMonth(),n.getDate(),n.getHours(),n.getMinutes(),n.getSeconds())}return n=n.getTime()>=(new Date).getTime()?new Date:n,[n.getFullYear(),n.getMonth()+1,n.getDate()].join("/")},dateFormat:function(e,t){var n=t,r=["日","一","二","三","四","五","六"];return n=n.replace(/yy/,e.getFullYear()),n=n.replace(/y/,e.getYear()%100>9?(e.getYear()%100).toString():"0"+e.getYear()%100),n=n.replace(/mm/,e.getMonth()>9?(e.getMonth()+1).toString():"0"+(e.getMonth()+1)),n=n.replace(/m/g,e.getMonth()+1),n=n.replace(/w|W/g,r[e.getDay()]),n=n.replace(/dd/,e.getDate()>9?e.getDate().toString():"0"+e.getDate()),n=n.replace(/d/g,e.getDate()),n=n.replace(/hh/,e.getHours()>9?e.getHours().toString():"0"+e.getHours()),n=n.replace(/h/g,e.getHours()),n=n.replace(/mm/,e.getMinutes()>9?e.getMinutes().toString():"0"+e.getMinutes()),n=n.replace(/m/g,e.getMinutes()),n=n.replace(/ss/,e.getSeconds()>9?e.getSeconds().toString():"0"+e.getSeconds()),n=n.replace(/s/g,e.getSeconds())}}}),
														define("common/http",["jquery","component/layer"],function(e,t){function n(n){var a=e.extend({},s,n);return a.beforeSend=function(){n.beforeSend&&n.beforeSend()},a.url=r(n.url),a.success=function(e){c&&t.close(),n.success&&n.success(e)},a.error=function(e,r,a){o(e,r,a)||(n.error?n.error():t.msg("网络异常，请重试"))},
														a.serializable&&(a.contentType="application/json",a.data=JSON.stringify(a.data)),a}function r(t){var n={_t:(new Date).getTime()};return t+"?"+e.param(n)}function a(t){var r=e.ajax(n(t));return r}function o(e,t,n){return 401===e.status?(parent.layer.alert("您尚未登录或登录时间过长,请重新登录!",{icon:3,title:"登录提示"},function(){top.location="/"}),!0):void 0}var c,s={async:!0,dataType:"json",type:"get",serializable:!1};return{httpRequest:a,unAuthError:o}}),
		require(["component/layer","common/util","common/http","layer1","jquery.validate","jquery.serialize"],
				function(e,t,n){function r(){a(),o()}function a()
				{$("#sysUserForm").validate(
						{rules:{username:{required:!0}},
							submitHandler:function(){
							var t=$("#sysUserForm").serializeObject();
							n.httpRequest({
								url:"/admin/system/sysuser/save",
								serializable:!0,
								data:t,
								type:"post",success:function(t)
								{e.msg(t.msg,{time:1e3},
										function(){e.close({reload:!0})})}
							})
							}
						})
				}
				function o()
				{t.bindEvents([{el:"#cancel",event:"click",handler:function(){e.close()}}])}r()}),define("business/sysuser/edit_main",function(){});