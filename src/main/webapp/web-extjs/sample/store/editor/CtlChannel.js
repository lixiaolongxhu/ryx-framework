//store
Ext.define('RYIVS.store.editor.CtlChannel', {
	extend : 'Ext.data.Model',
	model:'RYIVS.model.editor.CtlChannel',
	proxy : {
		type : 'direct',
		api : {
			read : actionEquipment.readEqpCha,
			create : actionEquipment.createEqpCha,
			update : actionEquipment.updateEqpCha,
			destroy : actionEquipment.destroyEqpCha
		},
		extraParams:{
			type : 2
		},
		reader : {
			type : 'json',
			root : 'records',
		},

		writer : {
			type : 'json'
		}
	}
});