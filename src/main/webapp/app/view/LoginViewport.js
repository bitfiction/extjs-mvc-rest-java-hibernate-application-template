Ext.define('bitfictionMvcTemplate.view.LoginViewport', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.loginviewport',
    requires:[
    	'Ext.layout.container.Column',
        'Ext.layout.container.Border',
        'bitfictionMvcTemplate.view.HeaderBulk',
        'bitfictionMvcTemplate.view.LoginForm'
    ],

    layout: {
        type: 'border'
    },

    items: [{
    	xtype: 'app-header-bulk',
    	id : 'app-header-bulk-id',
    	region : 'north',
		height : 52
    }, {
    	xtype: 'panel',
    	id: 'login-form-panel-id',
    	region : 'center',
    	items: [{
	        xtype: 'login-form',
	        id: 'login-form-id'
	    }]
    }]
    
});
