package com.artifact.lesson18

class TraitRunner {

    static void main(String[] args) {

        def student1 = new StudentWithTrait(firstName: "Petr", lastName: "Petrov", age: 18, id: 2)
        println student1

        StudentWithTrait student2 = ['Sveta', 'Svetikova', 30]
        println student2

        // можем получить все поля у объекта в виде Map плюс там еще будет поле Class
        student1.properties.each { println it }

        // добавили миксин из класса
        String.mixin(TraitRunner.class)

        // теперь у стринги есть метод добавленный миксином
        "Ivan".printStr()
    }

    static def printStr(String self) {
        println "It is mixin $self"
    }
}
