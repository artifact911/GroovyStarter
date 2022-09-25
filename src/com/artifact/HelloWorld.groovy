package com.artifact

import groovy.transform.PackageScope

import java.sql.DriverManager

class HelloWorld {

    // ; - не нежна
    Integer value

//    @PackageScope
    static void main(String[] args) {

        // () и ; - не нужны
        println "Hello World!"

        // Зачем нужны ClassLoader? Они и занимаются загрузкой объектов наших классов в MetaSpace соответственно каждый
        // объект класса Class знает о ClassLoader который его загрузил
        String value = "Hello World"
        Class<String> clazz = value.getClass()
        assert clazz == String.class

        // вернет null. - потому что это Bootstrap ClassLoader
        println clazz.getClassLoader()
        // а тут вернет PlatformClassLoader
        println DriverManager.class.getClassLoader()
        // вернет AppClassLoader
        println HelloWorld.class.getClassLoader()
    }
}
