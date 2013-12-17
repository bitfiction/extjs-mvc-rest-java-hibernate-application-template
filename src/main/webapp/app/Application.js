Ext.define('bitfictionMvcTemplate.Application', {
    name: 'bitfictionMvcTemplate',

    extend: 'Ext.app.Application',

    views: [
        'bitfictionMvcTemplate.view.LoginForm',
        'bitfictionMvcTemplate.view.grid.OneToManyEntityEditable',
        'bitfictionMvcTemplate.view.Header',
        'bitfictionMvcTemplate.view.HeaderBulk',
        'bitfictionMvcTemplate.view.Main',
        'bitfictionMvcTemplate.view.Menu',
        'bitfictionMvcTemplate.view.OneToOneEntity',
        'bitfictionMvcTemplate.view.OneToOneEntityEditableByAdmin'
    ],

    controllers: [
        'Main',
        'Util'
    ],

    stores: [
        'bitfictionMvcTemplate.store.OneToManyEntity',
        'bitfictionMvcTemplate.store.MenuStore',
        'bitfictionMvcTemplate.store.OneToOneEntity',
        'bitfictionMvcTemplate.store.OneToOneEntityEditableByAdmin'
    ]
});
