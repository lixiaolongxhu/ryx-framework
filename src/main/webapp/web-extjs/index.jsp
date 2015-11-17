<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>extjs4.1框架学习</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<!-- extjs 引入的样式文件 -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web-extjs/lib/extjs4.1/resources/css/ext-all.css"></link>
	<!-- extjs 启动器  bootstrap.js来自动添加extjs的框架js文件-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-extjs/lib/extjs4.1/bootstrap.js"></script>
	<!-- extjs 中文化 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-extjs/lib/extjs4.1/locale/ext-lang-zh_CN.js"></script>	
	<!--
		extjs-direct-spring 配制文件
	    extjs使用direct时必须引入,如果使用的是spring开发,那么配置对应的extDirectSpring插件.
	-->
	<script  type="text/javascript" src="${pageContext.request.contextPath}/ui/extDirectSpring/api-debug.js"></script>
      
    
    <!-- gis相关(openlayer+js)，必须按照顺序进行添加 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-extjs/lib/Openlayers2.13/OpenLayers.js"></script>  
      
    <!-- 请求后台接口,跳转到指定界面(该文件应该在所有引入文件最后) -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/ui/common/goLogin"></script>	 

	<!--  测试extjs框架是否生效js
	<script type="text/javascript">
	        function init() {
	            Ext.MessageBox.alert("ExtJS", "Hello ExtJS");
	        }
	        Ext.onReady(init);
	
	</script>
	-->
	
	<script type="text/javascript">
	
	var map = null;
	function init(){
		<!-- create map -->
		var options={controls:[new OpenLayers.Control.KeyboardDefaults()]};
		//添加键盘控制的控件
		map = new OpenLayers.Map('map',options);
		//创建地图对象map,这里的map是用来显示的div的idvar
		bounds = new OpenLayers.Bounds();//设置边界
		bounds.extend(new OpenLayers.LonLat(0,0));//扩展边界
		bounds.extend(new OpenLayers.LonLat(500,500));
		bounds.toBBOX();
		var size = new OpenLayers.Size(400,400);
		var wms = new OpenLayers.Layer.Image('b','web-extjs/lib/res/layer/map.png',bounds,size);
		//创建image类型的图层map.addLayer(wms);
		//将图层添加到地图里面map.setBaseLayer(wms);
		//设置图层为基层map.zoomToMaxExtent();
		<!-- add mapControl tools -->
		//下面几个事添加map控件的，根据自己需要添加
		map.addControl(new OpenLayers.Control.PanZoomBar({position:new OpenLayers.Pixel(2,15)}));
		map.addControl(new OpenLayers.Control.ScaleLine());
		map.addControl(new OpenLayers.Control.OverviewMap());
		map.addControl(new OpenLayers.Control.Navigation());
	}
	
	</script>

</head>

<body onload="init()"><div id="map" style="width:500px;height:500px;"></div></body>
</html>
