package com.artifact.lesson17

class OopRunner {

    static void main(String[] args) {

        def student = new Student()          // создадим юзера
        student.firstName = "Ivan"          // setFirstName хотя сеттеров мы не создавали

        // getFirstName но геттеров мы не создавали
        println student.firstName
        // можно обратиться как к массиву
        println student['firstName']
        // можно опустить скобки и обратиться через точку
        println student.'firstName'
        // или так, но это не рекомендуется. Это мы обращаемя напрямую к полю без геттеров и сеттеров
        println student.@firstName


        // можем создавать объект мередавая Map:
        def student1 = new Student(firstName: "Petr", lastName: "Petrov", age: 18)

        // надо переопределить toString при помощи Groovy анноташки @ToString
        println student1

        // можно использовать "принуждение"
        // но тогда мы должны создать соответствующий конструктор
        // либо заюзать @TupleConstructor  иу нас создадутся конструкторы на все случаи жизни
        // но только для того, чтобы это был наш юзер, а не массив, нам придется ЯВНО это указать в типе ссылки (не def)
        Student student2 = ['Sveta', 'Svetikova', 30]
        println student2

        // теперь я хочу получить две переменных из юзера
        // но для этого мува нам нужен метод getAt и мы его переопределим
        // getAt() принимает на вход Integer, который является индексом нашего поля. Т.е. 0-требуем имя, 1-фамилию
        def (fn, ln) = student2
        println fn
        println ln

        // и конечно же мы можем юзать *-spread-Оператор
        assert [student1, student2].collect { it.firstName } == ['Petr', 'Sveta']          // без *
        assert [student1, student2]*.firstName == ['Petr', 'Sveta']                                      // c *

        // можно продолжать и дальше ставить * если объект сложный
//        [student1, student2]*.firstName*.

        // а можно * опустить
        assert [student1, student2].firstName == ['Petr', 'Sveta']
    }
}
