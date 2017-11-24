function print_init() {
	try {
		if (factory && factory.object) {
			factory.printing.header = "";
			factory.printing.footer = "";
			var left = 10;
			var top = 10;
			var right = 10;
			var bottom = 10;
			factory.printing.leftMargin = left;
			factory.printing.topMargin = top;
			factory.printing.rightMargin = right;
			factory.printing.bottomMargin = bottom;
			if (factory.printing.leftMargin != left) { //英寸=25.4毫米
				factory.printing.leftMargin = left / 25.4;
				factory.printing.topMargin = top / 25.4;
				factory.printing.rightMargin = right / 25.4;
				factory.printing.bottomMargin = bottom / 25.4;
			}
		}else{
			PageSetup_Default();
		}
	} catch(e) {}
}

var HKEY_Root,HKEY_Path,HKEY_Key; 

HKEY_Root="HKEY_CURRENT_USER"; 

HKEY_Path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\"; 

//设置网页打印的页眉页脚为空 
function PageSetup_Default() { 
		try { 
			var Wsh=new ActiveXObject("WScript.Shell"); 
			
			HKEY_Key="header"; 
			
			Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,""); 
			
			HKEY_Key="footer"; 
			
			Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,""); 
			
			HKEY_Key="margin_bottom"; 
			
			Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.395"); 
			
			HKEY_Key="margin_left"; 
			
			Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.395"); 
			
			HKEY_Key="margin_right"; 
			
			Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.395"); 
			
			HKEY_Key="margin_top"; 
			
			Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.395");
			
		} 
		catch(e){
			alert("由于您的浏览器不支持打印控件，系统可能会使用系统自带的打印程序进行打印。注意：请点击页面顶部\"打印设置\"按钮或在浏览器菜单\"文件\"->\"页面设置\"中设置页眉页脚为空，且上下左右页边距为10。如不设置，可能会导致打印格式异常。");
		} 	
}

function Print() {
	try {
		if (!factory || !factory.object) {
			if(document.all.WebBrowser){
				document.all.WebBrowser.ExecWB(6, 1);
			}else{
				if(confirm("您的浏览器不支持打印控件，是否需要尝试使用系统自带的打印程序进行打印？")){
					window.print();
				}
			}
		}
		else {
			factory.printing.Print(true);
		}
	} catch(e) {}
}

function PrintSetup() {
	try {
		if (!factory || !factory.object) {
			if(document.all.WebBrowser){
				document.all.WebBrowser.ExecWB(8, 1);
			}
		}
		else {
			factory.printing.PageSetup();
		}
	}catch(e) {
	}
}

function PrintView() {
	try {
		if (!factory || !factory.object) {
			if(document.all.WebBrowser){
				document.all.WebBrowser.ExecWB(7, 1);
			}
		}
		else {
			factory.printing.Preview()
		}
	}catch(e) {}
}
