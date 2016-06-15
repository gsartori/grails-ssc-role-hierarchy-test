package test

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_TWO')
class TwoController {

    def index() {
        render 'Two Page'
    }

}
