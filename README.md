# _Extjs-MVC-REST-Java-Hibernate Application Template_

_RIA application template runnable on openshift._

[Blog](http://www.bitfiction.com/blog/)

[Code in action on openshift cloud](http://mvctemplate-bitfiction.rhcloud.com)

_Example users_

1. `username:john password:123`

2. `username:mark password:456`

3. `username:peter password:789`

_Admin user_

1. `username:captain password:444`

## Project Info

_Includes sample:_
- _programatic authentication_
- _user-role-specific layout and menu_
- _forms and editable grid showcase_
- _ExtJS 4 MVC patterns_
- _ExtJS and Java communication via REST interface_
- _EJB controllers and sample Hibernate entities_
- _openshift cloud configuration with jboss AS 7.1 and mysql cartridge_

_Based on technologies:_
- _ExtJS 4.2.1_
- _Java_
- _Hibernate 4.2.0.Final_

_Tested on:_
- _[openshift jboss AS 7.1](http://mvctemplate-bitfiction.rhcloud.com)_
- _[locally on jboss EAP 6.x or jboss AS 7.x](https://github.com/bitfiction/extjs-mvc-rest-java-hibernate-application-template/issues/1)_

## Project Setup

_Following steps are required to run your own application instance in openshift cloud_ 

1. _Create [openshift](https://www.openshift.com/developers/java) account and application_

> $ rhc app create MyAppName jbossas-7

> $ rhc cartridge add mysql-5.1 -a MyAppName

2. _Clone this repo and add your openshift repo as remote repository_

> $ git clone _<https://github.com/bitfiction/extjs-mvc-rest-java-hibernate-application-template.git>_

> $ git remote add openshift -f _openshift-git-repo-url_

3. _Merge this repo to your openshift repository_

> $ git merge openshift/master -s recursive -X ours

4. _Push merged repo; this should trigger build process and make the app available at http://MyAppName-MyAccountName.rhcloud.com_

> $ git push openshift HEAD

## License

_The MIT License (MIT)_

_Copyright (c) 2013 BITFICTION_
