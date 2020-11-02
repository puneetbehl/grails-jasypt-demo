package com.objectcomputing.example
//import com.ulisesbocchio.jasyptspringboot.EncryptablePropertySourceConverter

import com.ulisesbocchio.jasyptspringboot.configuration.EncryptablePropertyResolverConfiguration
import grails.boot.GrailsApp
import grails.boot.config.GrailsApplicationPostProcessor
import grails.boot.config.GrailsAutoConfiguration
import groovy.transform.CompileStatic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

@CompileStatic
@Import([EncryptablePropertyResolverConfiguration.class])
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    @Bean
    GrailsApplicationPostProcessor grailsApplicationPostProcessor() {
        new CustomGrailsApplicationPostProcessor(this, applicationContext, classes() as Class[])
    }
}
