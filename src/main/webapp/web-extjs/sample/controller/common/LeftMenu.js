//左菜单
Ext.define('RYIVS.controller.common.LeftMenu', {
	extend : 'Ext.app.Controller',
	models:['RYIVS.model.common.LeftMenu'],
	stores:['RYIVS.store.common.LeftMenu'],
	
	views :['RYIVS.view.common.LeftMenu'],
	init: function() {
		         this.control({
		             'viewport > panel': {   //这里是css选择器的形式
		               render: this.onPanelRendered    //当页面进行渲染的时候就会促发该应用程序的onPanelRendered方法。
		              }
		         });
		    },
		 
		    onPanelRendered: function() {
		         console.log('The panel was rendered');
		}
	
});
