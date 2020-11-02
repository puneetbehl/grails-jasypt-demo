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

    CustomGrailsApplicationPostProcessor(GrailsApplicationLifeCycle lifeCycle, ApplicationContext applicationContext, Class... classes) {
        super(lifeCycle, applicationContext, classes)
    }

    @Override
    protected void loadApplicationConfig() {
        super.loadApplicationConfig()
        if (converter == null) {
            this.converter = (EncryptablePropertySourceConverter) applicationContext.getBean('encryptablePropertySourceConverter')
        }
        PropertySources propertySources = ((PropertySourcesConfig) ((DefaultGrailsApplication) this.grailsApplication).config).getPropertySources()
        converter.convertPropertySources((MutablePropertySources) propertySources)
        ((DefaultGrailsApplication) this.grailsApplication).config = new PropertySourcesConfig(propertySources)

    }

}
