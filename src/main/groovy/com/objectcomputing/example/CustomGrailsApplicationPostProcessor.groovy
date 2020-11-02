package com.objectcomputing.example


import com.ulisesbocchio.jasyptspringboot.EncryptablePropertySourceConverter
import grails.boot.config.GrailsApplicationPostProcessor
import grails.core.DefaultGrailsApplication
import grails.core.GrailsApplicationLifeCycle
import org.grails.config.PropertySourcesConfig
import org.springframework.context.ApplicationContext
import org.springframework.core.env.MutablePropertySources
import org.springframework.core.env.PropertySources

class CustomGrailsApplicationPostProcessor extends GrailsApplicationPostProcessor {

    EncryptablePropertySourceConverter converter

    CustomGrailsApplicationPostProcessor(GrailsApplicationLifeCycle lifeCycle, ApplicationContext applicationContext, EncryptablePropertySourceConverter converter, Class... classes) {
        super(lifeCycle, applicationContext, classes)
        this.converter = converter
    }

    @Override
    protected void loadApplicationConfig() {
        super.loadApplicationConfig()
        PropertySources propertySources = ((PropertySourcesConfig) ((DefaultGrailsApplication)grailsApplication).config).getPropertySources()
        ((EncryptablePropertySourceConverter) applicationContext.getBean('encryptablePropertySourceConverter')).convertPropertySources((MutablePropertySources) propertySources)
        ((DefaultGrailsApplication)grailsApplication).config = new PropertySourcesConfig(propertySources)

    }
}
