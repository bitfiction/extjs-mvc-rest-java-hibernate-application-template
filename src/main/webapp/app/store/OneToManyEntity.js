Ext.define('bitfictionMvcTemplate.store.OneToManyEntity', {
	extend : 'Ext.data.Store',
	requires:[
        'bitfictionMvcTemplate.model.OneToManyEntity'
    ],
	model : 'bitfictionMvcTemplate.model.OneToManyEntity',
	xtype : 'oneToManyEntity-store',
//	autoSync : true,
	proxy : {
		type : 'ajax',
		filterParam : undefined,
		groupParam : undefined,
		pageParam : undefined,
		startParam : undefined,
		sortParam : undefined,
		limitParam : undefined,
		headers : {
			"Content-Type" : "application/json; charset=UTF-8"
		},
		api : {
			read : 'rest/oneToManyEntity/view',
			create : 'rest/oneToManyEntity/create',
			update : 'rest/oneToManyEntity/update',
			destroy : 'rest/oneToManyEntity/delete'
		},
		reader : new Ext.data.reader.Json({
			type : 'json',
			successProperty : 'success',
			messageProperty : 'message'
		}),
		actionMethods : {
			read : 'GET', // defaults to GET
			create : 'POST',
			update : 'POST',
			destroy : 'DELETE'
		},
		writer : new Ext.data.reader.Json({
			type : 'json',
			writeAllFields : true,
			allowSingle : false
		})
	}
});