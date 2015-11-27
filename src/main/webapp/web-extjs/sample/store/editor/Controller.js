//Model
Ext.define('RYIVS.store.editor.Controller', {
	extend : 'Ext.data.Model',
	model: 'RYIVS.model.editor.Controller',
	proxy : {
		type : 'direct',
		api : {
			read : actionEquipment.readEqp,
			create : actionEquipment.createEqp,
			update : actionEquipment.updateEqp,
			destroy : actionEquipment.destroyEqp
		},
		extraParams:{
			type : 2
		},
		reader : {
			type : 'json',
			root : 'records'
		},

		writer : {
			type : 'json'
		}
	}
});