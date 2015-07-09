/**
 * 原样打出调试信息(执行HTML代码)
 * 
 * @param {String} m	控制台消息
 */
var Debug = function(m){
	try{
		var d = new Date();
		DEBUG_WINDOW.document.write("<div style='border:gray solid 1px;margin:5px;padding:5px;width:100%;word-wrap:break-word;word-break:break-all;font-size:12px;'>["+d.toLocaleString()+" : "+d.getMilliseconds() +" --- " + (d - DEBUG_TIME) + "]"+m+"</div>");
		DEBUG_WINDOW.focus();
		DEBUG_WINDOW.window.document.body.scrollTop = DEBUG_WINDOW.window.document.body.scrollHeight;
		DEBUG_TIME = d;
	} catch (e){
		DEBUG_WINDOW = window.open ("","","width=500px,height=400px,left=" + (window.screen.width - 510) + ",top=" + (window.screen.height - 500) + ",resizable=1,scrollbars=1");

		DEBUG_WINDOW.document.write('<h1>Debug Message</h1><textarea style="border:black solid 1px;width:100%;height:70px;"></textarea><input type="button" value="Execute" onclick="try{this.nextSibling.innerHTML = eval(\'window.opener.\' + this.previousSibling.innerHTML);}catch(e){}"><XMP style="border:gray solid 1px;margin:5px;padding:5px;width:100%;word-wrap:break-word;word-break:break-all;font-size:12px;"></XMP><hr size=1/>');
		DEBUG_TIME = d;
		Debug(m);
	}
	
	DEBUG_WINDOW.window.focus();
};

/**
 * 打出调试信息(不执行HTML代码)
 * 
 * @param {String} m	控制台消息
 */
var D = function(m){
	//Debug("<XMP>" + m + "</XMP><hr />(IN Function:<XMP>"+arguments.caller.callee+")</XMP>");
	//DM("IN Function:"+arguments.caller.callee,m);
	Debug("<XMP>" + m + "</XMP>");
};

/**
 * 打出调试信息(不执行HTML代码,支持多个参数传入,做为一次时间计算打出)
 * 
 * @param {String,String...} 控制台消息,可传入多个
 */
var DM = function(){
	var s = "";
	for(var i = 0 , j = arguments.length ; i < j ; i ++){
		s += "<XMP>" + arguments[i] + "</XMP>";
	}
	Debug(s);
};

/**
 * 打出调试信息(不执行HTML代码,支持多个参数传入,每个参数作为独立时间计算打出)
 * 
 * @param {String,String...} 控制台消息,可传入多个
 */
var DL = function(){
	for(var i = 0 , j = arguments.length ; i < j ; i ++){
		Debug("<XMP>" + arguments[i] + "</XMP>");
	}
};

/**
 * 页面卸载或者刷新时关闭调试控制台
 */
window.attachEvent("onunload",function(){
	try{DEBUG_WINDOW.close();}catch(e){};
});