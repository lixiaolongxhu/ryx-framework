/**
 * 
 */
Ext.define('RYIVS.model.common.LeftMenu', {
	extend : 'Ext.data.Model',

	fields: [
	         {name: 'id', type: 'int'},
	         {name: 'parentId', type: 'int'}
	       
	     ],
	     
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