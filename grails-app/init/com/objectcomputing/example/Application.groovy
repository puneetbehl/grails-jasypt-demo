package com.objectcomputing.example

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertySourceConverter
import com.ulisesbocchio.jasyptspringboot.configuration.EnableEncryptablePropertiesBeanFactoryPostProcessor

//import com.ulisesbocchio.jasyptspringboot.EncryptablePropertySourceConverter
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import com.ulisesbocchio.jasyptspringboot.configuration.EncryptablePropertyResolverConfiguration
import grails.boot.GrailsApp
import grails.boot.config.GrailsApplicationPostProcessor
import grails.boot.config.GrailsAutoConfiguration

import groovy.transform.CompileStatic
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.core.env.ConfigurableEnvironment

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
