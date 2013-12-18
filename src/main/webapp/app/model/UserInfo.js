Ext.define('bitfictionMvcTemplate.model.UserInfo', {
	extend : 'Ext.data.Model',
	requires:[
        'bitfictionMvcTemplate.model.User',
        'bitfictionMvcTemplate.model.BaseEntity',
        'bitfictionMvcTemplate.model.OneToOneEntity'
    ],
	fields : [{
		name : 'userId',
		mapping: 'user.id',
		type : 'int'
	}, {
		name : 'userName',
		mapping: 'user.username',
		type : 'string'
	}, {
		name : 'baseEntityId',
		mapping: 'baseEntity.id',
		type : 'int'
	}, {
		name : 'oneToOneEntityId',
		mapping: 'oneToOneEntity.id',
		type : 'int'
	}, {
		name : 'exampleString',
		mapping: 'oneToOneEntity.exampleString',
		type : 'string'
	}]
});
