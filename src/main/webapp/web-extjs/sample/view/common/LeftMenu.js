/* 
 * 通用的资源Grid
 * 这里只提供资源列表的基本框架
 * 该资源列表可以用户管理员界面和监控界面，具体的行为由相关的Controller进行控制
 */

Ext.define('RYIVS.view.common.LeftMenu', {

	requires : [ 'RYIVS.view.common.GridEditBase' ],
	requires : [ 'RYIVS.controller.common.GridDragPlugin'],
	extend : 'RYIVS.view.common.GridEditBase',
	
	alias : 'widget.layerLeftMenu',
	iconCls: 's_resource',
	title : '资源',
	hideHeaders: true,
	store : 'RYIVS.store.common.LeftMenu',
	

//	columns: [
//	            {header: 'Name',  dataIndex: 'name',  flex: 1},
//	           {header: 'Email', dataIndex: 'email', flex: 1}
//		       ],
//	return '<image src="lib/res/layer/' + val + '.png">'
	
	
	columns : [ {
		text : '资源图片',
		width : 40,
		dataIndex : 'type',
		align : 'right',
		renderer : function(val) {
			return '<image src="lib/res/layer/' + val + '.png">'
		}
	}, {
		text : '资源列表',
		width : 40,
		sortable : true,
		dataIndex : 'name',
		menuDisabled : true,
		flex : 1,
		editor : {
			allowBlank : false
		}

	} ],


	features : [ Ext.create('Ext.grid.feature.Grouping', {
		groupHeaderTpl : [ '{groupValue:this.formatValue}: 共 ({rows.length}) 个', {
			formatValue : function(value) {
				return ry.constant.trans(value, ry.constant.resourceType);
				//return "value"+value;
			}
		} ]
	}) ],
	
	
	// 得到Res的Store
	getResStore : function() {
		return this.store;
	},
	
	//配置插件引入
	viewConfig : {
		plugins : {
			ddGroup : 'ddgEquipment', //定义拖动组
			ptype : 'gridDragPlugin',
			enableDrop : true,
			enableDrag : true
		}
	},
	
	
	// 是否使能拖放
	enableDrag : function(en) {
		
		
		var dragPlugin = this.getView().getPlugin();
		if (en) {
			dragPlugin.enable();
		} else {
			dragPlugin.disable();
		}
	},

	// 是否允许删除
	enableDelete : function(en) {
		if (en) {
			this.query('button[itemId="buttonDelete"]')[0].show();
		} else {
			this.query('button[itemId="buttonDelete"]')[0].hide();
		}
	},
	
	initComponent : function() {
		this.callParent(arguments);
		this.store.group('type');
		this.query('button[itemId="buttonAdd"]')[0].hide();

		// 禁止编辑
		this.on('beforeedit', function(e) {
			return false;
		});

		// 不使用拖放
		this.enableDrag(false);
		
		controller.layerLeftMenu = this;

	}
});
