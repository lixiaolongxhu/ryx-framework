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
<h2>Basic DataGrid</h2>
	<p>The DataGrid is created from markup, no JavaScript code needed.</p>
	<div style="margin:20px 0;"></div>
	
	<table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:250px"
			data-options="singleSelect:true,collapsible:true,url:'',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">Item ID</th>
				<th data-options="field:'productid',width:100">Product</th>
				<th data-options="field:'listprice',width:80,align:'right'">List Price</th>
				<th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
				<th data-options="field:'attr1',width:250">Attribute</th>
				<th data-options="field:'status',width:60,align:'center'">Status</th>
			</tr>
		</thead>
	</table>
</body>
</html>