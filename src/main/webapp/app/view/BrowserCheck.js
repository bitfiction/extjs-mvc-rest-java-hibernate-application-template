Ext
		.define(
				"bitfictionMvcTemplate.view.BrowserCheck",
				{
					extend : 'Ext.window.Window',
					alias : 'widget.browsercheck',
					requires : [ 'Ext.form.Panel' ],
					title : 'Kontrola internetového prehliadača',
					autoShow : true,
					width : 400,
					closable : false,
					resizable : false,
					layout : 'fit',
					items : [ {
						xtype : 'panel',
						padding : 10,
						border : 0,
						items : [ {
							xtype : 'label',
							html : '<p>Pre prístup k aplikácií <b>pasportizacia.sk</b> je potrebný bezpečný prehliadač.</p>'
									+ '<p>Stiahnite si prosím jeden z bezpečných internetových prehliadačov:<ul>'
									+ '<li><a href="http://www.mozilla.org/sk/firefox/fx">Mozilla Firefox</a></li>'
									+ '<li><a href="http://www.google.com/intl/sk/chrome/browser/">Google Chrome</a></li></ul></p>'
									+ '<p>Po stiahnutí a nainštalovaní prehliadača si prostredníctvom neho otvorte stránku <b>www.pasportizacia.sk</b></p>'
						} ]
					} ]
				})