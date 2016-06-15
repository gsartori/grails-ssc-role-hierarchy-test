package test

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ONE')
class OneController {

    def index() {
        render 'One Page'
    }

}
