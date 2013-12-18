Ext.define('bitfictionMvcTemplate.view.grid.UserInfo', {
	extend : 'Ext.grid.Panel',
	requires : ['Ext.grid.*', 'Ext.data.*', 'Ext.util.*', 'Ext.form.*', 'bitfictionMvcTemplate.model.UserInfo'],
	xtype : 'userInfo-grid',
	initComponent : function() {
		Ext.apply(this, {
			columns : [{
				header : 'User',
				columns: [{
					header : 'User Id',
					dataIndex : 'userId',
					flex: 1
				}, {
					header : 'User Name',
					dataIndex : 'userName',
					flex: 1
				}]
			}, {
				header : 'Base Entity',
				columns: [{
					header : 'Base Entity Id',
					dataIndex : 'baseEntityId',
					flex: 1
				}]
			}, {
				header : 'One To One Entity',
				columns: [{
					header : 'One To One Entity Id',
					dataIndex : 'oneToOneEntityId',
					flex: 1
				}, {
					header : 'One To One Entity Example String',
					dataIndex : 'exampleString',
					flex: 1
				}]
			}],
			viewConfig: {
				enableTextSelection: true
			}
		});
		this.callParent();
	}
});