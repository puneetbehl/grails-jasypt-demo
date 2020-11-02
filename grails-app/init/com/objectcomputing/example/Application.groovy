package com.objectcomputing.example

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertySourceConverter
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import grails.boot.GrailsApp
import grails.boot.config.GrailsApplicationPostProcessor
import grails.boot.config.GrailsAutoConfiguration

import groovy.transform.CompileStatic
import org.springframework.context.annotation.Bean

@CompileStatic
@EnableEncryptableProperties
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    @Bean
    GrailsApplicationPostProcessor grailsApplicationPostProcessor() {
        EncryptablePropertySourceConverter converter = (EncryptablePropertySourceConverter) applicationContext.getBean('encryptablePropertySourceConverter')
        new CustomGrailsApplicationPostProcessor(this, applicationContext, converter, classes() as Class[])
    }
}
