Ext.define("bitfictionMvcTemplate.view.LoginForm", {
	extend : 'Ext.window.Window',
	alias : 'widget.loginform',
	xtype: 'login-form',
	requires : [ 'Ext.form.Panel' ],
	title : 'Login form',
	autoShow : true,
	height : 150,
	width : 300,
	closable : false,
	resizable : false,
	layout : 'fit',
	items : [ {
		xtype : 'form',
		bodyPadding : 5,
		defaults : {
			xtype : 'textfield',
			anchor : '100%'
		},
		items : [ {
			fieldLabel : 'Your e-mail:',
			blankText : 'Enter your e-mail here',
			name : 'username',
			allowBlank : false,
			listeners: {
                specialkey: function(field, e){
                    if (e.getKey() == e.ENTER) {
                    	var formDialog = field.up('loginform');
                        formDialog.fireLogin(field, e);
                    }
                }
            }
		}, {
			fieldLabel : 'Password:',
			inputType : 'password',
			blankText : 'Enter password here',
			name : 'password',
			allowBlank : false,
			listeners: {
                specialkey: function(field, e){
                    if (e.getKey() == e.ENTER) {
                        var formDialog = field.up('loginform');
                        formDialog.fireLogin(field, e);
                    }
                }
            }
		}],
		buttons : [ {
			text : 'Login',
			formBind : true,
			disabled : true,
			handler : function(b, e) {
				var formDialog = b.up('loginform');
                formDialog.fireLogin(b, e);
			} // handler
		} // login button
		]
	// buttons
	} // form
	],
	fireLogin: function(comp, e) {
		var formDialog = comp.up('loginform');
		var form = comp.up('form');

		// fire custom event for the controller to handle
		formDialog.fireEvent('login', formDialog, form, form
				.getValues());
	}
// items
});