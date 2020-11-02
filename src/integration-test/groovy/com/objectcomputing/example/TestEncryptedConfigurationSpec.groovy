package com.objectcomputing.example

import grails.core.GrailsApplication
import grails.testing.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
class TestEncryptedConfigurationSpec extends Specification {

    GrailsApplication grailsApplication

    @Autowired
    PropertyServiceForJasyptStarter propertyServiceForJasyptStarter

    void "test encrypted config value"() {

        expect:
        propertyServiceForJasyptStarter.getProperty() == "Password@1"
        grailsApplication.config.getProperty('encrypted.property') == 'Password@1'
        grailsApplication.config.getProperty('grails.converters.encoding') == 'UTF-8'

    }
}
