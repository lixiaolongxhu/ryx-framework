<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>extjs4.1框架学习</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<!-- extjs 引入的样式文件 -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web-extjs/extjs4.1/resources/css/ext-all.css">
	<!-- extjs 启动器  bootstrap.js来自动添加extjs的框架js文件-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-extjs/extjs4.1/bootstrap.js"></script>
	<!-- extjs 中文化 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-extjs/extjs4.1/locale/ext-lang-zh_CN.js"></script>
	<!--  
 <script type="text/javascript" src="../common/goLogin.service"></script>	
 
 -->
	 <!--extjs-direct-spring 配制文件-->
		<script src="extDirectSpring/api.js"></script>
		
 <script type="text/javascript">


 Ext.Loader.setConfig({
 	enabled : true
 });



 //初始化快速提示
 Ext.QuickTips.init();

 //配置 direct 调用
 Ext.require('Ext.direct.*', function() {
 	Ext.direct.Manager.addProvider(Ext.app.REMOTING_API);
 });
 Ext.application({
		name : 'RYIVS',

		appFolder : 'sample',

		controllers : ['common.Login'],
		launch:function(){
			//登录界面UI配置
			Ext.Loader.setConfig({
				enabled : true
			});

			// 防止插件遮挡窗口
			Ext.useShims = true;

			// 全局屏蔽浏览器右键菜单
			Ext.getBody().on("contextmenu", Ext.emptyFn, null, {
				preventDefault : true
			});	
		//登录页面
		Ext.create('RYIVS.view.common.Login').show();
	}
});
</script>

  
  </script>
	<!--测试extjs框架是否生效js  -->
	<!--<script type="text/javascript">
	        function init() {
	            Ext.MessageBox.alert("ExtJS", "Hello ExtJS");
	           // Ext.create('sample.view.common.Login').show();
	        }
	        Ext.onReady(init);
	
	</script>  -->
	

</head>

<body>

</body>
</html>
