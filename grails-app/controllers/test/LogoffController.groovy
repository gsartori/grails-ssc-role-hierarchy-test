package test

import grails.plugin.springsecurity.annotation.Secured

@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
class LogoffController {

    def index() {
        redirect uri: '/logoff'
    }

}
