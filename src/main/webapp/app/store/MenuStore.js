Ext.define('bitfictionMvcTemplate.store.MenuStore', {
	extend : 'Ext.data.TreeStore',
	xtype : 'menu-store',
	autoLoad : false,
	autoSync : false,
	root : {
		expanded : false
	}
});