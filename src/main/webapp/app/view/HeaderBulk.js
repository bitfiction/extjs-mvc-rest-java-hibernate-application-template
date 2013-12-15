Ext.define('bitfictionMvcTemplate.view.HeaderBulk', {
    extend: 'Ext.container.Container',
    alias : 'widget.appheaderbulk',
    requires:[
        'Ext.tab.Panel',
        'Ext.layout.container.Border'
    ],
    
    xtype: 'app-header-bulk',
    
    layout: {
        type : "hbox",
		align : "middle"
    },

    initComponent : function() {
		this.items = [{
			xtype : "component",
			cls : "app-header-title",
			html : "Extjs-MVC-REST-Java-Hibernate <font color='yellow'>Application Template</font>",
			flex : 1
		}];

		this.callParent();
	}
});
