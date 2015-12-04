<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>extjs4.2点击树形菜单生成tab页并访问发送请求</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- extjs 引入的样式文件 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/web-extjs/lib/extjs4.1/resources/css/ext-all.css"></link>
<!-- extjs 启动器  bootstrap.js来自动添加extjs的框架js文件-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web-extjs/lib/extjs4.1/bootstrap.js"></script>
<!-- extjs 中文化 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web-extjs/lib/extjs4.1/locale/ext-lang-zh_CN.js"></script>
<!--
		extjs-direct-spring 配制文件
	    extjs使用direct时必须引入,如果使用的是spring开发,那么配置对应的extDirectSpring插件.
	-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/ui/extDirectSpring/api-debug.js"></script>


<!-- 请求后台接口,跳转到指定界面(该文件应该在所有引入文件最后) -->
<!--<script type="text/javascript" src="${pageContext.request.contextPath}/ui/common/goLogin"></script>	 
      -->
<!--  测试extjs框架是否生效js
	<script type="text/javascript">
	        function init() {
	            Ext.MessageBox.alert("ExtJS", "Hello ExtJS");
	        }
	        Ext.onReady(init);
	
	</script>
	-->

<script type="text/javascript"  src="${pageContext.request.contextPath}/frameTreeMenu.js" ></script>

</head>
<body >
	
</body>
</html>