<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
	<!-- easyui 依赖于jquery ,该文件必须最先加载 -->
	<script type="text/javascript" src="${path}/web-easyui/jquery/jquery-1.8.3.min.js"></script>
	<!-- easyui core begin -->
	<link rel="stylesheet" type="text/css" href="${path}/web-easyui/esayui1.42/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${path}/web-easyui/esayui1.42/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${path}/web-easyui/esayui1.42/demo.css">
	<script type="text/javascript" src="${path}/web-easyui/esayui1.42/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/web-easyui/esayui1.42/locale/easyui-lang-zh_CN.js"></script>
	<!-- easyui core end -->
	
	
<title>主页</title>
</head>
<body>
<body class="easyui-layout">
		<div data-options="region:'north'" split="true" border="false" style="overflow: hidden; height: 50px;
        background: #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
			<div id="welcomeDiv" style="float:right;padding:15px;border: 0px solid red">
				欢迎光临：${user.loginName}　<a href="#" onclick="systemManager.quit()">退出</a>
				<input type="hidden" id="userUuid" name="userUuid" value="${user.uuid }">
			</div>
		</div>
		<!-- 底部div -->
		<div data-options="region:'south',split:true" style="height:30px;background: #D2E0F2;">
			<div class="footer">版权所有：轻松宅智慧社区</div>
		</div>
		<!-- <div data-options="region:'east',split:true" title="East" style="width:100px;"></div> -->
		<!-- 左方菜单栏 -->
		<div data-options="region:'west'" title="菜单" style="width:16%;">
			
			<div class="easyui-accordion" style="width:92%;height:100%;">
				<c:forEach items="${permission}" var="e">
					<c:if test="${e.parentNo == '0'}">
		            	<div title="${e.name}" style="overflow:auto; padding: 10px;" icon="icon-edit">
		            		<c:forEach items="${permission}" var="m">
		            			<c:if test="${m.parentNo == e.no}">
		            				<ul>
		            					<li><div><a  url="${m.url}" >${m.name}</a></div></li>
		            				</ul>
		            			</c:if>
		            		</c:forEach>
		            	</div>
		            </c:if>
            	</c:forEach>
            </div>
		</div>
		<div data-options="region:'center',border:true" style="border: 0px solid red;">
			<div class="easyui-tabs" id="tabs" fit="true">
				
			</div>
		</div>
		<div id="Window"></div>
		<div id="WindowQuery"></div>
		<div id="menu" class="easyui-menu" style="width:150px;">
		    <div id="m-refresh">刷新</div>
		    <div class="menu-sep"></div>
		    <div id="m-closeall">全部关闭</div>
		    <div id="m-closeother">除此之外全部关闭</div>
		    <div class="menu-sep"></div>
		    <div id="m-close">关闭</div>
		</div>

</body>
</html>