package com.artifact.lesson23

import com.artifact.lesson17.Student

class MissingMethodRunner {

    static void main(String[] args) {
        def student = new Student(age: 18)

        // вызовем у стедента метод и поле которых не существует
        // получаем missingException
//        student.test()
        println student.abc

        // тогда довавим студенту спец зарезервированный метод methodMissing() который вызывается через мета-класс
        // если он не нашел у себя в коллеции вызываемый нами метод

        // для полей (property) то же самое но метод propertyMissing()

        // хочу сделать свою реализацию, если я вызвал метод, которого нет
        // Spring-data, StudentRepository
        student.findByAge(90)
    }
}
