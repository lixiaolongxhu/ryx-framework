<%@ page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

//管理人员UI配置
Ext.Loader.setConfig({
	enabled : true
});

//初始化快速提示
Ext.QuickTips.init();

//配置 direct 调用
Ext.require('Ext.direct.*', function() {
	Ext.direct.Manager.addProvider(Ext.app.REMOTING_API);
});

//应用程序入口
Ext.application({
	name : 'RYIVS',

	appFolder : 'sample',

	controllers : ['common.Admin',"common.FootToolBar"],


	launch : function() {

		Ext.Loader.setConfig({
			enabled : true
		});

		// 防止插件遮挡窗口
		Ext.useShims = true;

		// 全局屏蔽浏览器右键菜单
		Ext.getBody().on("contextmenu", Ext.emptyFn, null, {
			preventDefault : true
		});

		// 建立主界面
		/**
		Ext.container.Viewport代表浏览器窗口的整个区域，将document body作为渲染对象，
		它会根据浏览器窗口的大小自动调整自身的尺寸，在一个页面中只允许出现一个Viewport实例。
		此外它没有提供对滚动条的支持，如果需要使用滚动条需要在其子面板中进行设置.
		示例:http://www.cnblogs.com/libingql/archive/2012/04/10/2440445.html
		*/
		Ext.create('Ext.container.Viewport', {
			layout : 'border',
			items : [{
				xtype : 'layerAdmin'
			}]
		});

	}
});

