/*
    This file is generated and updated by Sencha Cmd. You can edit this file as
    needed for your application, but these edits will have to be merged by
    Sencha Cmd when upgrading.
*/

Ext.application({
    name: 'bitfictionMvcTemplate',

    extend: 'bitfictionMvcTemplate.Application',
    
//    autoCreateViewport: true,
    
    launch: function () {
        console.log('init application...');
        
        // fix: http://stackoverflow.com/questions/15834689/extjs-4-2-tooltips-not-wide-enough-to-see-contents
        delete Ext.tip.Tip.prototype.minWidth;
        
        Ext.notifications.init();

        var title = Ext.get(Ext.dom.Query.selectNode('title'));
        title.update('Extjs4-mvc-rest-java-hibernate-application-template');
    }
});
