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

    def getInfo() {
        Closure closure = {
            println thisObject // == this (Student вызвал он и this)
            println owner // Класс, где определили closure (Student.class)
            println delegate // будет равно owner
            Closure second = {
                println thisObject // == this
                println owner // изменится скоуп, т.к. closure определили внутри другого closure
                println delegate // изменится скоуп, т.к. closure определили внутри другого closure
            } // declaration
            // тут мы можем подкручивать и делегировать
            second() // execution
        }
        closure
    }
}
