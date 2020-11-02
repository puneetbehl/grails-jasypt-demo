package com.objectcomputing.example

class BootStrap {

    def init = { servletContext ->
        Book.withNewSession {
            new Book(title: "The Stand").save()
        }
    }
    def destroy = {
    }
}
