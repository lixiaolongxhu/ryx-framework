//Model
Ext.define('RYIVS.model.editor.CtlChannel', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'eid', 'type', 'node', 'uid', 'name', 'ext1', 'ext2', 'resid' ],
	validations : [ {
		type : 'length',
		field : 'name',
		min : 1
	} ]
});