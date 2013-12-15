Ext.define('bitfictionMvcTemplate.model.OneToManyEntity', {
	extend : 'Ext.data.Model',

	fields : [{
		name : 'id',
		type : 'int'
	}, {
		name : 'exampleString',
		type : 'string'
	}, {
		name : 'exampleDouble',
		type : 'double'
	}, {
		name : 'exampleBool',
		type : 'bool'
	}, {
		name : 'exampleInt',
		type : 'int'
	}]
});
