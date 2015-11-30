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
	},{ region : 'center',
		xtype : 'tabpanel',
		activeTab : 0,
		items : [ {
			xtype : 'gridEditController'
		}
//			, {
//			xtype : 'gridEditEncoder'
//		}, {
//			xtype : 'streamServer'		
//		}, {
//			xtype : 'gridEditRfid'
//		}, {
//			xtype : 'gridEditAlarmRule'
//		}, /*{
//			xtype : 'eventRule'
//		},*/ {
//			xtype : 'gridEditLocator'
//		}, {
//			xtype : 'gisEditor'
//		}, {
//			xtype : 'gridEditUser'
//		}, {
//			xtype : 'gridEditUserAlarm'
//		} , {
//			xtype : 'gridEditUserLog'
//		} 
		]
	}],

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
