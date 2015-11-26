
Ext.define('RYIVS.store.common.LeftMenu', {
	extend : 'Ext.data.Store',

	model:'RYIVS.model.common.LeftMenu',
	autoLoad: true,
//	data: [
//	        {name: 'Ed',    email: 'ed@sencha.com'},
//	         {name: 'Tommy', email: 'tommy@sencha.com'}
//	 ]
	proxy : {
		type : 'direct',
		api : {
			read : actionResource.read,
			create : actionResource.create,
			update : actionResource.update,
			destroy : actionResource.destroy
		},
		reader : {
			root : 'records',// 返回结果集
			type : 'json'
		}
	},
	groupField: 'type'
});