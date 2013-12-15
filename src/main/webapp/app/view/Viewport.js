Ext.define('bitfictionMvcTemplate.view.Viewport', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.mainviewport',
    requires:[
    	'Ext.layout.container.Column',
    	'Ext.layout.container.Accordion',
        'Ext.layout.container.Border',
        'bitfictionMvcTemplate.view.Header',
        'bitfictionMvcTemplate.view.Menu',
        'bitfictionMvcTemplate.view.Main',
        'bitfictionMvcTemplate.store.MenuStore'
    ],

    layout: {
        type: 'border'
    },

    items: [{
    	xtype: 'app-header',
    	id : 'app-header-id',
    	region : 'north',
		height : 52
    }, {
        xtype: 'app-menu',
        id: 'app-menu-id',
        store : {
        	xtype: 'menu-store',
        	id : 'menuStore'
        }
    }, {
        xtype: 'app-main',
        id: 'app-main-id',
        region : 'center'
    }]
    
});
