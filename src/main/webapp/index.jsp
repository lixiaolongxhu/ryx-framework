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


  

	<!--测试extjs框架是否生效js  -->
	<script type="text/javascript">
	        function init() {
	        	//Ext.MessageBox.alert(" messageBOx 弹出消息")
	        	
	        	//进度条
	        	//Ext.MessageBox.progress("进度", "正在处理，请稍候...", "0%");
	        //	updateProgress(0);
	         
	        
	        //	Ext.MessageBox.wait("正在处理，请稍候...", "等待");
	        //    Ext.defer(function () {
	         //       Ext.MessageBox.close();
	         //   }, 3000);
	        
	        
	        /**
	        	var win = Ext.create("Ext.window.Window", {
	        	    title: "标题 - www.qeefee.com",
	        	    height: 300,
	        	    width: 400,
	        	    layout: "fit",
	        	    modal: true,
	        	    resizable: false,
	        	    maximizable: true,
	        	    minimizable: false,
	        	    closable: true,
	        	    tbar: [
	        	        { text: "保存", iconCls: "qicon-save" },
	        	        { text: "新建", iconCls: "qicon-add" }
	        	    ],
	        	    buttons: [
	        	        { text: "确定", iconCls: "qicon-accept" },
	        	        { text: "取消", iconCls: "qicon-delete" },
	        	    ],
	        	    items: []
	        	});
	        	win.show();
	        	
	        	*/
	        	
	        }
	        
	        var updateProgress = function (progress) {
	        	//Ext.MessageBox.alert("开始条用进度条");
	            if (progress >= 1) {
	                Ext.MessageBox.updateProgress(1, "处理完成");
	                return;
	            }

	            Ext.MessageBox.updateProgress(progress, Math.round(progress * 100) + "%");
	            Ext.defer(function () {
	                updateProgress(progress + 0.1);
	            }, 500);
	        }
	        
	        
	        Ext.onReady(function () {
	            Ext.create("Ext.container.Viewport", {
	                layout: "border",
	                items: [{
	                    title: "North Pannel",
	                    html: "上",
	                    region: "north",
	                    height: 100
	                }, {
	                    title: "West Pannel",
	                    html: "左",
	                    region: "west",
	                    width: 150
	                }, {
	                    title: "Main Pannel",
	                    html: "中",
	                    region: "center"
	                }]
	            });
	        });
	       
	</script>  
	

</head>

<body>

</body>
</html>
