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
/**
 * 程序主入口
 */
Ext.onReady(function() {
			/**
			 * 上,panel.Panel
			 */
			this.topPanel = Ext.create('Ext.panel.Panel', {
						region : 'north',
						height : 55
					});
			/**
			 * 左,panel.Panel
			 */
			this.leftPanel = Ext.create('Ext.panel.Panel', {
						region : 'west',
						title : '导航栏',
						width : 230,
						layout : 'accordion',
						collapsible : true
					});
			/**
			 * 右,tab.Panel
			 */
			this.rightPanel = Ext.create('Ext.tab.Panel', {
						region : 'center',
						layout : 'fit',
						tabWidth : 120,
						items : [{
									title : '首页'
								}]
					});
			/**
			 * 组建树
			 */
			var buildTree = function(json) {
				//alert(json);
				return Ext.create('Ext.tree.Panel', {
							
						
							 border: false,  //边框
				              
				               enableDD: true,
				               rootVisible: false,  //隐藏根节点
				               useArrows:true, //树节点使用箭头
				              containerScroll: true,
				               collapsible: false,
				               autoScroll: false,                
				                //singleExpand:true   //展示单个子节点，其它的子节点合并。
							store : Ext.create('Ext.data.TreeStore', {
								
				                // 数据代理
							    nodeParam : 'parentId',  //这个属性是异步加载主要特征，通过该节点去请求子节点
							 // 根节点的参数值是0
				                defaultRootId : 0,
				               
							    proxy : {
							    	type : 'ajax',
							 	    url : 'ui/manage/user/permissionMenu',
							 	 	folderSort: true,
					                sorters: [{
					                    property: 'name',
					                    direction: 'ASC'
					                }]
							    },
							    reader : {
								      type:'json'
								    },
							 // 设置根节点
								  root : {
								    //text : '根节点',
								     //id : '-1',
								    expanded : true
								  },
								// 属性域
					               fields: ['name', 'id', 'parentId','url',"text"]
										
							})
							//,
						//	listeners : {
						//		'itemclick' : function(view, record, item,
						//				index, e) {
						//			var id = record.get('id');
						////			var text = record.get('name');
						//			var leaf = record.get('url');
						////			if (leaf) {
							//			alert('id-' + id + ',text-' + text
						//						+ ',leaf-' + leaf);
						//			}
						//		},
							//	scope : this
						//	}
						});
			};
			/**
			 * 加载菜单树
			 */
			Ext.Ajax.request({
						url : 'ui/manage/user/permissionMenu',
						success : function(response) {
							var json = Ext.JSON.decode(response.responseText)
							
							
							leftPanel.add(buildTree(json))
							Ext.each(json, function(el) {
										var panel = Ext.create(
												'Ext.panel.Panel', {
													id : el.id,
													title : el.name,
													layout : 'fit'
												});
									//	alert(el);
								
										
									//	panel.add(buildTree(el));
									leftPanel.add(panel);
							});
						},
						failure : function(request) {
							Ext.MessageBox.show({
										title : '操作提示',
										msg : "连接服务器失败",
										buttons : Ext.MessageBox.OK,
										icon : Ext.MessageBox.ERROR
									});
						},
						method : 'post'
					});
			/**
			 * Viewport
			 */
			Ext.create('Ext.container.Viewport', {
						layout : 'border',
						renderTo : Ext.getBody(),
						items : [this.topPanel, this.leftPanel, this.rightPanel]
					});
		});

	
	
	</script>
</head>
<body >
	
</body>
</html>