//左菜单
Ext.define('RYIVS.controller.common.LeftMenu', {
	extend : 'Ext.app.Controller',
	models : [ 'common.LeftMenu'],
	
	views : [ 'common.LeftMenu' ],
	init : function() {

	},
	// 得到Res的Store
	getResStore : function() {
		return this.getResGrid().store;
	},
});
