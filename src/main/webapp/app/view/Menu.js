Ext.define('bitfictionMvcTemplate.view.Menu', {
    extend: 'Ext.tree.Panel',
    requires:[
        'Ext.tab.Panel',
        'bitfictionMvcTemplate.store.MenuStore'
    ],
    xtype: 'app-menu',
    region : 'west',
	collapsible : false,
	split : true,
	width : 250,
	title : 'Main menu',
	rootVisible : false,
	autoScroll : true,
	useArrows: true,
    colspan: 2,

    initComponent : function() {
		this.store = new bitfictionMvcTemplate.store.MenuStore({
			id : 'menuStore'
		});
		this.callParent();
	}
});
