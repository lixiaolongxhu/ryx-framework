/**
 * 页面底部状态条
 */
Ext.define('RYIVS.view.common.FootToolBar', {
	extend : 'Ext.toolbar.Toolbar',
	alias : 'widget.footToolBar',
	items : [ {
		xtype : 'tbseparator' //extjs 定义的分割符
	}, {
		xtype : 'label',
		text : '当前用户：' +'李小龙'//appCfg.uname
	}, {
		xtype : 'tbseparator'
	}, {
		xtype : 'button',
		icon : 'lib/res/icon/user_edit.png',
		text : '修改密码',
		handler : function(b, e) {
			Ext.create('RYIVS.view.common.EditPassword').show();
		}
	}, {
		xtype : 'tbseparator'
	},{
		xtype : 'button',
		icon : 'lib/res/icon/control.png',
		text : '本地参数设置',
		handler : function(b, e) {
			Ext.create('RYIVS.view.common.UserFolder').show();
		}
	},{
		xtype : 'tbseparator'
	}, {
		xtype : 'button',
		iconCls : 's_exit',
		text : '退出系统',
		handler : function(b, e) {
			Ext.Ajax.request({
				url : 'controller/logout',
				success : function(response) {
					location.href = "index.jsp";
				}
			});
		}
	} ],
	initComponent : function() {
		this.callParent(arguments);
	}
});
