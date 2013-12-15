Ext.define('bitfictionMvcTemplate.store.OneToOneEntity', {
	extend : 'Ext.data.Store',
	requires:[
        'bitfictionMvcTemplate.model.OneToOneEntity'
    ],
	model : 'bitfictionMvcTemplate.model.OneToOneEntity',
	xtype : 'oneToOneEntity-store',
	autoSync : true,
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
			read : 'rest/oneToOneEntity/view',
			update : 'rest/oneToOneEntity/update'
		},
		reader : new Ext.data.reader.Json({
			type : 'json',
			successProperty : 'success',
			messageProperty : 'message'
		}),
		actionMethods : {
			read : 'GET', // defaults to GET
			update : 'POST'
		},
		writer : new Ext.data.reader.Json({
			type : 'json',
			writeAllFields : true,
			allowSingle : false
		})
	}
});