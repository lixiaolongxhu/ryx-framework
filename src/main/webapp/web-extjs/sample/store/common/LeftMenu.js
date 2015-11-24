
Ext.define('RYIVS.store.common.LeftMenu', {
	extend : 'Ext.data.Store',
	requires: 'RYIVS.model.common.LeftMenu',
	models: 'RYIVS.model.common.LeftMenu',
	
	proxy : {
		type : 'direct',
		api : {
			read : actionPermission.read,
			create : actionPermission.create,
			update : actionPermission.update,
			destroy : actionPermission.destroy
		},
		reader : {
			root : 'records',// 返回结果集
			type : 'json'
		}
	},
    groupField: 'parentId'
	
});