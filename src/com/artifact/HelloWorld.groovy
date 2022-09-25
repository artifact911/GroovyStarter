package com.artifact

import groovy.transform.PackageScope

class HelloWorld {

    // ; - не нежна
    Integer value

//    @PackageScope
    static void main(String[] args) {
        // () и ; - не нужны
        println "Hello World!"
    }
}
