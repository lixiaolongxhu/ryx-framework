// 4 model 和 store 配置
		var store = new Ext.data.Store({
			// Store所对应的模型
			model : 'RYIVS.model.editor.Controller',
			autoSync : true,
			// 是否自动加载
			autoLoad : true

		});

/**
 * 控制器编辑
 */
Ext.define('RYIVS.view.editor.Controller', {
	requires : [ 'RYIVS.view.common.GridEditBase' ],
	 requires: [
        'Ext.grid.column.Action'
    ],
	extend : 'Ext.panel.Panel',
	alias : 'widget.gridEditController',
	layout : 'border',
	iconCls : 's_equipment',
	title : '控制器编辑',
	items : [ {
		region : 'center',
		xtype : 'gridEditBase',
		title : '控制器',
		iconCls : 's_equipment',
		// 定义 model
		model:'RYIVS.model.editor.Controller',
		// 定义 autoload
		autoload : false,
		// 主表id
		itemId : 'master',
		// 定义插入的缺省值
		newRecord : {
			type : 1001
		},
		// 定义 colums
		columns : [ {
			text : 'ID',
			dataIndex : 'id'
		}, {
			text : '设备编号',
			dataIndex : 'no',
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 1,
				autoStripChars : true,
				allowDecimals : false
			}
		}, 
		{	text :"访问地址headerGroup",
			columns: [
				{
				text : 'IP地址',
				dataIndex : 'ip',
				width    : 175,
				flex : 1,
				editor : {
					allowBlank : false
				}
			}, {
				text : '端口',
				dataIndex : 'port',
				flex : 1,
				width    : 75,
				editor : {
					allowBlank : false,
					xtype : 'numberfield'
				}
			}]
		
		}, {
			text : '名称',
			width    : 85,
			dataIndex : 'name',
			flex : 1,
			
			editor : {
				allowBlank : false
			}
		},
		{
                menuDisabled: true,
                sortable: false,
                xtype: 'actioncolumn',
                width: 50,
                items: [{
                    icon   : 'lib/res/icon/add.png',  // Use a URL in the icon config
                    tooltip: 'Sell stock',
                    handler: function(grid, rowIndex, colIndex) {
                    //	alert(grid);
                        var rec = store.getAt(rowIndex);
                        alert(rec);
                        alert("Sell " + rec.get('id'));
                    }
                }, {
                    getClass: function(v, meta, rec) {          // Or return a class from a function
                        if (rec.get('id') < 0) {
                            return 'alert-col';
                        } else {
                            return 'buy-col';
                        }
                    },
                    getTip: function(v, meta, rec) {
                        if (rec.get('id') < 0) {
                            return 'Hold stock';
                        } else {
                            return 'Buy stock';
                        }
                    },
                    handler: function(grid, rowIndex, colIndex) {
                        var rec = store.getAt(rowIndex);
                        alert((rec.get('id') < 0 ? "Hold " : "Buy ") + rec.get('id'));
                    }
                }]
            }
		
		
		
		]
	},
		{
		// 底部面版
		xtype : 'gridEditBase',
		region : 'south',
		height : 300,
		title : '控制器通道',
		iconCls : 's_equipmentcha',
		// 定义 model
		model:'RYIVS.model.editor.CtlChannel',
		// 定义 autoload
		autoload : false,
		// 定义拖动后，添加到资源是那类
		dropClass : 2,
		// 主表的id
		master : 'master',
		// 外键名称
		fkey : 'eid',
		// 定义 colums
		columns : [ {
			text : 'ID',
			dataIndex : 'id'
		}, {
			text : '控制器ID',
			dataIndex : 'eid',
			flex : 1
		}, {
			text : '通道编号',
			dataIndex : 'node',
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 1,
				autoStripChars : true,
				allowDecimals : false
			}
		}, {
			text : '通道类型',
			dataIndex : 'type',
			flex : 1,
			editor : {
				allowBlank : false,
				xtype : 'combo',
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.ctrChaResType,
				queryMode : 'local',
				emptyText : '资源类型'
			},
			renderer : function(val) {
				//return ry.util.getResCssClass(val);
				return '<image src="lib/res/layer/' + val + '.png">';
			}
		}, {
			text : '通道名称',
			dataIndex : 'name',
			flex : 1,
			editor : {
				allowBlank : false
			}
		}, {
			text : '资源',
			dataIndex : 'resid',
			flex : 1,
			renderer : function(val) {
				var rst = 0;
				if (val) {
					rst = 1;
				} else {
					rst = 0;
				}
				return ry.constant.trans(rst, ry.constant.yntype);
			}
		}],
		
		// 使能拖放
		viewConfig : {
			plugins : {
				ddGroup : 'ddgEquipment',
				ptype : 'gridviewdragdrop',
				enableDrop : false
			},
			emptyText:'<div style="text-align:center; padding:50px; color:gray">没有数据可显示</div>',
	        	deferEmptyText:false
			}
	} ]

	
});
