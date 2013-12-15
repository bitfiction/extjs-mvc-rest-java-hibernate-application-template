Ext.define('bitfictionMvcTemplate.view.Main', {
    extend: 'Ext.container.Container',
    requires:[
        'Ext.tab.Panel',
        'Ext.layout.container.Card'
    ],
    
    xtype: 'app-main',

    layout: {
        type: 'card'
    },
	
	region : 'center', // this is what makes this panel into a region within
	margins : '2 5 5 0',
	activeItem : 0,
	border : false,
	
	items: [],
	
	initComponent : function() {
		var appViews = [];
		Ext.Object.each(bitfictionMvcTemplate.controller.Main.getAppViews(), function(name, appView) {
			appViews.push(appView);
		});
		
		this.items = appViews;
		this.callParent();
	}

});
