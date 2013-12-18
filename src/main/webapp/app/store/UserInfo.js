Ext.define('bitfictionMvcTemplate.store.UserInfo', {
	extend : 'Ext.data.Store',
	requires:[
        'bitfictionMvcTemplate.model.UserInfo'
    ],
	model : 'bitfictionMvcTemplate.model.UserInfo',
	xtype : 'userInfo-store',
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
			read : 'rest/userInfo/view'
		},
		reader : new Ext.data.reader.Json({
			type : 'json',
			successProperty : 'success',
			messageProperty : 'message'
		}),
		actionMethods : {
			read : 'GET' // defaults to GET
		}
	}
});