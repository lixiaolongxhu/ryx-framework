/**
 * tab 页测试
 */
Ext.define('RYIVS.view.editor.TabTest', {
	requires : [ 'RYIVS.view.common.GridEditBase' ],
	extend : 'Ext.panel.Panel',
	alias : 'widget.tabTest',
	layout : 'border',
	iconCls : 's_equipment',
	title : 'tab 页测试',
	items : [ {
		title: "North Pannel",
        html: "上",
        region: "north",
        height: 100}
        ,{ region : 'center',
		xtype : 'tabpanel',
		activeTab : 0,
		items : [ {
			xtype : 'gridEditController'
		}

		]
	}
 ]
        
 });