/**
 * 定位器管理
 */
Ext.define('RYIVS.controller.editor.Controller', {
	extend : 'Ext.app.Controller',
	models :[ 'RYIVS.model.editor.Controller', 'RYIVS.model.common.LeftMenu','RYIVS.model.editor.CtlChannel' ],
	views : [ 'RYIVS.view.editor.Controller', 'RYIVS.view.common.LeftMenu' ],

	refs : [ {
		selector : 'gridEditController > gridEditBase[master="master"]',
		ref : 'ctlChannelGrid'
	}, {
		selector : 'layerLeftMenu',
		ref : 'layerLeftMenu'
	} ],

	init : function() {
		this.control({
			'gridEditController' : {
				activate : this.onActivate,
				afterrender : this.afterRender
			}
		});
		controller.controller = this;
		
		
	},

	// 当标签激活时
	onActivate : function(pa, options) {
		pa.items.items[0].store.load();
	},

	// 只调用一次
	afterRender : function(panel, eOpts) {
		Ext.direct.Manager.on('event', this.onDirectEvent, this);
	},

	onDirectEvent : function(event, provider, eOpts) {
		/*// 编码器修改，刷新资源列表
		if ((event.action == "actionController") && (event.method == "destroy")) {
			this.getResGrid().store.load();
		}
		// 编码器通道修改，刷新资源列表
		if ((event.action == "actionCtlChannel") && (event.method == "destroyEqp")) {
			this.getResGrid().store.load();
		}*/
		
		// 编码器通道修改，刷新资源列表
		if ((event.action == "actionEquipment") && (event.method == "destroyEqpCha")) {
			this.getLayerLeftMenu().store.load();
		}
		
		if ((event.action == "actionEquipment") && (event.method == "destroyEqp")) {
			this.getLayerLeftMenu().store.load();
		}
	},

	//外部接口
	slaverReload : function() {
		this.getCtlChannelGrid().loadByMasterId();
	}
});
