package com.artifact.lesson25

import com.artifact.lesson17.Student

class Closure2Runner {

    static void main(String[] args) {
        // мы можем написать closure и там делать что угодно
        // но что если я хочу привязать этот блок кода к кому-то студенту? Т.е. как будто эта функция принадлежит
        // объекту класса Student и тогда я смог бы изменить его имя например
        Closure closure = {
            firstName = "Sveta"
        }

        println closure.thisObject // это объект к которому мы обращаемся
        println closure.owner       // обращаемся к объексту, где определили closure
        println closure.delegate    // по умолчанию owner и используется когда мы вручную хотим его поменять

        def student = new Student("Ivan", "Ivanov", 29)
        println student

        // обычный паттерн делегирования: все запросы которые приходит к closure мы делегируем студенту
        // delegateStrategy: сначала он искал поле в owner (а это Closure2Runner), а потом пошел в delegate
        // это поведение по-умолчанию и мы можем его изменить: Closure.DELEGATE_FIRST
//        closure.delegate = student

        // искать сначала в делегате (можно разное выбирать)
//        closure.resolveStrategy = Closure.DELEGATE_FIRST
//        closure()

        // что бы не юзать эти три строчки, есть with()
        student.with closure

        println student

        // написали новую функцию в student и хотим посмотреть
        // student.getInfo() возвращает closure и нам надо его запустить:

        // так
//        student.getInfo().call()
        // или так
        student.getInfo()()
    }
}
