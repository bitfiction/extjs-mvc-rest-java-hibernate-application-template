Ext.define('bitfictionMvcTemplate.view.Header', {
    extend: 'Ext.container.Container',
    alias : 'widget.appheader',
    requires:[
        'Ext.tab.Panel',
        'Ext.layout.container.Border'
    ],
    
    xtype: 'app-header',
    
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
		}, {
			xtype : "container",
			padding : '0 10 0 0',
			items : [{
				xtype : "component",
				id : "logged-in-user"
			}]
		}, {
			xtype : "container",
			padding : '0 10 0 0',
			items : [{
				xtype : 'button',
				scale : 'large',
				text : 'Logout',
				tooltip: 'Logs you out.',
				width : 150,
				handler : function(b, e) {
					// before loging out...
					var appheader = b.up('appheader');
					appheader.fireEvent('syncStores', 'Data sync done', 'Your changes were saved to server.', false);
					Ext.MessageBox.show({
						title : 'Logout?',
						msg :  'Do you wish to logout?',
						buttons : Ext.MessageBox.YESNO,
						buttonText : {
							yes : "Logout",
							no : "Stay logged in"
						},
						fn : function(btn) {
							if (btn == "yes") {
								var appheader = b.up('appheader');
								appheader.fireEvent('logout');
							}
						}
					});
				}
			}]
		}];

		this.callParent();
	}
});
