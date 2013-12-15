Ext.define('bitfictionMvcTemplate.store.OneToOneEntityEditableByAdmin', {
	extend : 'Ext.data.Store',
	requires:[
        'bitfictionMvcTemplate.model.OneToOneEntityEditableByAdmin'
    ],
    model : 'bitfictionMvcTemplate.model.OneToOneEntityEditableByAdmin',
	xtype : 'oneToOneEntityEditableByAdmin-store',
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
			read : 'rest/oneToOneEntityEditableByAdmin/view',
			update : 'rest/oneToOneEntityEditableByAdmin/update'
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