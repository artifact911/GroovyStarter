package com.artifact.lesson17

import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor
class Student {
    String firstName
    String lastName
    Integer age

    def getAt(Integer index) {
        index == 0 ? firstName : lastName
    }

    // принимает имя вызываемого нами метода
    // и массив аргументов, который мы передали в метод
    def methodMissing(String name, Object args) {
        println "missing method $name is invoked: $args"
        def field = name - 'findBy'
        def fieldValue = this."$field"
        println "select * from Student where $field = $fieldValue"
    }

    def propertyMissing(String name) {
        println "missing property $name"
        "default value"
    }
}
