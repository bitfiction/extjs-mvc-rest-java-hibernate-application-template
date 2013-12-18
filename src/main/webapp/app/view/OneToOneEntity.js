Ext.define('bitfictionMvcTemplate.view.OneToOneEntity', {
	extend : 'Ext.form.FieldContainer',
	xtype : 'oneToOneEntity-fieldcontainer',
	fieldLabel : 'One to One Entity data',
	padding : 10,
	initComponent : function() {
		var me = this;
		Ext.applyIf(me, {
			items : [{
				xtype : 'textfield',
				name: 'exampleString',
				fieldLabel : 'Example String',
				size: 30,
				msgTarget: 'qtip'
			}]
		});

		me.callParent(arguments);
	}
});