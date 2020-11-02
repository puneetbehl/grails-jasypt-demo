package com.objectcomputing.example

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment

class PropertyServiceForJasyptStarter {

    @Value('${encrypted.property}')
    private String property;

    String getProperty() {
        return property;
    }

    String getPasswordUsingEnvironment(Environment environment) {
        return environment.getProperty("encrypted.property");
    }
}
