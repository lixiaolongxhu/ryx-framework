<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>extjs4.1框架学习</title>
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


<!-- gis相关(openlayer+js)，必须按照顺序进行添加 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web-extjs/lib/Openlayers2.13/OpenLayers.js"></script>

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

 <script type="text/javascript">
        var map;
        function init(){
            var options = { "controls": [] };
            map = new OpenLayers.Map("map", options);
            var wms = new OpenLayers.Layer.WMS("openlayer",
            		 "web-extjs/lib/res/layer/map.png",
                { "layers": "basic" });

            // 加载底图
            map.addLayer(wms);
            
            // 初始化空间
            map.addControl(new OpenLayers.Control.ZoomPanel());
            map.addControl(new OpenLayers.Control.Navigation());
            map.addControl(new OpenLayers.Control.MousePosition());

            // 创建feature
            var features = new Array(50);
            for (var i = 0; i < 50; i++){
                features[i] = new OpenLayers.Feature.Vector(
                    new OpenLayers.Geometry.Point((360 * Math.random()) - 180, (180 * Math.random()) - 90),
                    { "type": 5 + parseInt(Math.random() * 5) });
            }

            // 创建地图符号化
            var myStyles = new OpenLayers.StyleMap({
                "default": new OpenLayers.Style({
                    pointRadius: "${type}",
                    fillColor: "#ffcc66",
                    strokeColor: "#ff9933",
                    strokeWith: 2,
                    graphicZIndex:1
                }),
                "select": new OpenLayers.Style({
                    fillColor: "#66ccff",
                    strokeColor: "#3399ff",
                    graphicZIndex: 2
                })
            });

            // 创建图层，并添加feature
            var points = new OpenLayers.Layer.Vector("Points", {
                styleMap: myStyles,
                rendererOptions: { zIndexing: true }
            });
            points.addFeatures(features);

            // 加载要素图层
            map.addLayer(points);

            // 添加选择要素工具
            var select = new OpenLayers.Control.SelectFeature(points, { hover: true });
            map.addControl(select);
            select.activate();

            map.zoomToMaxExtent();
        }
    </script>
</head>
<body onload="init()">
    <div id="map" style="width:500px;height:400px"></div>
</body>
</html>
