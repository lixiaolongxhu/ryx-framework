/*
 * 管理员用户的界面框架
 */
Ext.define('RYIVS.view.common.Admin', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.layerAdmin',
	region : 'center',
	layout : 'border',
	items : [{
        title: "North Pannel",
        html: "上",
        region: "north",
        height: 100
    },{
		xtype : 'layerLeftMenu',
		region : 'west',
		width : 300
	},
    
     {
        title: "Main Pannel",
        html: "中",
        region: "center"
    }  ],

	bbar : [ {
		dock : 'bottom',
		border : 0,
		width : "100%",
		xtype : 'footToolBar'
	} ],

	initComponent : function() {
		this.callParent(arguments);
	}

});
