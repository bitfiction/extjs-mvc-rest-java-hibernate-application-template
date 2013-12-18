Ext.define('bitfictionMvcTemplate.view.OneToOneEntityEditableByAdmin', {
	extend : 'Ext.form.FieldContainer',
	xtype : 'oneToOneEntityEditableByAdmin-fieldcontainer',
	fieldLabel : 'One to One Entity Editable By Admin data',
	padding : 10,
	initComponent : function() {
		var me = this;
		Ext.applyIf(me, {
			items : [{
				xtype : 'textfield',
				name: 'exampleString',
				fieldLabel : 'Example String',
				size: 50,
				msgTarget: 'qtip'
			}]
		});
		
		me.callParent(arguments);
	}
});