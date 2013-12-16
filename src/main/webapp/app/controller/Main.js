Ext.define('bitfictionMvcTemplate.controller.Main', {
    extend: 'Ext.app.Controller',
    
    requires:[
        'Ext.tab.Panel',
        'Ext.layout.container.Card',
        'Ext.ux.data.PagingMemoryProxy',
        'bitfictionMvcTemplate.view.BrowserCheck',
        'bitfictionMvcTemplate.view.Viewport',
        'bitfictionMvcTemplate.view.LoginForm',
        'bitfictionMvcTemplate.view.LoginViewport',
        'bitfictionMvcTemplate.store.OneToManyEntity',
        'bitfictionMvcTemplate.store.OneToOneEntityEditableByAdmin',
        'bitfictionMvcTemplate.store.OneToOneEntity'
    ],
    
    refs: [
       {
           ref: 'loginviewport',
           selector: 'loginviewport'
       },
       {
           ref: 'mainviewport',
           selector: 'mainviewport'
       }
    ],
    
    init: function () {
    	
    	var me = this;
    	
    	if (!Ext.isGecko && !Ext.isChrome) {
        //if (!Ext.isIE) {
        	Ext.create('bitfictionMvcTemplate.view.BrowserCheck');
    	} else {
	        Ext.Ajax.request({
			    url: 'checklogin',
			    success: function(response) {
					var data = Ext.decode(response.responseText);
					if (data.isLoggedIn == true) {
						// create main UI
						Ext.create('bitfictionMvcTemplate.view.Viewport');
						me.initViewport();
					} else {
						// create login form
						Ext.create('bitfictionMvcTemplate.view.LoginViewport');
						Ext.getCmp('login-form-panel-id').body.setStyle('background','#DFEAF2');
					}
			    }
		    });
		}
    	  
    	this.control({
		   "loginform": {
		     login: this.onLogin
		    }
		});
    },
	
	onLogin: function(loginDialog, loginForm, loginCredentials) {
	    
		var me = this;
	 
		// authenticate
		Ext.Ajax.request({
		    url: 'login',
		    timeout: 30000,
		    params: {
		    	username: loginCredentials.username,
		    	password: loginCredentials.password
		    },
		    success: function(response) {
		    	  var data = Ext.decode(response.responseText);
		    	  if (data.success == true) {
				      // destroy login dialog
				      loginDialog.destroy();
				      //destroy login viewport
				      var loginviewport = me.getLoginviewport();
        			  loginviewport.destroy();
				      // load main UI
				      Ext.create('bitfictionMvcTemplate.view.Viewport');
				      me.initViewport();
		    	  } else {
		    		  Ext.notifications.msg('Warning', 'E-mail or password is incorrect.');
		    	  }
		   }
	   });
	},
	
	onSyncStores: function(title, msg, includingForms) {
	    
		this.syncStores(title, msg, includingForms);
	 
	},
	
	onLogout: function() {
		window.location.href = "http://" + window.location.host + "/mvctemplate/logout";
	},
	
	loadMenu: function() {
		if (bitfictionMvcTemplate.controller.Main.adminMode == true) {
			Ext.StoreManager.lookup('menuStore').setProxy({
				type : 'ajax',
				url : 'json/tree-data-admin.json'
			});
		} else {
			Ext.StoreManager.lookup('menuStore').setProxy({
				type : 'ajax',
				url : 'json/tree-data-user.json'
			});
		}
		
		Ext.StoreManager.lookup('menuStore').load({
			callback : function(records, options, success) {
				if (success) {
					var appMenu = Ext.getCmp('app-menu-id');
					appMenu.getRootNode().expand(true);
					appMenu.getSelectionModel().select(1);
					appMenu.getSelectionModel().on('select', function(selModel, record) {
						if (record.get('leaf')) {
							Ext.getCmp('app-main-id').layout.setActiveItem(record.getId() + '-panel');
						}
					});
				}
			}
		});
	},
	
	syncStores:function(title, msg, includingForms) {
	
		if (bitfictionMvcTemplate.controller.Main.adminMode == true) {
			return;
		}
		
		// sync grid stores - sync calls request only if model contains dirty records
		var oneToManyEntityStore = Ext.StoreManager.lookup('oneToManyEntityStore');
		oneToManyEntityStore.sync({ 
			success: function() { 
				oneToManyEntityStore.onDataSaved(); 
			} 
		});
		
		if (includingForms == true) {
			// TODO: sync forms
		}
		
		Ext.Ajax.request({
			url : 'rest/user/keepalive',
			success : function(response) {
				Ext.notifications.msg(title, msg);
			}
		});
		
	},
	
	initViewport : function() {
		
		var me = this;
		
		Ext.MessageBox.show({
           msg: 'Loading...',
           progressText: 'Loading...',
           width:300,
           wait:true,
           waitConfig: {interval:400}
        });
		
		Ext.Ajax.request({
			url : 'rest/user/properties',
			success : function(response) {
				var data = Ext.decode(response.responseText);
				if (data.isAdminMode == true) {
					bitfictionMvcTemplate.controller.Main.adminMode = true;
				} else {
					bitfictionMvcTemplate.controller.Main.adminMode = false;
				}
				if (data.userId) {
					bitfictionMvcTemplate.controller.Main.userId = data.userId;
				}
				if (data.username) {
					bitfictionMvcTemplate.controller.Main.username = data.username;
					Ext.getCmp("logged-in-user").update('<b>Logged in: ' + bitfictionMvcTemplate.controller.Main.username + '</b>');
				}
				
				me.loadMenu();
				
				if (bitfictionMvcTemplate.controller.Main.adminMode) { // admin mode loading
					var oneToOneEntityEditableByAdminStore = new bitfictionMvcTemplate.store.OneToOneEntityEditableByAdmin({
						id: 'oneToOneEntityEditableByAdminStore',
					});
					Ext.StoreManager.lookup('oneToOneEntityEditableByAdminStore').load({
						callback : function(records, options, success) {
					  		if (success) {
					   			Ext.getCmp('menuItemAdmin1-panel').loadRecord(records[0]);
					   			Ext.MessageBox.hide();
			   					Ext.notifications.msg('Welcome Admin', 'Extjs 4 MVC Template is ready!');
					   		}
					   	}
					});
				} else {
					var oneToOneEntityStore = new bitfictionMvcTemplate.store.OneToOneEntity({
						id: 'oneToOneEntityStore',
					});
					Ext.StoreManager.lookup('oneToOneEntityStore').load({
						callback : function(records, options, success) {
					  		if (success) {
					   			Ext.getCmp('menuItem2-panel').loadRecord(records[0]);
					   			Ext.MessageBox.hide();
								Ext.notifications.msg('Welcome', 'Extjs 4 MVC Template is ready!');
					   		}
					   	}
					});
					Ext.StoreManager.lookup('oneToManyEntityStore').load({
						callback : function(records, options, success) {
					  		if (success) {
					   		}
					   	}
					});
				}
			}
		});

		this.control({
		   "appheader": {
		    	syncStores: this.onSyncStores,
		    	logout: this.onLogout
		    }
		});
		
	},
    
	statics: {
		
		adminMode : true,

		userId : -1,

		username : '',

        getAppViews: function() {
			return {
				menuItem1 : {
					id : 'menuItemGeneral-panel',
					name : 'menuItemGeneral-panel',
					xtype : 'tabpanel',
					title : 'Information',
					items : [{
						title : 'Information about the app',
						padding : 10,
						autoScroll : true,
						items: [{
							xtype : 'fieldset',
							title : '<b>News</b>',
							width : 500,
							items : [{
								xtype: 'container',
								padding: '10 0 15 10',
								items: [{
									xtype: 'label',
									style: 'color: red',
									html: '<b>15.1.2014</b> Highlighted news title.'
								}]
							}, {
								xtype: 'container',
								padding: '10 0 10 10',
								items: [{
									xtype: 'label',
									html: '<b>10.1.2014</b> Regular  news title.'
								}]
							}]
					 	}]
					}]	
				},
				menuItem2 : {
					id : 'menuItem2-panel',
					name : 'menuItem2-panel',
					xtype : 'form',
					autoScroll : true,
					items : [{
						xtype : 'tabpanel',
						title : 'Tab Panel',
						activeTab : 0,
						autoScroll : true,
						style : 'background-color:#dfe8f6; ',
						items : [{
							title : 'One To One Entity',
							padding : 10,
							items : [{
								xtype: 'oneToOneEntity-fieldcontainer',
								name: 'user-entity-fieldcontainer'
							}, {
								xtype : 'button',
								scale : 'large',
								text : 'Save',
								handler : function(button, e) {
									var theForm = button.up('form[name=menuItem2-panel]').getForm();
									var record = theForm.getRecord();
									var errors = record.validate();
									var success = errors.isValid();
									
									if (success) {
										theForm.updateRecord(record);
									}
								}
							}]
						}]
					}]	
				}, 
				menuItem3 : {
					id : 'menuItem3-panel',
					name : 'menuItem3-panel',
					xtype : 'form',
					items : [{
						xtype : 'tabpanel',
						title : 'Tab Panel',
						activeTab : 0,
						style : 'background-color:#dfe8f6; ',
							items : [{
							title : 'One To Many Entity ',
							autoScroll : true,
							items : [{
								xtype : 'oneToManyEntity-editable',
								id: 'oneToManyEntityGrid',
								store : new bitfictionMvcTemplate.store.OneToManyEntity({
									id : 'oneToManyEntityStore',
									listeners : {
										add: function( store, records, index, eOpts ) {
											store.onDataAffected();
										},
										update: function( store, record, operation, modifiedFieldNames, eOpts ) {
											store.onDataAffected();
										}, 
										remove: function( store, record, index, isMove, eOpts ) {
											store.onDataAffected();
										}
									},
									onDataAffected : function() {
										Ext.getCmp('oneToManyEntityGrid').onAddUpdateDelete();
									},
									onDataSaved : function() {
										Ext.getCmp('oneToManyEntityGrid').down('button[name=save]').setDisabled(true);
									}
								})
							}]
						}]
					}]
				},
				menuItemAdmin1 : {
					id : 'menuItemAdmin1-panel',
					name : 'menuItemAdmin1-panel',
					xtype : 'form',
					autoScroll : true,
					items : [{
						xtype : 'tabpanel',
						title : 'Tab Panel',
						activeTab : 0,
						autoScroll : true,
						style : 'background-color:#dfe8f6; ',
						items : [{
							title : 'One To One Entity Editable By Admin',
							padding : 10,
							items : [{
								xtype: 'oneToOneEntityEditableByAdmin-fieldcontainer',
								name: 'admin-entity-fieldcontainer'
							}, {
								xtype : 'button',
								scale : 'large',
								text : 'Save',
								handler : function(button, e) {
									var theForm = button.up('form[name=menuItemAdmin1-panel]').getForm();
									var record = theForm.getRecord();
									var errors = record.validate();
									var success = errors.isValid();
									
									if (success) {
										theForm.updateRecord(record);
									}
								}
							}]
						}]
					}]
				}
			};
		}
	}
    
});
