Ext.define('bitfictionMvcTemplate.view.grid.OneToManyEntityEditable', {
	extend : 'Ext.grid.Panel',
	requires : ['Ext.selection.CellModel', 'Ext.grid.*', 'Ext.data.*', 'Ext.util.*', 'Ext.form.*', 'bitfictionMvcTemplate.model.OneToManyEntity'],
	xtype : 'oneToManyEntity-editable',
	initComponent : function() {
		this.cellEditing = new Ext.grid.plugin.CellEditing({
			clicksToEdit : 1
		});
		Ext.apply(this, {
			plugins : [this.cellEditing],
			columns : [{
				header : 'Example String',
				dataIndex : 'exampleString',
				editor : {
					allowBlank : true
				}
			}, {
				header : 'Example Double',
				dataIndex : 'exampleDouble',
				editor : {
					xtype : 'numberfield',
				}
			}, {
				header : 'Example Int',
				dataIndex : 'exampleInt',
				editor : {
					xtype : 'numberfield'
				}
			}, {
				xtype : 'checkcolumn',
				header : 'Example Bool',
				dataIndex : 'exampleBool'
			}, {
				xtype : 'actioncolumn',
				width : 25,
				sortable : false,
				items : [{
					icon : 'resources/img/delete.gif',
					tooltip : 'Remove',
					scope : this,
					handler : this.onRemoveClick
				}]
			}],
			selModel : {
				selType : 'cellmodel'
			},
			tbar : [{
				text : 'Add',
				tooltip: 'Adds new row',
				icon: 'resources/img/drop-add.gif',
				scope : this,
				handler : this.onAddClick
			}, {
				text : 'Save',
				tooltip: 'Saves to server',
				name: 'save',
				icon: 'resources/img/accept.png',
				disabled: true,
				scope : this,
				handler : this.onSaveClick
			}]
		});
		this.callParent();
	},
	
	onAddClick : function() {
		// Create a model instance
		var rec = new bitfictionMvcTemplate.model.OneToManyEntity({
			exampleString : '',
			exampleDouble : 0,
			exampleInt : 0,
			exampleBool : false
		});

		this.getStore().insert(0, rec);
		this.cellEditing.startEditByPosition({
			row : 0,
			column : 0
		});
	},

	onRemoveClick : function(grid, rowIndex) {
		this.getStore().removeAt(rowIndex);
	},

	onSaveClick : function() {
		me = this;
		// disable the button always, even when there are no changes to sync (can happen - add and immediatelly remove row and click save - no sync callback called)
		this.down('button[name=save]').setDisabled(true);
		this.getStore().sync({
		    success: function(){
		    	Ext.notifications.msg('Done', 'Table data were saved to the server');
		  		// disable the button also after callback - this has to be done to disable button after the update callback enables it
		  		me.down('button[name=save]').setDisabled(true);
		    },
		    failure: function(){
		    	Ext.notifications.msg('Error', 'Something bad happened');
		    },
		    scope: this
		});
	},
	
	onAddUpdateDelete : function() {
		this.down('button[name=save]').setDisabled(false);
	}
});